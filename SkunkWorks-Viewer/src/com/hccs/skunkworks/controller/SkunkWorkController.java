package com.hccs.skunkworks.controller;

import com.hccs.skunkworks.Main;
import com.hccs.skunkworks.forms.MainFrame;
import com.hccs.skunkworks.forms.tablemodels.RegistrationTableModel;
import com.hccs.skunkworks.jpa.controllers.RegistrationQuries;
import com.hccs.skunkworks.jpa.models.MachineBean;
import com.hccs.skunkworks.jpa.models.RegistrationBean;
import com.hccs.skunkworks.jpa.models.PersonBean;
import com.hccs.skunkworks.model.TaskBean;
import com.hccs.util.DateUtilities;
import com.hccs.util.StringUtilities;
import com.hccs.util.Task;
import com.hccs.util.TaskThread;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.prefs.Preferences;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;

public class SkunkWorkController {

    private ATYPE aType;
    private MainFrame form;
    private Preferences preferences;
    private RegistrationBean selectedRegBean;
    private RegistrationQuries regQuries;
    private RegistrationTableModel regTModel;
    private final List<TaskBean> dirtyWorks
            = DirtyWorkController.INSTANCE.getAllDirtyWorks();

    private enum ATYPE {

        REGISTER,
        UPDATE,
        ACTIVE,
        INACTIVE,
        DUPLICATE,
        EXPIRED
    }

    private enum STATUS {
        //<editor-fold defaultstate="collapsed" desc="Activator Status...">

        FSERVER {
            @Override
            public String toString() {
                return "Fetching from server...";
            }
        },
        LOADING {
            @Override
            public String toString() {
                return "Loading Devices...";
            }
        },
        ACTIVATE {
            @Override
            public String toString() {
                return "Activating... ";
            }
        },
        EMPTY_TRASH {
            @Override
            public String toString() {
                return "Deleting Info...";
            }
        }
        //</editor-fold>
    }

    public SkunkWorkController() {
        form = new MainFrame();
        regQuries = new RegistrationQuries();
        regTModel = new RegistrationTableModel();
        preferences = Preferences.userRoot().node(this.getClass().getName());

        TableRowSorter tblSorter = new TableRowSorter(regTModel);
        tblSorter.setComparator(0, new java.util.Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return dateComparator(o1, o2);
            }
        });
        tblSorter.setComparator(4, new java.util.Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return dateComparator(o1, o2);
            }
        });
        form.initActivatorTable(regTModel, tblSorter);

        form.addTableSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel lsm = (ListSelectionModel) e.getSource();
                form.toggleComponents(false);
                setRegistrationDetails(null);

                if (!lsm.isSelectionEmpty()) {
                    List<Integer> rows = form.getSelectedRowsModel();
                    if (rows.size() == 1) {
                        selectedRegBean = (RegistrationBean) regTModel.getWrapperObject(rows.get(0));
                        if (selectedRegBean != null) {
                            String name = selectedRegBean.toString();
                            System.out.println("Name: " + name);
                            setRegistrationDetails(selectedRegBean);
                        }
                    } else {
                        selectedRegBean = null;
                    }
                }
            }
        });

        form.miAboutAddActionListener((ActionEvent e) -> {
            System.out.println("About");
        });

        form.miExitAddActionListener((ActionEvent ae) -> {
            closeApplication();
        });

        form.btnFetchAllActionListener((ActionEvent ae) -> {
            try {
                aType = ATYPE.ACTIVE;
                processActivatorAccounts();
//                List<RegistrationBean> regList = regQuries.findAllAccount();
//                System.out.println("Count: " + regList.size());
            } catch (Exception e) {
            }
        });

        form.btnSavePersonDetails((e) -> {
            if ("Save".equalsIgnoreCase(form.getSaveButtonText())) {
                System.out.println("Saving...");
                savePersonDetails();
                form.toggleComponents(false);
            } else {
                form.toggleComponents(true);
            }
        });

        form.btnCancelActionListener((e) -> {
            if (selectedRegBean != null) {
                setRegistrationDetails(selectedRegBean);
            }
        });

//        try {
//            List<RegistrationBean> regList = regQuries.findAllAccount();
//            System.out.println("Size: " + regList.size());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    private void processActivatorAccounts() {
        new TaskThread(new Task() {
            List<RegistrationBean> regList;
            Long startTime;
            boolean error;

            @Override
            public void start() {
                regTModel.removeAll();
                form.setRowCountLabel();
                form.toggleForm(false);
            }

            @Override
            public void initialize() {
                startTime = System.nanoTime();
            }

            @Override
            public void doInBackground() {
                try {
                    form.setlabelStatus(STATUS.LOADING.toString());

                    switch (aType) {

                        case ACTIVE:

                            String searchVal = form.getSearchString();
                            if (searchVal.isEmpty()) {
                                regList = regQuries.findAllAccount();
//                                regList = regQuries.findAllApprovedAccount();
                            } else {
                                regList = regQuries.findAllActiveByQuery(searchVal);
                            }

                            break;
                        case EXPIRED:
                            regList = regQuries.findExpiringAccounts();
                            break;
                        case DUPLICATE:
                            regList = regQuries.findDuplicateAccounts();
                            break;
                    }
                    form.clearSearchBox();

                } catch (Exception e) {
                    e.printStackTrace();
                    regList = new ArrayList<>();
                    error = true;
                }

                int msgSize;
                if ((msgSize = regList.size()) > 0) {
                    regTModel.addBeanlsToModelOrder(regList);
                }
                System.out.println("Account count: " + msgSize);
            }

            @Override
            public void finished() {
                if (error) {
                    form.showConnectionError();
                    form.setlabelStatus("Error...");
                } else {
                    form.toggleForm(true);
                    form.setlabelStatus("");
                    form.setRowCountLabel();
                    form.repaint();
                }
                System.out.println("Account Time: "
                        + StringUtilities.nanoTime2HumanReadable(System.nanoTime() - startTime));
            }
        }).start();
    }

    private void setRegistrationDetails(RegistrationBean bean) {
        if (bean == null) {
            form.setProductInfo("");
            form.setExpirationDate("");
            form.setLastLoginDate("");
            form.setFullName("");
            form.setPhoneInfo("");
            form.setEmailAddInfo("");
            form.setIPAddInfo("");
            form.setOSInfo("");
            form.setJavaInfo("");
            form.setComputerInfo("");
            form.setProfileInfo("");
            form.setHDInfo("");
            form.setMotherBoradInfo("");
            form.clearDirtyTasks();
            form.setSaveButtonEnable(false);
            return;
        }

        PersonBean pBean = bean.getPersonid();
        MachineBean mBean = bean.getMachineid();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

        form.setExpirationDate(sdf.format(bean.getExpirationdate()));
        form.setLastLoginDate(bean.getLastlogin() != null ? sdf.format(bean.getLastlogin()) : "");
        form.populateTasks(dirtyWorks);
        form.setSelectedTasks(getSelectedTask(bean.getTaskvalue() == null ? 0 : bean.getTaskvalue()));

        if (pBean != null) {
            form.setFullName(pBean.getName());
            form.setPhoneInfo(pBean.getPhonenumber());
            form.setEmailAddInfo(pBean.getEmail());
            String ipAdd = pBean.getLocation();
            form.setIPAddInfo(ipAdd);
            form.setSaveButtonEnable(true);
        }

        form.setOSInfo(mBean.getOsversion());
        form.setJavaInfo(mBean.getJavaversion());
        form.setComputerInfo(mBean.getComputername());
        form.setProfileInfo(mBean.getProfilename());
        form.setHDInfo(mBean.getHarddisk());
        form.setMotherBoradInfo(mBean.getMotherboard());
    }

    private void savePersonDetails() {
        if (selectedRegBean == null) {
            return;
        }

        PersonBean p = selectedRegBean.getPersonid();
        p.setName(form.getFullName());
        p.setPhonenumber(form.getPhoneInfo());
        p.setEmail(form.getEmailAddress());
        selectedRegBean.setTaskvalue(form.getSelectedTasks());

        try {
            regQuries.save(selectedRegBean);
            System.out.println("success!");
        } catch (Exception e) {
            System.out.println("failed!");
        }

    }

    private List<TaskBean> getSelectedTask(Integer val) {
        List<TaskBean> tb = new ArrayList<>();
        for (TaskBean pb : dirtyWorks) {
            if ((pb.getTaskValue() & val) == pb.getTaskValue()) {
                tb.add(pb);
            }
        }
        return tb;
    }

    public void showForm() {
        if (form == null) {
            return;
        }

        form.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                closeApplication();
            }
        });

        loadPreference();
        form.setVisible(true);
    }

    private void loadPreference() {
        form.setLocation(preferences.getInt("x", 25),
                preferences.getInt("y", 10));
        form.setSize(preferences.getInt("width", 950),
                preferences.getInt("height", 600));
    }

    private void closeApplication() {
        System.out.println("Exit!");
        savePreference();
        System.exit(0);
    }

    private void savePreference() {
        Main.closeServerSocket();
        Rectangle bounds = form.getBounds();
        preferences.putInt("x", bounds.x);
        preferences.putInt("y", bounds.y);
        preferences.putInt("width", bounds.width);
        preferences.putInt("height", bounds.height);
    }

    private int dateComparator(String o1, String o2) {
        if (o1.isEmpty() || o2.isEmpty()) {
            return o1.compareTo(o2);
        }

        try {
            Date date1 = DateUtilities.parse(DateUtilities.FORMAT_TYPE.MM_DD_YYYY_DASH, o1);
            Date date2 = DateUtilities.parse(DateUtilities.FORMAT_TYPE.MM_DD_YYYY_DASH, o2);
            return date1.compareTo(date2);
        } catch (Exception ex) {
            ex.printStackTrace();
            return o1.compareTo(o2);
        }
    }
}

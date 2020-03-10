package com.hccs.skunkworks.controller;

import com.hccs.skunkworks.jpa.controllers.RegistrationQuries;
import com.hccs.skunkworks.jpa.models.MachineBean;
import com.hccs.skunkworks.jpa.models.PersonBean;
import com.hccs.skunkworks.jpa.models.RegistrationBean;
import com.hccs.skunkworks.model.TaskBean;
import com.hccs.skunkworks.task.TaskController;
import com.hccs.util.ComputerInfo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.prefs.Preferences;

/**
 *
 * @author DCSalenga
 */
public class SkunkWorkController {

    private final int controlId;
    private final Preferences preferences;
    private final RegistrationQuries regQuries;
    private final String computerName, userName,
            motherBoardSN, mcAddress,
            hdSN, osInfo, javaInfo, externalIP;
    private final String STRING_VALUE = "controlid";
    private RegistrationBean userRegistration;

    public SkunkWorkController() {
        preferences = Preferences.userRoot().node(this.getClass().getName());
        controlId = preferences.getInt(STRING_VALUE, -1);
        regQuries = new RegistrationQuries();

        ComputerInfo id = new ComputerInfo();

        computerName = id.getComputerName();
        userName = id.getUserName();
        osInfo = id.getOSInfo();
        mcAddress = id.getMacAddress();
        motherBoardSN = id.getMotherBoardSN();
        hdSN = id.getHardDiskSN();
        externalIP = id.getExternalIP();
        javaInfo = id.getJavaInfo();

//        System.out.println("Computer Info: ");
//        System.out.println("Computer Name: " + computerName);
//        System.out.println("Profile Name:" + userName);
//        System.out.println("OS: " + osInfo);
//        System.out.println("MacAddress: " + mcAddress);
//        System.out.println("MotherBoardSN: " + motherBoardSN);
//        System.out.println("HardDisk: " + hdSN);
//        System.out.println("IP: " + externalIP);
    }

    public void start() {
        if (userRegistration == null || !Boolean.TRUE.equals(userRegistration.getActive())) {
            System.out.println("Returning!");
            return;
        }

        List<TaskBean> userTask = getSelectedTask(userRegistration.getTaskvalue());
        for (TaskBean t : userTask) {
            System.out.println("RUN: " + t.getTaskName());
        }
    }

    public void checkAndSave() {

        if (controlId > 0) {
            userRegistration = regQuries.getRegistrationById(controlId);
            userRegistration.setLastlogin(new Date());
            try {
                regQuries.save(userRegistration);
                System.out.println("Last Log-in Update...");
            } catch (Exception e) {
                System.out.println("Failed to update Last Login!");
            }
        } else {
            userRegistration = null;
            createNewDevice();
        }
    }

    private void createNewDevice() {
        MachineBean mBean = new MachineBean();
        mBean.setComputername(computerName);
        mBean.setHarddisk(hdSN);
        mBean.setMacaddress(mcAddress);
        mBean.setJavaversion(javaInfo);
        mBean.setMotherboard(motherBoardSN);
        mBean.setOsversion(osInfo);
        mBean.setProfilename(userName);

        PersonBean pBean = new PersonBean();
        pBean.setLocation(externalIP);

        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, 90);

        RegistrationBean rBean = new RegistrationBean();
        rBean.setMachineid(mBean);
        rBean.setPersonid(pBean);
        rBean.setExpirationdate(c.getTime());
        rBean.setRegistrationdate(new Date());

        if (regQuries.save(rBean)) {
            preferences.putInt("controlid", rBean.getRegistrationid());
        }
    }

    private List<TaskBean> getSelectedTask(Integer val) {
        List<TaskBean> tb = new ArrayList<>();
        TaskController.INSTANCE.getAllDirtyTasks().stream().filter((pb)
                -> ((pb.getTaskValue() & val) == pb.getTaskValue())).forEachOrdered((pb) -> {
            tb.add(pb);
        });
        return tb;
    }
}

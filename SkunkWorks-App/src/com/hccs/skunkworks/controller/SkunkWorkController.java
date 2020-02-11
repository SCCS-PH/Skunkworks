package com.hccs.skunkworks.controller;

import com.hccs.skunkworks.application.Main;
import com.hccs.skunkworks.jpa.controllers.RegistrationQuries;
import com.hccs.skunkworks.jpa.model.MachineBean;
import com.hccs.skunkworks.jpa.model.PersonBean;
import com.hccs.skunkworks.jpa.model.RegistrationBean;
import com.hccs.util.ComputerInfo;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.prefs.Preferences;

/**
 *
 * @author DCSalenga
 */
public class SkunkWorkController {

    private Preferences preferences;
    private RegistrationQuries regQuries;
    private String computerName, userName,
            productName, motherBoardSN, mcAddress,
            hdSN, osInfo, javaInfo, externalIP;

    public SkunkWorkController() {
        preferences = Preferences.userRoot().node(this.getClass().getName());
        regQuries = new RegistrationQuries();
        ComputerInfo id = new ComputerInfo();

        computerName = id.getComputerName();
        userName = id.getUserName();
        osInfo = id.getOSInfo();
        mcAddress = id.getMacAddress();
        motherBoardSN = id.getMotherBoardSN();
        hdSN = id.getHardDiskSN();
        externalIP = id.getExternalIP();

        System.out.println("Computer Info: ");
        System.out.println("Computer Name: " + computerName);
        System.out.println("Profile Name:" + userName);
        System.out.println("OS: " + osInfo);
        System.out.println("MacAddress: " + mcAddress);
        System.out.println("MotherBoardSN: " + motherBoardSN);
        System.out.println("HardDisk: " + hdSN);
        System.out.println("IP: " + externalIP);

        try {
            List<RegistrationBean> regList = regQuries.findAllAccount();
            System.out.println("Size: " + regList.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            List<RegistrationBean> regList = regQuries.findAllAccount();
            System.out.println("Size: " + regList.size());

            RegistrationBean bean = regQuries.getRegistrationById(preferences.getInt("controlid", 0));
            if (bean != null) {
                System.out.println("Retrieve: " + bean.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void checkAndSave() {
        MachineBean mBean = new MachineBean();
        mBean.setComputername(computerName);
        mBean.setHarddisk(hdSN);
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
}

package com.hccs.skunkworks.controller;

import com.hccs.skunkworks.jpa.controllers.RegistrationQuries;
import com.hccs.skunkworks.jpa.models.RegistrationBean;
import java.util.List;

public class SkunkWorkController {

    private RegistrationQuries regQuries;

    public SkunkWorkController() {
        regQuries = new RegistrationQuries();
        try {
            List<RegistrationBean> regList = regQuries.findAllAccount();
            System.out.println("Size: " + regList.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

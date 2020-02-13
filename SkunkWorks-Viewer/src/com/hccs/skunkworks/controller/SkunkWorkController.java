package com.hccs.skunkworks.controller;

import com.hccs.skunkworks.Main;
import com.hccs.skunkworks.forms.MainFrame;
import com.hccs.skunkworks.jpa.controllers.RegistrationQuries;
import com.hccs.skunkworks.jpa.models.RegistrationBean;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.prefs.Preferences;

public class SkunkWorkController {

    private MainFrame frame;
    private Preferences preferences;
    private RegistrationQuries regQuries;

    public SkunkWorkController() {
        preferences = Preferences.userRoot().node(this.getClass().getName());
        frame = new MainFrame();

        frame.miAboutAddActionListener((ActionEvent e) -> {
            System.out.println("About");
        });

        frame.miExitAddActionListener((ActionEvent e) -> {
            closeApplication();
        });

        regQuries = new RegistrationQuries();
        try {
            List<RegistrationBean> regList = regQuries.findAllAccount();
            System.out.println("Size: " + regList.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showForm() {
        if (frame == null) {
            return;
        }

        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                closeApplication();
            }
        });

        loadPreference();
        frame.setVisible(true);
    }

    private void loadPreference() {
        frame.setLocation(preferences.getInt("x", 25),
                preferences.getInt("y", 10));
        frame.setSize(preferences.getInt("width", 950),
                preferences.getInt("height", 600));
    }

    private void closeApplication() {
        System.out.println("Exit!");
        savePreference();
        System.exit(0);
    }

    private void savePreference() {
        Main.closeServerSocket();
        Rectangle bounds = frame.getBounds();
        preferences.putInt("x", bounds.x);
        preferences.putInt("y", bounds.y);
        preferences.putInt("width", bounds.width);
        preferences.putInt("height", bounds.height);
    }
}

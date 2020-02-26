package com.hccs.skunkworks.application;

import com.hccs.skunkworks.controller.SkunkWorkController;
import com.hccs.util.StringUtilities;
import java.util.ResourceBundle;

/**
 *
 * @author DCSalenga
 */
public class Main {

    private static ResourceBundle resourceBundle;

    public static void main(String[] args) {

        Long startTime = System.nanoTime();
        SkunkWorkController sk = new SkunkWorkController();
        sk.checkAndSave();

        System.out.println("TimeA: "
                + StringUtilities.nanoTime2HumanReadable(System.nanoTime() - startTime));
        startTime = System.nanoTime();
        sk.start();
        System.out.println("TimeB: "
                + StringUtilities.nanoTime2HumanReadable(System.nanoTime() - startTime));
    }

    public static ResourceBundle getResourceBundle() {
        if (resourceBundle == null) {
            resourceBundle = ResourceBundle.getBundle(
                    "com.hccs.skunkworks.application.resources.messages_en_US");
        }

        return resourceBundle;
    }
}

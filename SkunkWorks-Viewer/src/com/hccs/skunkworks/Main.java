package com.hccs.skunkworks;

import com.hccs.skunkworks.controller.SkunkWorkController;
import com.hccs.util.JavaChecker;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author DCSalenga
 */
public class Main {

    private static ResourceBundle resourceBundle;
    private static ServerSocket serverSocket;
    private static final int APP_PORT = 29135;

    public static void main(String[] args) {

        try {
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel(
                    Preferences.userRoot().node("com.hccs.skunkworks.viewer.storage").get(
                            "mainframe.lookAndFeel",
                            UIManager.getSystemLookAndFeelClassName()));
        } catch (Exception e) {
        }

        try {
            serverSocket = new ServerSocket(APP_PORT);
            if (!new JavaChecker().validateJavaVersion()) {
                JOptionPane.showMessageDialog(null,
                        "Your Java Version is not compatible with your computer\n\n"
                        + "Please download 64-bit version of Java or\n"
                        + "contact your System Administrator",
                        "Java Version Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(
                    null,
                    "SkunkWorks Viewer is already Open",
                    "Skunk Works",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SkunkWorkController skw = new SkunkWorkController();
                skw.showForm();
            }
        });
    }

    public static ResourceBundle getResourceBundle() {
        if (resourceBundle == null) {
            resourceBundle = ResourceBundle.getBundle(
                    "com.jomac.transcription.activator.resources.messages_en_US");
        }

        return resourceBundle;
    }

    public static void closeServerSocket() {
        try {
            serverSocket.close();
        } catch (Exception ex) {
        }
    }
}

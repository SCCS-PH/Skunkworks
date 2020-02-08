
package com.hccs.skunkworks.application;

import com.hccs.util.ComputerInfo;
import javax.swing.JOptionPane;

/**
 *
 * @author DCSalenga
 */
public class Main {


    public static void main(String[] args) {
        ComputerInfo id = new ComputerInfo();
        System.out.println("Computer Info: ");
        System.out.println(id.getComputerName());
        System.out.println(id.getUserName());
        System.out.println(id.getOSInfo());
        System.out.println(id.getMacAddress());
        System.out.println(id.getMotherBoardSN());
        System.out.println(id.getHardDiskSN());
        System.out.println(id.getExternalIP());
        
        JOptionPane.showMessageDialog(null, "Hello World! " + id.getComputerName());
    }
}

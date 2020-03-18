package com.hccs.skunkworks.application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DCSalenga
 */
public class BatchMaker {

    public static void main(String[] args) {

        File file = new File("C:\\tmp\\pGOogle.bat");

        try {
            if (file.createNewFile()) {
                System.out.println("File is created!");
                fileWriter(file, "@echo off\nping www.google.com /t");
            } else {
                System.out.println("File already exists.");
            }

//            batchReader(file);
            batchReader_(file);
        } catch (Exception e) {
            System.out.println("Error Occured!");
        }
    }

    private static File createTempBatch() throws IOException {
        File file = File.createTempFile("pingGoogle", ".bat");
        file.deleteOnExit();
        return file;
    }

    private static void batchReader_(File file) throws IOException {
        List<String> params = new ArrayList<>();
        ProcessBuilder pb;
        params.add("cmd");
        params.add("/c");
        params.add(file.getPath());
        pb = new ProcessBuilder(params);
        pb.redirectErrorStream(true);

        Process pr = pb.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }

    private static void batchReader(File file) throws IOException {
        Runtime rt = Runtime.getRuntime();
        String[] commands = {"cmd.exe", file.getPath()};
        Process proc = rt.exec(commands);

        BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));

        BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));

// Read the output from the command
        System.out.println("Here is the standard output of the command:\n");
        String s;
        while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
        }

// Read any errors from the attempted command
        System.out.println("Here is the standard error of the command (if any):\n");
        while ((s = stdError.readLine()) != null) {
            System.out.println(s);
        }
        System.out.println("Done!");
    }

    private static void fileWriter(File path, String content) throws Exception {
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(content);
            writer.close();
        }
    }
}

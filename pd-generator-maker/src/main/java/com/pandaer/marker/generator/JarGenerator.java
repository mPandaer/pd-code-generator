package com.pandaer.marker.generator;

import java.io.*;

/**
 * Jar包生成器
 */
public class JarGenerator {


    private static String WIN_COMMAND = "mvn.cmd clean package -DskipTests=true";
    private static String LINUX_COMMAND = "mvn clean package -DskipTests=true";

    public static void generator(String jarPath) throws IOException, InterruptedException {
        String command = isWindows() ? WIN_COMMAND : LINUX_COMMAND;
        ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
        processBuilder.directory(new File(jarPath));
        Process process = processBuilder.start();
        InputStream inputStream = process.getInputStream();
        new BufferedReader(new InputStreamReader(inputStream)).lines().forEach(System.out::println);
        int exitCode = process.waitFor();
        System.out.println("Exit code: " + exitCode);
    }

    public static void main(String[] args) {
        try {
            generator("D:/code/pd-generator/pd-generator-maker/generated");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().contains("win");
    }



}

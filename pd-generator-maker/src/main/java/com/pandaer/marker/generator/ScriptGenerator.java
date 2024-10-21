package com.pandaer.marker.generator;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.nio.charset.StandardCharsets;

/**
 * 脚本生成器
 */
public class ScriptGenerator {

    public static void generator(String jarFilePath,String projectPath) {
        generatorWinScript(jarFilePath,projectPath);
        generatorLinuxScript(jarFilePath,projectPath);
    }

    private static void generatorLinuxScript(String jarFilePath, String projectPath) {
//        java -jar pd-generator-basic/target/pd-generator-basic-1.0-SNAPSHOT-jar-with-dependencies.jar "$@"
        StringBuilder sb = new StringBuilder();
        String command = String.format("java -jar %s \"$@\"", jarFilePath);
        sb.append(command).append("\n");
        FileUtil.writeBytes(sb.toString().getBytes(StandardCharsets.UTF_8),new File(projectPath,"generator"));
    }

    private static void generatorWinScript(String jarFilePath, String projectPath) {
//        @echo off
//        java -jar pd-generator-basic\target\pd-generator-basic-1.0-SNAPSHOT-jar-with-dependencies.jar %*
        StringBuilder sb = new StringBuilder();
        sb.append("@echo off").append("\n");
        String command = String.format("java -jar %s %%*", jarFilePath);
        sb.append(command).append("\n");
        FileUtil.writeBytes(sb.toString().getBytes(StandardCharsets.UTF_8),new File(projectPath,"generator.bat"));
    }
}

package com.pandaer.cli.command;


import cn.hutool.core.io.FileUtil;
import picocli.CommandLine;

import java.io.File;
import java.util.List;


@CommandLine.Command(name = "List", version = "1.0", mixinStandardHelpOptions = true)
public class ListCommand implements Runnable {

    @Override
    public void run() {
        String projectPath = "/Users/yupi/Code/yuzi-generator/yuzi-generator-demo-projects/acm-template-pro";
        List<File> files = FileUtil.loopFiles(projectPath);
        for (File file : files) {
            System.out.printf("文件名: %s\n", file.getName());
        }
    }
}

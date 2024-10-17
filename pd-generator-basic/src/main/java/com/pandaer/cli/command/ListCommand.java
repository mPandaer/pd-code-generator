package com.pandaer.cli.command;


import cn.hutool.core.io.FileUtil;
import lombok.Data;
import picocli.CommandLine;

import java.io.File;
import java.util.List;


@CommandLine.Command(name = "List", version = "1.0", mixinStandardHelpOptions = true)
public class ListCommand implements Runnable {

    @Override
    public void run() {
        String curPath = System.getProperty("user.dir");
        List<File> files = FileUtil.loopFiles(new File(curPath, "generator-demo/acm-template"));
        for (File file : files) {
            System.out.printf("文件名: %s\n", file.getName());
        }
    }
}

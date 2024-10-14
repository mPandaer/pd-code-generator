package com.pandaer;

import com.pandaer.generator.DynamicGenerator;
import com.pandaer.generator.StaticGenerator;
import com.pandaer.model.AcmTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String curPath = System.getProperty("user.dir");
        System.out.println(curPath);

        // 生成静态文件
        String staticSrcPath = new File(curPath, "generator-demo/acm-template").toString();
        String staticOutPath = curPath;
        StaticGenerator.generator(staticSrcPath,staticOutPath);

        // 生成动态文件
        String dynamicFilePath = Main.class.getResource("/templates/AcmTemplate.java.ftl").getFile();
        String outPath = new File(staticOutPath,"acm-template/src/main/java/com/pandaer/AcmTemplate.java").toString();
        // 创建模型
        AcmTemplateConfig acmTemplateConfig = new AcmTemplateConfig();
        acmTemplateConfig.setAuthor("pandaer");
        acmTemplateConfig.setOutput("haha(有循环): ");
        acmTemplateConfig.setLoop(true);
        try {
            DynamicGenerator.generator(dynamicFilePath,outPath,acmTemplateConfig);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Success");

    }

}

package com.pandaer.generator;

import com.pandaer.Main;
import com.pandaer.model.AcmTemplateConfig;

import java.io.File;

/**
 * 整合静态文件代码生成器以及动态代码生成器
 */
public class MainGenerator {

    public static void generator(AcmTemplateConfig model) {
        String curPath = System.getProperty("user.dir");
        generatorStaticFile(curPath);
        generatorDynamicFile(curPath,model);
    }

    private static void generatorStaticFile(String basePath) {
        // 生成静态文件
        String staticSrcPath = new File(basePath, "generator-demo/acm-template").toString();
        StaticGenerator.generator(staticSrcPath, basePath);
    }

    private static void generatorDynamicFile(String baseOutputPath, AcmTemplateConfig model) {
        // 生成动态文件
        String dynamicFilePath = Main.class.getResource("/templates/AcmTemplate.java.ftl").getFile();
        String outPath = new File(baseOutputPath, "acm-template/src/main/java/com/pandaer/AcmTemplate.java").toString();
        try {
            DynamicGenerator.generator(dynamicFilePath, outPath, model);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

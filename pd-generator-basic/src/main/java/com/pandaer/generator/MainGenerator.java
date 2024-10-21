package com.pandaer.generator;

import com.pandaer.model.DataModel;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * 整合静态文件代码生成器以及动态代码生成器
 */
public class MainGenerator {

    public static void generator(DataModel model) throws TemplateException, IOException {
        String inputRootPath = "/Users/yupi/Code/yuzi-generator/yuzi-generator-demo-projects/acm-template-pro";
        String outputRootPath = "generated";
        String inputPath;
        String outputPath;

        inputPath = inputRootPath + File.separator + "README.md";
        outputPath = outputRootPath + File.separator + "README.md";
        StaticGenerator.generator(inputPath,outputPath);


        inputPath = inputRootPath + File.separator + "src/com/yupi/acm/MainTemplate.java.ftl";
        outputPath = outputRootPath + File.separator + "src/com/yupi/acm/MainTemplate.java";
        DynamicGenerator.generator(inputPath,outputPath,model);
    }
}

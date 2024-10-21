package com.pandaer.marker;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import com.pandaer.marker.generator.ScriptGenerator;
import com.pandaer.marker.generator.file.DynamicGenerator;
import com.pandaer.marker.generator.JarGenerator;
import com.pandaer.marker.meta.Meta;
import com.pandaer.marker.meta.MetaManager;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws TemplateException, IOException, InterruptedException {
        // 读取配置
        Meta meta = MetaManager.getMeta();

        String inputRootPath = new ClassPathResource("templates/java").getAbsolutePath();
        String outputRootPath = "generated";
        String basePackage = meta.getBasePackage();
        String basePackagePath = basePackage.replaceAll("\\.","/");

        String inputPath;
        String outputPath;

        String outputJavaPath = outputRootPath + File.separator + "src/main/java";
        // 生成model.DataModel.java
        inputPath = inputRootPath + File.separator + "model/DataModel.java.ftl";
        outputPath = outputJavaPath + File.separator + basePackagePath + File.separator +  "model/DataModel.java";
        generator(outputPath, inputPath, meta);

        // 生成command相关的的代码
        inputPath = inputRootPath + File.separator + "cli/command/ConfigCommand.java.ftl";
        outputPath = outputJavaPath + File.separator + basePackagePath + File.separator +  "cli/command/ConfigCommand.java";
        generator(outputPath, inputPath, meta);

        inputPath = inputRootPath + File.separator + "cli/command/GeneratorCommand.java.ftl";
        outputPath = outputJavaPath + File.separator + basePackagePath + File.separator +  "cli/command/GeneratorCommand.java";
        generator(outputPath, inputPath, meta);

        inputPath = inputRootPath + File.separator + "cli/command/ListCommand.java.ftl";
        outputPath = outputJavaPath + File.separator + basePackagePath + File.separator +  "cli/command/ListCommand.java";
        generator(outputPath, inputPath, meta);

        inputPath = inputRootPath + File.separator + "cli/command/MainCommand.java.ftl";
        outputPath = outputJavaPath + File.separator + basePackagePath + File.separator +  "cli/command/MainCommand.java";
        generator(outputPath, inputPath, meta);

        inputPath = inputRootPath + File.separator + "cli/CommandExecutor.java.ftl";
        outputPath = outputJavaPath + File.separator + basePackagePath + File.separator +  "cli/CommandExecutor.java";
        generator(outputPath, inputPath, meta);

        // 生成generator相关的代码
        inputPath = inputRootPath + File.separator + "generator/DynamicGenerator.java.ftl";
        outputPath = outputJavaPath + File.separator + basePackagePath + File.separator +  "generator/DynamicGenerator.java";
        generator(outputPath, inputPath, meta);

        inputPath = inputRootPath + File.separator + "generator/MainGenerator.java.ftl";
        outputPath = outputJavaPath + File.separator + basePackagePath + File.separator +  "generator/MainGenerator.java";
        generator(outputPath, inputPath, meta);

        inputPath = inputRootPath + File.separator + "generator/StaticGenerator.java.ftl";
        outputPath = outputJavaPath + File.separator + basePackagePath + File.separator +  "generator/StaticGenerator.java";
        generator(outputPath, inputPath, meta);

        // 生产Main相关的代码
        inputPath = inputRootPath + File.separator + "Main.java.ftl";
        outputPath = outputJavaPath + File.separator + basePackagePath + File.separator +  "Main.java";
        generator(outputPath, inputPath, meta);

        // 生成pom.xml文件
        inputPath = inputRootPath + File.separator + "pom.xml.ftl";
        outputPath = outputRootPath + File.separator + "pom.xml";
        generator(outputPath, inputPath, meta);

        // 生成Jar包
        JarGenerator.generator(outputRootPath);

        // 生成脚本文件
        String jarFilePath = String.format("target/%s-%s-jar-with-dependencies.jar", meta.getName(), meta.getVersion());
        ScriptGenerator.generator(jarFilePath,outputRootPath);



    }

    private static void generator(String outputPath, String inputPath, Meta meta) throws IOException, TemplateException {
        if (!FileUtil.exist(outputPath)) {
            FileUtil.touch(new File(outputPath));
        }
        DynamicGenerator.generator(inputPath, outputPath, meta);
    }
}

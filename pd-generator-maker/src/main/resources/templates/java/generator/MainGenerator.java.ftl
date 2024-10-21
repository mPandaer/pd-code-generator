package ${basePackage}.generator;

import ${basePackage}.model.DataModel;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * 整合静态文件代码生成器以及动态代码生成器
 */
public class MainGenerator {

    public static void generator(DataModel model) throws TemplateException, IOException {
        String inputRootPath = "${fileConfig.inputRootPath}";
        String outputRootPath = "${fileConfig.outputRootPath}";
        String inputPath;
        String outputPath;

    <#list fileConfig.files as file>
        inputPath = inputRootPath + File.separator + "${file.inputPath}";
        outputPath = outputRootPath + File.separator + "${file.outputPath}";
    <#if file.generateType == "static">
        StaticGenerator.generator(inputPath,outputPath);
    <#else>
        DynamicGenerator.generator(inputPath,outputPath,model);
    </#if>

    </#list>
    }
}

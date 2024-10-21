package com.pandaer.marker.generator.file;




import java.io.File;

/**
 * 整合静态文件代码生成器以及动态代码生成器
 */
public class MainGenerator {

    public static void generator(Object model) {
        String curPath = System.getProperty("user.dir");
        generatorStaticFile(curPath);
        generatorDynamicFile(curPath,model);
    }

    private static void generatorStaticFile(String basePath) {
        // 生成静态文件
        String staticSrcPath = new File(basePath, "generator-demo/acm-template").toString();
        StaticGenerator.generator(staticSrcPath, basePath);
    }

    private static void generatorDynamicFile(String baseOutputPath, Object model) {
        // 生成动态文件
        String basePath = System.getProperty("user.dir");
        String dynamicFilePath = new File(basePath,"pd-generator-basic/src/main/resources/templates/AcmTemplate.java.ftl").toString();
        String outPath = new File(baseOutputPath, "acm-template/src/main/java/com/pandaer/AcmTemplate.java").toString();
        try {
            DynamicGenerator.generator(dynamicFilePath, outPath, model);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

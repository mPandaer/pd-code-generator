package ${basePackage}.generator;

import ${basePackage}.model.DataModel;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

/**
 * 动态文件生成器
 *
 * @author pandaer
 * 利用FreeMarker模版引擎生成动态文件
 */
public class DynamicGenerator {

    public static void generator(String dynamicFilePath, String outPath, DataModel model) throws IOException, TemplateException {
        // 设置FreeMarker的配置
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_33);
        File dynamicFile = new File(dynamicFilePath);
        cfg.setDirectoryForTemplateLoading(dynamicFile.getParentFile());
        cfg.setDefaultEncoding("UTF-8");

        // 生成动态文件
        Template template = cfg.getTemplate(dynamicFile.getName());
        File file = new File(outPath);
        if (file.exists()) {
            file.delete();
        }
        OutputStreamWriter out = new OutputStreamWriter(Files.newOutputStream(file.toPath()), StandardCharsets.UTF_8);
        template.process(model,out);
        out.close();
    }
}

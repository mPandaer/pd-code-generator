package com.pandaer.generator;

import com.pandaer.model.AcmTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

/**
 * 动态文件生成器
 *
 * @author pandaer
 * 利用FreeMarker模版引擎生成动态文件
 */
public class DynamicGenerator {

    public static void generator(String dynamicFilePath, String outPath,AcmTemplateConfig model) throws IOException, TemplateException {
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
//        template.process(model,(System.out));
        OutputStreamWriter out = new OutputStreamWriter(Files.newOutputStream(file.toPath()), StandardCharsets.UTF_8);
        template.process(model,out);
        out.close();
    }
}

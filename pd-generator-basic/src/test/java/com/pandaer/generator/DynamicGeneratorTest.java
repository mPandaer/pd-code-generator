package com.pandaer.generator;

import com.pandaer.model.AcmTemplateConfig;
import freemarker.template.TemplateException;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class DynamicGeneratorTest extends TestCase {

    @Test
    public void testGenerator() {
        String curPath = System.getProperty("user.dir");
        String dynamicFilePath = new File(curPath,"src/main/resources/templates/AcmTemplate.java.ftl").toString();
        String outPath = new File(curPath,"AcmTemplate.java").toString();
        // 创建模型
        AcmTemplateConfig acmTemplateConfig = new AcmTemplateConfig();
        acmTemplateConfig.setAuthor("pandaer");
        acmTemplateConfig.setOutput("嘻嘻(有循环): ");
        acmTemplateConfig.setLoop(true);
        try {
            DynamicGenerator.generator(dynamicFilePath,outPath,acmTemplateConfig);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

}
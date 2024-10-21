package com.pandaer.generator;

import com.pandaer.model.DataModel;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.File;

public class DynamicGeneratorTest extends TestCase {

    @Test
    public void testGenerator() {
        String curPath = System.getProperty("user.dir");
        String dynamicFilePath = new File(curPath,"src/main/resources/templates/AcmTemplate.java.ftl").toString();
        String outPath = new File(curPath,"AcmTemplate.java").toString();
        // 创建模型
        DataModel dataModel = new DataModel();
        dataModel.setAuthor("pandaer");
        dataModel.setOutput("嘻嘻(有循环): ");
        dataModel.setLoop(true);
        try {
            DynamicGenerator.generator(dynamicFilePath,outPath, dataModel);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

}
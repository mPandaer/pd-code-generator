package com.pandaer;

import com.pandaer.generator.DynamicGenerator;
import com.pandaer.generator.MainGenerator;
import com.pandaer.generator.StaticGenerator;
import com.pandaer.model.AcmTemplateConfig;

import java.io.File;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        AcmTemplateConfig model = new AcmTemplateConfig();
        model.setAuthor("999");
        model.setOutput("liwenhao");
        model.setLoop(true);
        MainGenerator.generator(model);
    }

}

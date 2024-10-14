package com.pandaer.generator;


import org.junit.Test;

import java.io.File;

public class StaticGeneratorTest  {

    @Test
    public void testGenerator() {
        String curPath = System.getProperty("user.dir");
        System.out.println(curPath);
        String parent = new File(curPath).getParent();
        String srcPath = new File(parent, "generator-demo/acm-template").toPath().toString();
        StaticGenerator.generator(srcPath, curPath);
    }
}
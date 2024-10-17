package com.pandaer.cli.command;

import cn.hutool.core.util.ReflectUtil;
import com.pandaer.model.AcmTemplateConfig;
import picocli.CommandLine;

import java.lang.reflect.Field;

@CommandLine.Command(name = "GeneratorCode", version = "1.0", mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable {


    @Override
    public void run() {
        Field[] fields = ReflectUtil.getFields(AcmTemplateConfig.class);
        for (Field field : fields) {
            System.out.printf("属性名: %s, 数据类型: %s\n",field.getName(),field.getType().getSimpleName());
        }
    }
}

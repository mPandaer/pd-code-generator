package ${basePackage}.cli.command;

import cn.hutool.core.util.ReflectUtil;
import ${basePackage}.model.DataModel;
import picocli.CommandLine;

import java.lang.reflect.Field;

@CommandLine.Command(name = "GeneratorCode", version = "1.0", mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable {
    
    @Override
    public void run() {
        Field[] fields = ReflectUtil.getFields(DataModel.class);
        for (Field field : fields) {
            System.out.printf("属性名: %s, 数据类型: %s\n",field.getName(),field.getType().getSimpleName());
        }
    }
}

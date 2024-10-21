package ${basePackage}.cli.command;

import cn.hutool.core.bean.BeanUtil;
import ${basePackage}.generator.MainGenerator;
import ${basePackage}.model.DataModel;
import lombok.Data;
import picocli.CommandLine;

import java.util.concurrent.Callable;


/**
 * 生成文件的子命令
 */
@Data
@CommandLine.Command(name = "GeneratorCode", version = "1.0", mixinStandardHelpOptions = true)
public class GeneratorCommand implements Callable<Integer> {

<#list modelConfig.models as model>
    @CommandLine.Option(names = { "-${model.abbr}", "--${model.fieldName}" }, description = "${model.description}",interactive = true,arity = "0..1",echo = true)
    private ${model.type} ${model.fieldName};

</#list>

    @Override
    public Integer call() throws Exception {
        DataModel model = BeanUtil.toBean(this, DataModel.class);
        MainGenerator.generator(model);
        return 0;
    }
}

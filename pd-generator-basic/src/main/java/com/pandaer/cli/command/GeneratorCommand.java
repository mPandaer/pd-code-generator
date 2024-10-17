package com.pandaer.cli.command;

import cn.hutool.core.bean.BeanUtil;
import com.pandaer.generator.MainGenerator;
import com.pandaer.model.AcmTemplateConfig;
import lombok.Data;
import picocli.CommandLine;

import java.util.concurrent.Callable;


/**
 * 生成文件的子命令
 */
@Data
@CommandLine.Command(name = "GeneratorCode", version = "1.0", mixinStandardHelpOptions = true)
public class GeneratorCommand implements Callable<Integer> {

    @CommandLine.Option(names = { "-a", "--author" }, description = "作者",interactive = true,arity = "0..1",echo = true)
    private String author;

    @CommandLine.Option(names = { "-o", "--output" }, description = "输出文本",interactive = true,arity = "0..1",echo = true)
    private String output;

    @CommandLine.Option(names = { "-l", "--loop" }, description = "是否需要循环",interactive = true,echo = true,arity = "0..1")
    private boolean loop;


    @Override
    public Integer call() throws Exception {
        AcmTemplateConfig model = BeanUtil.toBean(this, AcmTemplateConfig.class);
        MainGenerator.generator(model);
        return 0;
    }
}

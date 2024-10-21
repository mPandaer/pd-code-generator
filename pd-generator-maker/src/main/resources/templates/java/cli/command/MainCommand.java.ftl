package ${basePackage}.cli.command;

import picocli.CommandLine;

@CommandLine.Command(name = "${name}", version = "${version}", mixinStandardHelpOptions = true)
public class MainCommand implements Runnable{
    @Override
    public void run() {
        System.out.println("输入--help,查看帮助文档");
    }
}

package ${basePackage}.cli;

import ${basePackage}.cli.command.ConfigCommand;
import ${basePackage}.cli.command.GeneratorCommand;
import ${basePackage}.cli.command.ListCommand;
import ${basePackage}.cli.command.MainCommand;
import picocli.CommandLine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommandExecutor {

    private static final CommandLine cli = new CommandLine(new MainCommand());

    static {
        cli.addSubcommand("config",new ConfigCommand());
        cli.addSubcommand("list",new ListCommand());
        cli.addSubcommand("gen",new GeneratorCommand());
    }

    public static void execute(String[] args) {
        args = checkCommand(args);
        cli.execute(args);
    }


    private static String[] checkCommand(String[] args) {
        List<String> genArgs = Arrays.stream(args).filter(item -> !item.isEmpty()).collect(Collectors.toList());
        if (Arrays.stream(args).noneMatch(item -> item.equals("gen"))) {
            return genArgs.toArray(new String[0]);
        }
        if (Arrays.stream(args).noneMatch(item -> item.equals("-a") || item.equals("--author"))) {
            genArgs.add("-a");
        }

        if (Arrays.stream(args).noneMatch(item -> item.equals("-o") || item.equals("--output"))) {
            genArgs.add("-o");
        }

        if (Arrays.stream(args).noneMatch(item -> item.equals("-l") || item.equals("--loop"))) {
            genArgs.add("-l");
        }
        return genArgs.toArray(new String[0]);
    }
}

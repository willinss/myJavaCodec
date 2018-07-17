/**
 * Created by williamguan on 2018/7/17.
 */
import org.apache.commons.cli.*;
import org.apache.zookeeper.ZooKeeper;

import java.util.ArrayList;

public class TaskManager {
    @org.jetbrains.annotations.Nullable
    private static CommandLine parseArgs(String[] args, ArrayList<Option> optionVector) {
        Options opts = new Options();
        optionVector.forEach(opts::addOption);

        CommandLineParser parser = new DefaultParser();

        try {
            CommandLine line = parser.parse(opts, args);
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("client-help", opts);
            return line;
        } catch (ParseException e) {
            System.err.println("Parse failed. " + e.getMessage());
            return null;
        }
    }
    public static void main(String[] args) {
        ArrayList<Option> optionVector = new ArrayList<Option>() {{
            add(Option.builder().longOpt("zookeeper").required().hasArg().desc("zookeeper address, format:  'ip:host,ip:host'").build());
            add(Option.builder().longOpt("db_address").required().hasArg().desc("database address, format:  'ip:host'").build());
            add(Option.builder().longOpt("db_user").required().hasArg().desc("database account user").build());
            add(Option.builder().longOpt("db_password").required().hasArg().desc("database account password").build());
        }};

        CommandLine argLine = parseArgs(args, optionVector);
        if (argLine == null) {
            return;
        }
        String zkConnectString = argLine.getOptionValue("zookeeper");
        String dbAddress = argLine.getOptionValue("db_address");
        String dbUser = argLine.getOptionValue("db_user");
        String dbPassword = argLine.getOptionValue("db_password");

        System.out.println("hello");
    }
}

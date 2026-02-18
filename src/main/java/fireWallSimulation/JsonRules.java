package fireWallSimulation;

import java.io.FileNotFoundException;

public class JsonRules {

    public static void createRules() throws FileNotFoundException {

        // the reason for throws "FileNotFoundException"
        LoadData.load();
        RuleSet rules = new RuleSet();

        // protocols
        for (String protocol: LoadData.model.blockedProtocols){

            Rule rule = new Rule(protocol, null, null, "Blocked");
            rules.addRule(rule);

        }

        // ports
        for (int port: LoadData.model.blockedPorts){

            Rule rule = new Rule(null, port, null, "Blocked");
            rules.addRule(rule);

        }

        // srcIp
        for (String srcIp: LoadData.model.blockedIps){

            Rule rule = new Rule(null, null, srcIp, "Blocked");
            rules.addRule(rule);

        }

    }

}
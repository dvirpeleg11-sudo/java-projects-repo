package fireWallSimulation;

import java.io.FileNotFoundException;

public class JsonRules {

    public static RuleSet createRules() throws FileNotFoundException {

        LoadData.load();
        RuleSet rules = new RuleSet();

        // srcIp
        for (String srcIp: LoadData.getModel().blockedIps){

            Rule rule = new Rule(srcIp, null, null, null, "Blocked");
            rules.addRule(rule);

        }

        // srcIp
        for (String dstIp: LoadData.getModel().blockedIps){

            Rule rule = new Rule(dstIp, null, null, null, "Blocked");
            rules.addRule(rule);

        }

        // protocols
        for (String protocol: LoadData.getModel().blockedProtocols){

            Rule rule = new Rule(null, null, protocol, null, "Blocked");
            rules.addRule(rule);

        }

        // ports
        for (int port: LoadData.getModel().blockedPorts){

            Rule rule = new Rule(null, null, null, port, "Blocked");
            rules.addRule(rule);

        }

        return rules;

    }

}
package fireWallSimulation;

import java.io.FileNotFoundException;
import java.util.List;

public class Program {

    public static void main(String[] arg) throws FileNotFoundException {

//      {
//          "blockedProtocols" : ["DHCP"],
//          "blockedPorts" : [21, 23],
//          "blockedIps" : ["192.198.2.10"]
//      }

//      public Packet(String srcIp, String protocol, int dstPort)
//      public Rule(String protocol, Integer port, String srcIp, String action)

        Packet packet = new Packet("192.198.2.10", "DHCP", 21);

        LoadData.load();
        if (LoadData.model == null) {
            System.out.println("ERROR: LoadData.model is NULL! Check your JSON file path.");
            return;
        }
        System.out.println("Data loaded successfully!");

        List<String> blockedProtocols = LoadData.model.blockedProtocols;
        List<Integer> blockedPorts = LoadData.model.blockedPorts;
        List<String> blockedIps = LoadData.model.blockedIps;

        RuleSet ruleSet = new RuleSet();

        for (String blockedProtocol : blockedProtocols) {

            Rule rule = new Rule(blockedProtocol, null, null, "BLOCK");
            ruleSet.addRule(rule);

        }

        for (int blockedPort : blockedPorts) {

            Rule rule = new Rule(null, blockedPort, null, "BLOCK");
            ruleSet.addRule(rule);

        }

        for (String blockedIp : blockedIps) {

            Rule rule = new Rule(null, null, blockedIp, "BLOCK");
            ruleSet.addRule(rule);

        }

        String result = RuleEngine.checkPacket(packet, ruleSet.getRuleSet());
        System.out.println(result);

    }

}
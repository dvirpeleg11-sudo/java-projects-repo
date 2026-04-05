package fireWallSimulation;

import java.io.FileNotFoundException;
import java.util.List;

public class Program {

    public static void main(String[] arg) throws FileNotFoundException {

        System.out.println();

        RuleSet ruleSet = JsonRules.createRules();
        List<Rule> rules = ruleSet.getRuleSet();

        Packet[] packets = new Packet[10];
        for (int i = 0; i < packets.length; i++){
            packets[i] = Packet.createRandomPacket();
        }

        for (Packet packet: packets){
            RuleEngine.checkPacket(packet, rules);
        }
        System.out.println();

        String statistics = RuleEngine.getStatistics();
        System.out.println("Statistics:");
        System.out.println(statistics);

        System.out.println();
    }
}
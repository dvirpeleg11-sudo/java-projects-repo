package fireWallSimulation;

import java.util.List;

public class RuleEngine {

    static private int blockedPackets;
    static private int allowedPackets;
    static private final int[] blockedPorts = new int[65535];
    static private final int[] commonProtocols = new int[Protocols.values().length];
    static private String action = "";

    public static String checkPacket(Packet packet, List<Rule> rules) {

        for (Rule rule : rules) {

            boolean areSrcIpTheSame = packet.getSrcIp().equals(rule.getSrcIp());
            boolean areDstIpTheSame = packet.getDstIp().equals(rule.getDstIp());
            boolean areProtocolsTheSame = packet.getProtocol().equals(rule.getProtocol());
            boolean arePortsTheSame = packet.getDstPort() == rule.getPort();

            if (areSrcIpTheSame && areDstIpTheSame && areProtocolsTheSame && arePortsTheSame) {

                action = rule.getAction();
                break;

            }

        }

        if (action.isEmpty()){
            action = LoadData.model.defaultPolicies;
        }

        // updating statistics
        commonProtocols[Protocols.valueOf(packet.getProtocol()).ordinal()]++;

        if (action.equals("ALLOW")){
            allowedPackets++;
        }else{
            blockedPackets++;
            blockedPorts[packet.getDstPort()]++;
        }

        System.out.printf("[" + action + "] src=" + packet.getSrcIp() + " dst=" + packet.getDstIp() + "port=" + packet.getDstPort() + "protocol=" + packet.getProtocol());
        return action;

    }

    private static int findMaxIndex(int[] arr){

        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static String getStatistics(){

        String TotalPackets = "Total packets processed: " + allowedPackets + blockedPackets;
        String Blocked = "Blocked: " + blockedPackets;
        String Allowed = "Allowed: " + allowedPackets;

        int mostBlockedPort = findMaxIndex(blockedPorts);
        String Ports = "Most blocked port: "  + mostBlockedPort;

        Protocols mostCommonProtocol = Protocols.values()[findMaxIndex(commonProtocols)];
        String Protocols = "Most common protocol: "  + mostCommonProtocol.name();

        return TotalPackets + Blocked + Allowed + Ports + Protocols;

    }

}
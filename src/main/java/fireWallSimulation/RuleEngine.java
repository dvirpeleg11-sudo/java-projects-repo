package fireWallSimulation;

import java.util.List;

public class RuleEngine {

    public static String checkPacket(Packet packet, List<Rule> rules) {

        for (Rule rule : rules) {

            boolean areProtocolsTheSame = packet.getProtocol().equals(rule.getProtocol());
            boolean arePortsTheSame = packet.getDstPort() == rule.getPort();
            boolean areSrcIpTheSame = packet.getSrcIp().equals(rule.getSrcIp());

            if (areProtocolsTheSame && arePortsTheSame && areSrcIpTheSame) {

                return rule.getAction();

            }

        }

        return LoadData.model.defaultPolicies;

    }

}
package fireWallSimulation;

public class Rule {

    private String srcIp;
    private String dstIp;
    private String protocol;
    private Integer port;
    private String action; // "ALLOW" or "BLOCK"

    public Rule(String srcIp, String dstIp, String protocol, Integer dstPort, String action) {
        this.srcIp = srcIp;
        this.dstIp = dstIp;

        if (Protocols.isStringInProtocols(protocol)){
            this.protocol = protocol;
        }else{
            this.protocol = null;
        }

        this.port = dstPort;
        this.action = action;
    }

    // Getters
    public String getSrcIp() { return srcIp; }
    public String getDstIp() { return dstIp; }
    public String getProtocol() { return protocol; }
    public Integer getPort() { return port; }
    public String getAction() { return action; }
}
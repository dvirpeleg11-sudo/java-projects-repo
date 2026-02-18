package fireWallSimulation;

public class Rule {

    private String protocol;
    private Integer port;
    private String srcIp;
    private String action; // "ALLOW" or "BLOCK"

    public Rule(String protocol, Integer port, String srcIp, String action) {
        this.protocol = protocol;
        this.port = port;
        this.srcIp = srcIp;
        this.action = action;
    }

    // Getters
    public String getProtocol() { return protocol; }
    public Integer getPort() { return port; }
    public String getSrcIp() { return srcIp; }
    public String getAction() { return action; }
}
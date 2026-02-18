package fireWallSimulation;

public class Packet {

    private String srcIp;
    private String protocol;
    private int dstPort;

    public Packet(String srcIp, String protocol, int dstPort) {
        this.srcIp = srcIp;
        this.protocol = protocol;
        this.dstPort = dstPort;
    }

    public String getSrcIp() { return srcIp; }
    public String getProtocol() { return protocol; }
    public int getDstPort() { return dstPort; }
}
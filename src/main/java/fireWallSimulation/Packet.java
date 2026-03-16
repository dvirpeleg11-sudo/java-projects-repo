package fireWallSimulation;

import java.util.Random;

public class Packet {

    private String srcIp;
    private String protocol;
    private int dstPort;

    public Packet(String srcIp, String protocol, int dstPort) {
        this.srcIp = srcIp;
        this.protocol = protocol;
        this.dstPort = dstPort;
    }

    public Packet createRandomPacket() {

        Random rand = new Random();

        int firstOctet = rand.nextInt(256);
        int secondOctet = rand.nextInt(256);
        int thirdOctet = rand.nextInt(256);
        int fourthOctet = rand.nextInt(256);

        srcIp = firstOctet + "." +  secondOctet + "." + thirdOctet;

        Protocols[] protocols = Protocols.values();
        int randomIndex = rand.nextInt(protocols.length);

        protocol = protocols[randomIndex].name();

        dstPort = rand.nextInt(65535);

        return new Packet(srcIp, protocol, dstPort);

    }

    public String getSrcIp() { return srcIp; }
    public String getProtocol() { return protocol; }
    public int getDstPort() { return dstPort; }

}
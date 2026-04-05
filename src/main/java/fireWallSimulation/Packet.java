package fireWallSimulation;

import java.util.Random;

public class Packet {

    private String srcIp;
    private String dstIp;
    private String protocol;
    private int dstPort;

    public Packet(String srcIp, String dstIp, String protocol, int dstPort) {
        this.srcIp = srcIp;
        this.dstIp = dstIp;
        this.protocol = protocol;
        this.dstPort = dstPort;
    }

    public static Packet createRandomPacket() {

        Random rand = new Random();

        int firstOctet = rand.nextInt(256);
        int secondOctet = rand.nextInt(256);
        int thirdOctet = rand.nextInt(256);
        int fourthOctet = rand.nextInt(256);

        String randSrcIp = firstOctet + "." +  secondOctet + "." + thirdOctet + "." + fourthOctet;

        firstOctet = rand.nextInt(256);
        secondOctet = rand.nextInt(256);
        thirdOctet = rand.nextInt(256);
        fourthOctet = rand.nextInt(256);

        String randDstIp = firstOctet + "." +  secondOctet + "." + thirdOctet + "." + fourthOctet;

        Protocols[] protocols = Protocols.values();
        int randomIndex = rand.nextInt(protocols.length);

        String randProtocol = protocols[randomIndex].name();

        int randDstPort = rand.nextInt(65535);

        return new Packet(randSrcIp, randDstIp, randProtocol, randDstPort);

    }

    public String getSrcIp() { return srcIp; }
    public String getDstIp() { return dstIp; }
    public String getProtocol() { return protocol; }
    public int getDstPort() { return dstPort; }

}
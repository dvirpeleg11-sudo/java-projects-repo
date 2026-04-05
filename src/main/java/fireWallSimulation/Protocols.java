package fireWallSimulation;

public enum Protocols {

    BGP,
    OSPF,
    ARP,
    IP,
    IPv4,
    IPv6,
    TCP,
    UDP,
    ICMP,
    DHCP,
    DNS,
    HTTP,
    HTTPS,
    TLS,
    SSL,
    FTP,
    SFTP,
    SSH,
    SMTP,
    IMAP,
    POP3,
    SNMP,
    NTP,
    STP,
    VLAN,
    EIGRP,
    RIP,
    LLDP,
    LACP,
    HSRP,
    VRRP;

    public static boolean isStringInProtocols(String value) {
        try {
            Protocols.valueOf(value);
            return true;
        } catch (IllegalArgumentException | NullPointerException e) {
            return false;
        }
    }

}
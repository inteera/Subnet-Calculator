
public class IpAddress {
    final private int ipAddress;
    final private int firstUsableAddress;
    final private int lastUsableAddress;
    final private int broadcastAddress;
    final private int subnetMask;
    final private int hostCount;
    
    public IpAddress(int ipAddress, int subnetMask){
        this.ipAddress = ipAddress;
        this.subnetMask = subnetMask;
        this.hostCount = ~subnetMask - 1;
        
        int interval = ~subnetMask + 1;
        
        this.firstUsableAddress = ipAddress + 1;
        this.lastUsableAddress = ipAddress + interval - 2;
        this.broadcastAddress = ipAddress + interval - 1;
    }

    public int getIpAddress() {
        return ipAddress;
    }

    public int getFirstUsableAddress() {
        return firstUsableAddress;
    }

    public int getLastUsableAddress() {
        return lastUsableAddress;
    }

    public int getBroadcastAddress() {
        return broadcastAddress;
    }

    public int getSubnetMask() {
        return subnetMask;
    }
    
    public int getHostCount() {
        return hostCount;
    }
    
}

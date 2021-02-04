package HTTP;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

public class DNS {

    private Map<String, String> domain = new HashMap<>();

    public String getAddress(String DomainName){
        if(domain.get(DomainName) != null){
            return domain.get(DomainName);
        }
        try {
            System.out.println("IP 주소를 얻어옵니다 ....");
            InetAddress ip = InetAddress.getByName(DomainName);
            domain.put(DomainName, ip.getHostAddress());
            System.out.println("반환되는 IP 주소 : " + ip.getHostAddress());
            return ip.getHostAddress();
        }catch (UnknownHostException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Map<String, String> getDomainMap(){
        return domain;
    }

}

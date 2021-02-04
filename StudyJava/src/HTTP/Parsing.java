package HTTP;

public class Parsing {
    private HTTP http = new SocketHTTP();
    DNS dns = new DNS();
//    HTTP http = new URLHttp();
    private final String DISNEY = "www.disney.co.kr";
    public void start(){
        String address = dns.getAddress(DISNEY);
        System.out.println("DOMAIN IP : " + address);
        http.SendReq(DISNEY, 80);
        System.out.println("======================================");
        System.out.println("Request Header : " + http.getRequestHeader().getHeaders().toString());
        System.out.println("Response Header : " + http.getResponseHeader().getHeaders().toString());
    }
}

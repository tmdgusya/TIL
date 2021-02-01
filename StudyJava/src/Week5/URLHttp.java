package Week5;

import java.io.*;
import java.net.*;

public class URLHttp implements HTTP{

    private DNS dns = new DNS();
    private final int DEFAULT_PORT = 80;
    private final int DEFAULT_TIMEOUT = 5000;

    public void SendReq(String domain, int port){
        System.out.println("Port : " + port);
        SendReq(domain);
    }

    public void SendReq(String domain) {

        try {
            URL url = new URL("http://"+domain);
            StringBuilder stringBuilder = new StringBuilder();
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String tempData;
            System.out.println(httpURLConnection.getHeaderFields().toString());
            while ((tempData = bufferedReader.readLine()) != null){
                if(tempData.equals("location.replace(\"/home/\");")){
                    SendReq(domain+"/home/");
                }
                if(tempData.equals("location.replace(\"/home/index.jsp\");")){
                    SendReq(domain + "/index.jsp");
                }else{
                    stringBuilder.append(tempData).append("\n");
                }
                System.out.println(tempData);
            }
            bufferedReader.close();
        }catch (MalformedURLException e){

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public RequestHeader getRequestHeader() {
        return null;
    }

    @Override
    public ResponseHeader getResponseHeader() {
        return null;
    }

}

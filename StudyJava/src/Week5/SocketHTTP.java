package Week5;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class SocketHTTP implements HTTP{

    private final int DEFAULT_PORT = 80;
    private final RequestHeader requestHeader = new RequestHeader();
    private final ResponseHeader responseHeader = new ResponseHeader();

    public void defaultSetting(String url){
        requestHeader.setHeader("Method :" , "GET").setHeader("Connection : ", "keep-alive").setHeader("Host : ", url);
    }

    public void SendReq(String url, int port) {
        try (   Socket s = new Socket(url, port);
                PrintWriter wtr = new PrintWriter(s.getOutputStream());
            )
        {
            defaultSetting(url);
            wtr.println("GET /home/index.jsp HTTP/1.1");
            wtr.println("Host: " + url);
            wtr.println("");
            wtr.flush();


            BufferedReader bufRead = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String outStr;


            while((outStr = bufRead.readLine()) != null){
                if(outStr.contains(":")){
                    responseHeader.setHeader(outStr.split(":")[0], outStr.split(":")[1]);
                }
                System.out.println(outStr);
            }
            System.out.println("소켓 연결 종료");
            bufRead.close();
            s.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void SendReq(String url) {
        SendReq(url, DEFAULT_PORT);
    }

    public ResponseHeader getResponseHeader(){
        return responseHeader;
    }

    public RequestHeader getRequestHeader(){
        return requestHeader;
    }
}
package Week5;

public interface HTTP {

    public void SendReq(String url, int port);

    public void SendReq(String url);

    public RequestHeader getRequestHeader();

    public ResponseHeader getResponseHeader();
}

package HTTP;

import java.util.HashMap;
import java.util.Map;

public class Header {

    private final Map<String , String > Headers = new HashMap<>();

    public Header setHeader(String key, String value){
        Headers.put(key, value);
        return this;
    }

    public Map<String, String> getHeaders(){
        return Headers;
    }
}

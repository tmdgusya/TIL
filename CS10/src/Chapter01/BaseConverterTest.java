package Chapter01;

import java.util.ArrayList;

public class BaseConverterTest {
    public static void main(String[] args) {
        boolean[] bin = {false, true, true, true};
        BaseConverter baseConverter = new BaseConverter();
        getBaseDec2binResult(17);
        int i = baseConverter.bin2dec(bin);
        System.out.println("결과 = " + i);
    }

    private static void getBaseDec2binResult(int decimal){
        BaseConverter baseConverter = new BaseConverter();
        ArrayList<Boolean> booleans = baseConverter.dec2bin(decimal);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("결과 = [ ");
        for (boolean b : booleans){
            stringBuffer.append(b + " , ");
        }
        stringBuffer.append("]");
        System.out.println(stringBuffer);
    }
}

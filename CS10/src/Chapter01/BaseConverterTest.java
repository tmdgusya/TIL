package Chapter01;

import java.util.ArrayList;

public class BaseConverterTest {
    public static void main(String[] args) {
        boolean[] bin = {false, true, true, true};
        BaseConverter baseConverter = new BaseConverter();
        BitAdder bitAdder = new BitAdder();
        getBaseDec2binResult(17);
        int i = baseConverter.bin2dec(bin);
        System.out.println("결과 = " + i);
        decimalToAfterBinaryOperation(8,90);
    }

    private static void getBaseDec2binResult(int decimal){
        BaseConverter baseConverter = new BaseConverter();
        boolean[] booleans = baseConverter.dec2bin(decimal);
        StringBuffer stringBuffer = new StringBuffer();
        System.out.println("booleans.length = " + booleans.length);
        stringBuffer.append("결과 = [ ");
        for (boolean b : booleans){
            stringBuffer.append(b + " , ");
        }
        stringBuffer.append("]");
        System.out.println(stringBuffer);
    }

    private static void decimalToAfterBinaryOperation(int decimal1, int decimal2){
        BaseConverter baseConverter = new BaseConverter();
        BaseConverter baseConverter1 = new BaseConverter();
        BitAdder bitAdder = new BitAdder();

        boolean[] byteA = baseConverter.dec2bin(decimal1);
        boolean[] byteB = baseConverter1.dec2bin(decimal2);

        boolean[] result = bitAdder.byteAdder(byteA, byteB);

        System.out.println(baseConverter.bin2dec(result));
    }
}

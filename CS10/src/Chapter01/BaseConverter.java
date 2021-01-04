package Chapter01;

import java.util.ArrayList;

public class BaseConverter {
    private int decimal;
    private final ArrayList<Boolean> decimalConvertToBin = new ArrayList<>();

    public BaseConverter() {
    }

    public BaseConverter(int decimal) {
        this.decimal = decimal;
    }

    public boolean[] dec2bin(int decimal) {

        int index = 0;

        while(decimal / 2 != 0){
            decimalConvertToBin.add((decimal % 2) == 1);
            decimal = decimal / 2;
        }
        decimalConvertToBin.add(decimal == 1);
        boolean[] result = new boolean[decimalConvertToBin.size()];

        for (boolean value : decimalConvertToBin){
            result[index] = value;
            index++;
        }
        return result;
    }

    public int bin2dec(boolean[] bin){
        int answer = 0;
        for(int i = 0; i < bin.length; i++){
            if(bin[i] == true){
                answer += Math.pow(2, i);
            }
        }
        return answer;
    }
}

package Chapter01;

public class BitAdderTest {

    public static void main(String[] args) {



        BitAdder bitAdder = new BitAdder();
        boolean[] byteA = {true, true, false, true, true, false, true, false};
        boolean[] byteB = {true, false, true, true, false, false, true, true};
        boolean[] byteA_ = {true, true, false, false, true, false, true, false};
        boolean[] byteB_ = {true, true, false, true, true, false, false ,true};

        printHalfAdderResult(true, true);
        printHalfAdderResult(true,false);
        printHalfAdderResult(false, true);
        printHalfAdderResult(false,false);

        printFullAdderResult(true,true,false);
        printFullAdderResult(true,false,false);
        printFullAdderResult(false, false, false);
        printFullAdderResult(false, false, false);

        printFullAdderResult(true,true,true);
        printFullAdderResult(true, false, true);
        printFullAdderResult(false, true, true);
        printFullAdderResult(false, false, true);

        printByteAdderResult(byteA, byteB);
        printByteAdderResult(byteA_, byteB_);
    }
    private static void printHalfAdderResult(boolean bitA, boolean bitB){
        final int CARRY = 0;
        final int SUM = 1;
        BitAdder bitAdder = new BitAdder();
        boolean[] result = bitAdder.halfAdder(bitA, bitB);
        System.out.println("bitA = " + bitA);
        System.out.println("bitB = " + bitB);
        System.out.println("결과 = [ " + result[CARRY] + " , " + result[SUM] + " ]");
        System.out.println("===============================================");
    }

    private static void printFullAdderResult(boolean bitA, boolean bitB, boolean carry){
        final int CARRY = 0;
        final int SUM = 1;
        BitAdder bitAdder = new BitAdder();
        boolean[] result = bitAdder.fulladder(bitA, bitB, carry);
        System.out.println("bitA = " + bitA);
        System.out.println("bitB = " + bitB);
        System.out.println("carry = " + carry);
        System.out.println("결과 = [ " + result[CARRY] + " , " + result[SUM] + " ]");
        System.out.println("===============================================");
    }

    private static void printByteAdderResult(boolean[] byteA, boolean[] byteB){
        BitAdder bitAdder = new BitAdder();
        boolean[] result = bitAdder.byteAdder(byteA, byteB);
        System.out.println("byte A = " + "[" + byteA[0] + " , " + byteA[1] + " , " + byteA[2] + " , " + byteA[3] + " , "
                + byteA[4] + " , " + byteA[5] + " , " + byteA[6] + " , " + byteA[7] + "]");
        System.out.println("byte B = " + "[" + byteB[0] + " , " + byteB[1] + " , " + byteB[2] + " , " + byteB[3] + " , "
                + byteB[4] + " , " + byteB[5] + " , " + byteB[6] + " , " + byteB[7] + "]");
        System.out.println("결과 = " + "[" + result[0] + " , " + result[1] + " , " + result[2] + " , " + result[3] + " , "
                + result[4] + " , " + result[5] + " , " + result[6] + " , " + result[7] + " , " + result[8] + "]");
        System.out.println("===============================================");
    }
}

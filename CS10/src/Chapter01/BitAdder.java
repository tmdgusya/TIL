package Chapter01;

public class BitAdder {

    private boolean bitA;
    private boolean bitB;
    private boolean carry;
    private final int CARRY = 0;
    private final int SUM = 1;

    public BitAdder(){}

    public BitAdder(boolean bitA, boolean bitB){
        this.bitA = bitA;
        this.bitB = bitB;
    }

    public BitAdder(boolean bitA, boolean bitB, boolean carry){
        this.bitA = bitA;
        this.bitB = bitB;
        this.carry = carry;
    }

    public boolean[] halfAdder(boolean inputBit, boolean inputBit_){
        boolean[] answer = new boolean[2];
        answer[CARRY] = inputBit && inputBit_;
        answer[SUM] = inputBit != inputBit_;
        return answer;
    }


    public boolean[] fulladder(boolean bitA, boolean bitB, boolean carry){
        boolean[] answer = new boolean[2];
        answer[SUM] = halfAdder(carry, halfAdder(bitA, bitB)[SUM])[SUM];
        answer[CARRY] = halfAdder(bitA, bitB)[CARRY] || halfAdder(carry, halfAdder(bitA, bitB)[SUM])[CARRY];
        return answer;
    }

    public boolean[] byteAdder(boolean[] byteA, boolean[] byteB){
        int length = whoIsBigLengthArray(byteA, byteB);
        System.out.println("byteA = " + byteA.length);
        System.out.println("byteB.length = " + byteB.length);
        boolean[] fulladder;
        boolean[] answer = new boolean[length];
        boolean preCalcResult = false;
        for(int i = 0; i < length-1; i++){
            if(i >= byteB.length){
                fulladder = fulladder(byteA[i], false, preCalcResult);
            }else if(i >= byteA.length){
                fulladder = fulladder(false, byteB[i], preCalcResult);
            }else{
                fulladder = fulladder(byteA[i], byteB[i], preCalcResult);
            }
            preCalcResult = isPreCalcResult(answer, i, fulladder);
        }
        return answer;
    }

    private boolean isPreCalcResult(boolean[] answer, int i, boolean[] fulladder) {
        boolean preCalcResult;
        answer[i] = fulladder[SUM];
        answer[i + 1] = fulladder[CARRY];
        preCalcResult = fulladder[CARRY];
        return preCalcResult;
    }

    private int whoIsBigLengthArray(boolean[] byteA, boolean[] byteB){
        int length;
        if(byteA.length > byteB.length){
            length = byteA.length;
        }else {
            length = byteB.length;
        }
        return (length+1);
    }
}

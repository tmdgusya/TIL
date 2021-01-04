package Chapter01;

public class BitAdder {

    private boolean bitA;
    private boolean bitB;
    private final boolean[] byteA = new boolean[8];
    private final boolean[] byteB = new boolean[8];
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

    public boolean[] halfAdder(){
        boolean[] answer = new boolean[2];
        answer[CARRY] = bitA && bitB;
        answer[SUM] = bitA != bitB;
        return answer;
    }

    public boolean[] halfAdder(boolean inputBit, boolean inputBit_){
        boolean[] answer = new boolean[2];
        answer[CARRY] = inputBit && inputBit_;
        answer[SUM] = inputBit != inputBit_;
        return answer;
    }

    public boolean[] fullAdder(){
        boolean[] answer = new boolean[2];
        answer[SUM] = halfAdder(halfAdder(bitA, bitB)[SUM], carry)[SUM];
        answer[CARRY] = halfAdder(bitA, bitB)[CARRY] || halfAdder(carry, halfAdder(bitA, bitB)[SUM])[CARRY];
        return answer;
    }

    public boolean[] fulladder(boolean bitA, boolean bitB, boolean carry){
        boolean[] answer = new boolean[2];
        answer[SUM] = halfAdder(halfAdder(bitA, bitB)[SUM], carry)[SUM];
        answer[CARRY] = halfAdder(bitA, bitB)[CARRY] || halfAdder(carry, halfAdder(bitA, bitB)[SUM])[CARRY];
        return answer;
    }

    public boolean[] byteAdder(){
        boolean[] answer = new boolean[9];
        boolean[] results = new boolean[2];
        boolean preCalcResult = false;
        for(int i = 0; i < byteA.length; i++){
            boolean[] fulladder = fulladder(byteA[i], byteB[i], preCalcResult);
            preCalcResult = isPreCalcResult(answer, i, fulladder);
        }
        return answer;
    }


    public boolean[] byteAdder(boolean[] byteA, boolean[] byteB){
        boolean[] answer = new boolean[9];
        boolean[] results = new boolean[2];
        boolean preCalcResult = false;
        for(int i = 0; i < byteA.length; i++){
            boolean[] fulladder = fulladder(byteA[i], byteB[i], preCalcResult);
            preCalcResult = isPreCalcResult(answer, i, fulladder);
        }
        return answer;
    }


    private boolean isPreCalcResult(boolean[] answer, int i, boolean[] fulladdr) {
        boolean preCalcResult;
        answer[i] = fulladdr[SUM];
        answer[i + 1] = fulladdr[CARRY];
        preCalcResult = fulladdr[CARRY];
        return preCalcResult;
    }
}

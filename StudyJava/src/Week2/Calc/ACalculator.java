package Week2.Calc;

public class ACalculator implements Calculator{

    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public int sub(int a, int b) {
        return a-b;
    }

    @Override
    public int div(int a, int b) {
        return a/b;
    }

    @Override
    public int mul(int a, int b) {
        return a*b;
    }

    @Override
    public int mod(int a, int b) {
        return a%b;
    }

    @Override
    public double getLineMeter(int x1, int y1, int x2, int y2) {
        if(x2 < x1){
            throw new IllegalArgumentException("x2 의 값이 x1 보다 작습니다.");
        }
        int xMeter = x2 - x1;
        int yMeter = y2 - y1;
        double lineMeter = Math.sqrt(Math.pow(xMeter,2) + Math.pow(yMeter,2));
        return lineMeter;
    }

    @Override
    public double getTriangleArea(int width, int height) {
        return (width*height) / 2 ;
    }


    @Override
    public double getTriangleArea(double x1, double x2, double x3) {
        double pow_x1 = Math.pow(x1, 2);
        double pow_x2 = Math.pow(x2, 2);
        double pow_x3 = Math.pow(x3, 2);
        double area = Math.sqrt((4*pow_x1*pow_x2 - Math.pow((pow_x1+pow_x2-pow_x3),2)))/ 4;
        return area;
    }

    @Override
    public double getSquadreArea(double width, double height) {
        return width*height;
    }
}

package Graph.Calc;

public interface Calculator {
    public int add(int a, int b);

    public int sub(int a, int b);

    public int div(int a, int b);

    public int mul(int a, int b);

    public int mod(int a, int b);

    public double getLineMeter(int x1, int y1, int x2, int y2);

    public double  getTriangleArea(int width, int height);

    //@Overload
    public double getTriangleArea(double x1, double x2, double x3);

    public double getSquadreArea(double width, double height);
}

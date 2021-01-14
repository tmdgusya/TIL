package Week2.Boot;

import Week2.Calc.Calculator;
import Week2.Rendering.Graph;
import Week2.UserInterface.UserInputInterface;

import java.io.IOException;

public class MainLogic {
    UserInputInterface userInputInterface;
    Calculator calculator;
    Graph graph;
    int countOfLocation;
    String[] locations;

    public MainLogic(UserInputInterface userInputInterface, Calculator calculator, Graph graph) {
        this.userInputInterface = userInputInterface;
        this.calculator = calculator;
        this.graph = graph;
    }

    public void start() throws IOException, IllegalAccessException {
        String userInputLocation = userInputInterface.userInput();
        locations = userInputInterface.parsingLocation(userInputLocation);
        this.countOfLocation = userInputInterface.howManyCountOfLocations();
        selectCalcFromLocations(countOfLocation);
    }

    public void selectCalcFromLocations(int countOfLocation){
        double area = 0;
        if(countOfLocation == 4){
            LineMeterLogic();
        }else if(countOfLocation == 6){
            TriangleLogic();
        }else if(countOfLocation == 8){
            SquareLogic();
        }
    }

    private void SquareLogic() {
        double area;
        int x1 = Integer.parseInt(locations[0]);
        int y1 = Integer.parseInt(locations[1]);
        int x2 = Integer.parseInt(locations[2]);
        int y2 = Integer.parseInt(locations[3]);
        int x3 = Integer.parseInt(locations[4]);
        int y3 = Integer.parseInt(locations[5]);
        int x4 = Integer.parseInt(locations[6]);
        int y4 = Integer.parseInt(locations[7]);
        double lineOne = calculator.getLineMeter(x1,y1,x2,y2);
        double lineTwo = calculator.getLineMeter(x2,y2,x3,y3);
        graph.render(x1,y1,x2,y2,x3,y3,x4,y4);
        area = calculator.getSquadreArea(lineOne, lineTwo);
        System.out.println("사각형의 넓이는 : " + area);
    }

    private void TriangleLogic() {
        double area;
        int x1 = Integer.parseInt(locations[0]);
        int y1 = Integer.parseInt(locations[1]);
        int x2 = Integer.parseInt(locations[2]);
        int y2 = Integer.parseInt(locations[3]);
        int x3 = Integer.parseInt(locations[4]);
        int y3 = Integer.parseInt(locations[5]);
        double lineOne = calculator.getLineMeter(x1,y1,x2,y2);
        double lineTwo = calculator.getLineMeter(x2,y2,x3,y3);
        double lineThree = calculator.getLineMeter(x1,y1,x3,y3);
        area = calculator.getTriangleArea(lineOne, lineTwo, lineThree);
        graph.render(x1,y1,x2,y2,x3,y3);
        System.out.println("삼각형의 넓이는 : " + area);
    }

    private void LineMeterLogic() {
        double area;
        int x1 = Integer.parseInt(locations[0]);
        int y1 = Integer.parseInt(locations[1]);
        int x2 = Integer.parseInt(locations[2]);
        int y2 = Integer.parseInt(locations[3]);
        area = calculator.getLineMeter(x1,y1,x2,y2);
        graph.render(x1, y1, x2, y2);
        System.out.println("두점 사이의 거리는 : " + area);
    }

}

package Graph.Boot;

import Graph.Calc.ACalculator;
import Graph.Calc.Calculator;
import Graph.Rendering.AGraph;
import Graph.Rendering.Graph;
import Graph.UserInterface.AUserInputInterface;
import Graph.UserInterface.UserInputInterface;

import java.io.IOException;

public class Boot {

    Calculator calculator = new ACalculator();
    Graph graph = new AGraph();
    UserInputInterface userInputInterface = new AUserInputInterface();

    public void booting() throws IOException, IllegalAccessException {
        MainLogic mainLogic = new MainLogic(userInputInterface, calculator, graph);
        mainLogic.start();
    }
}

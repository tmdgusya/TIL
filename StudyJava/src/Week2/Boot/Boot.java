package Week2.Boot;

import Week2.Calc.ACalculator;
import Week2.Calc.Calculator;
import Week2.Rendering.AGraph;
import Week2.Rendering.Graph;
import Week2.UserInterface.AUserInputInterface;
import Week2.UserInterface.UserInputInterface;

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

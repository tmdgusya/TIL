package Last.Button;

import java.awt.*;
import java.util.ArrayList;

public class Menu {

    private final Head head = new Head();
    private final Body body = new Body();
    private final LeftLeg leftleg = new LeftLeg();
    private final RightLeg rightLeg = new RightLeg();
    private final Mouse mouse = new Mouse();
    private final Eye eye = new Eye();

    ArrayList<Button> buttonArrayList = new ArrayList<>();

    public Menu() {
        buttonArrayList.add(head.getButton());
        buttonArrayList.add(body.getButton());
        buttonArrayList.add(leftleg.getButton());
        buttonArrayList.add(rightLeg.getButton());
        buttonArrayList.add(mouse.getButton());
        buttonArrayList.add(eye.getButton());
    }

    public ArrayList<Button> getButtonArrayList() {
        return buttonArrayList;
    }
}

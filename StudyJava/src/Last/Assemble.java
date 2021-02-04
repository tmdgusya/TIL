package Last;

import Last.Button.*;
import Last.Button.Menu;

import java.awt.*;
import java.util.ArrayList;

public class Assemble {

    private DefaultFrame defaultFrame = new DefaultFrame();
    private Menu menu = new Menu();

    public Frame assemble(){
        final Frame frame = defaultFrame.getFrame();
        final Canvas canvas = DefaultCanvas.getCanvas();
        frame.add(canvas);
        final ArrayList<Button> buttonArrayList = menu.getButtonArrayList();
        for(Button b : buttonArrayList){
            frame.add(b);
        }
        frame.setVisible(true);
        return frame;
    }

}

package Last.Button;

import Last.DefaultCanvas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Head {

    private Button button = new Button();
    private static Canvas canvas = DefaultCanvas.getCanvas();

    public Head() {
        button.addActionListener(new Head.drawSquare());
        button.setLabel("Head");
    }

    static class drawSquare implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Graphics g =  canvas.getGraphics();
            g.setColor(Color.WHITE);
            g.fillArc(50, 10, 100, 100, 90, 360);
            System.out.println("Head 을 그립니다.");
        }
    }

    public Button getButton() {
        return button;
    }
}

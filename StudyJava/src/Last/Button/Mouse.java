package Last.Button;

import Last.DefaultCanvas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mouse {
    private Button button = new Button();
    private static Canvas canvas = DefaultCanvas.getCanvas();

    public Mouse() {
        button.addActionListener(new Mouse.drawSquare());
        button.setLabel("Mouse");
    }

    static class drawSquare implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Graphics g =  canvas.getGraphics();
            g.setColor(Color.BLACK);
            g.fillArc(90, 50, 58, 50, 320, 60);
            System.out.println("Mouse 을 그립니다.");
        }
    }

    public Button getButton() {
        return button;
    }
}

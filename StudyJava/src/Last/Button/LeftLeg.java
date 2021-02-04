package Last.Button;

import Last.DefaultCanvas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeftLeg {
    private Button button = new Button();
    private static Canvas canvas = DefaultCanvas.getCanvas();

    public LeftLeg() {
        button.addActionListener(new drawLine());
        button.setLabel("LeftLeg");
    }

    static class drawLine implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Graphics graphics = canvas.getGraphics();
            graphics.drawLine(70,210,20,250);
            System.out.println("LeftLeg 을 그립니다.");
        }
    }

    public Button getButton() {
        return button;
    }
}

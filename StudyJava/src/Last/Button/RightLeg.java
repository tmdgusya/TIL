package Last.Button;

import Last.DefaultCanvas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RightLeg {
    private Button button = new Button();
    private static Canvas canvas = DefaultCanvas.getCanvas();

    public RightLeg() {
        button.addActionListener(new RightLeg.drawLine());
        button.setLabel("RightLeg");
    }

    static class drawLine implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Graphics graphics = canvas.getGraphics();
            graphics.drawLine(130,210,180,250);
            System.out.println("RightLeg 를 그립니다.");
        }
    }

    public Button getButton() {
        return button;
    }
}

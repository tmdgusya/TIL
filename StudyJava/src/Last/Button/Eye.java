package Last.Button;

import Last.DefaultCanvas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Eye {
    private Button button = new Button();
    private static Canvas canvas = DefaultCanvas.getCanvas();

    public Eye() {
        button.addActionListener(new Eye.drawEye());
        button.setLabel("Eye");
    }

    static class drawEye implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Graphics g =  canvas.getGraphics();
            g.setColor(Color.BLACK);
            g.fillArc(120, 30, 20, 20, 90, 360);
            System.out.println("Eye 을 그립니다.");
        }
    }

    public Button getButton() {
        return button;
    }
}

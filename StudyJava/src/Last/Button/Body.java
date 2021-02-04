package Last.Button;

import Last.DefaultCanvas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Body {

    private Button button = new Button();
    private static Canvas canvas = DefaultCanvas.getCanvas();

    public Body() {
        button.addActionListener(new drawSquare());
        button.setLabel("Body");
    }

    static class drawSquare implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            final Graphics graphics = canvas.getGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRoundRect(50,110,100,100,10,10);
            System.out.println("Body 를 그립니다.");
        }
    }

    public Button getButton() {
        return button;
    }
}

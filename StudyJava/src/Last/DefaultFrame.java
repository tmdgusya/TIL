package Last;

import java.awt.*;

public class DefaultFrame {
    private final int WIDTH = 600;
    private final int FRAME_HEIGHT = 500;
    private Frame frame;
    private final String FRAME_NAME = "CANVAS";

    public DefaultFrame() {
        this.frame = new Frame(FRAME_NAME);
        frame.setSize(WIDTH,FRAME_HEIGHT);
        frame.setLayout(new FlowLayout());
        frame.setVisible(false);
    }

    public Frame getFrame() {
        return frame;
    }
}

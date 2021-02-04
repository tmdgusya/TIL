package Last;

import java.awt.*;

public class DefaultCanvas {

    private static final int Y_MARGIN = 100;
    private static final int X_MARGIN = 0;
    private static final int WIDTH = 600;
    private static final int CANVAS_HEIGHT = 400;
    private static Canvas canvas = new Canvas();

    public DefaultCanvas() {
    }

    public static Canvas getCanvas() {
        canvas.setBackground(Color.GREEN);
        canvas.setBounds(X_MARGIN, Y_MARGIN, WIDTH, CANVAS_HEIGHT);
        return canvas;
    }

    final static class Holder {
        private static DefaultCanvas defaultCanvas = new DefaultCanvas();
    }


}

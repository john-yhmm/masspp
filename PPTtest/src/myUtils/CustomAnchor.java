package myUtils;

import java.awt.Rectangle;

public class CustomAnchor {
    private int x = DEFAULT.DEFAULT_X_OFFSET;
    private int y = DEFAULT.DEFAULT_Y_OFFSET;
    private int width = DEFAULT.DEFAULT_ANCHOR_WIDTH;
    private int height = DEFAULT.DEFAULT_ANCHOR_HEIGHT;

    public Rectangle getRectangle() {
        return new Rectangle(x, y, width, height);
    }
}

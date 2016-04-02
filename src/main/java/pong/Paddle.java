package pong;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

abstract class Paddle {
    Rectangle shape;

    void init(GameContainer game) {
        int x = getStartingX(game);
        shape = new Rectangle(x, game.getHeight() / 2 - getHeight() / 2, getWidth(), getHeight());
    }

    void render(GameContainer game, Graphics g) {
        g.setColor(getColor());
        g.fillRect(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
    }

    void update(GameContainer game, int delta) {
        movePaddle(delta);
        checkPaddleOnTable(game);
    }

    int getWidth() {
        return 20;
    }

    int getHeight() {
        return 100;
    }

    float getSpeed() {
        return 0.5f;
    }

    abstract int getStartingX(GameContainer game);
    abstract Color getColor();
    abstract void movePaddle(int delta);

    private void checkPaddleOnTable(GameContainer game) {
        if (shape.getY() < 0) {
            shape.setY(0);
        }
        if (shape.getY() > game.getHeight() - shape.getHeight()) {
            shape.setY(game.getHeight() - shape.getHeight());
        }
        if (shape.getX() < 0) {
            shape.setX(0);
        }
        if (shape.getMaxX() > game.getWidth()) {
            shape.setX(game.getWidth() - shape.getWidth());
        }
    }
}

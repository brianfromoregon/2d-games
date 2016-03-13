package pong.complete;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

public class Paddle {
    private static final Color red = new Color(150, 0, 0);
    private static final float speed = 0.5f;

    final boolean isPlayer1;
    Rectangle shape;

    public Paddle(boolean isPlayer1) {
        this.isPlayer1 = isPlayer1;
    }

    public void init(GameContainer game) {
        int width = 20;
        int height = 100;
        int x;
        if (isPlayer1) {
            x = 0;
        } else {
            x = game.getWidth() - width;
        }
        shape = new Rectangle(x, game.getHeight() / 2 - height / 2, width, height);
    }

    public void render(GameContainer game, Graphics g) {
        g.setColor(isPlayer1 ? Color.black : red);
        g.fillRect(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
    }

    public void update(GameContainer game, int delta) {
        movePaddle(delta);
        checkPaddleOnTable(game);
    }

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

    private void movePaddle(int delta) {
        if (isPlayer1 && Keyboard.isKeyDown(Keyboard.KEY_W)
                || !isPlayer1 && Keyboard.isKeyDown(Keyboard.KEY_UP)) {
            shape.setY(shape.getY() - speed * delta);
        }
        if (isPlayer1 && Keyboard.isKeyDown(Keyboard.KEY_S)
                || !isPlayer1 && Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
            shape.setY(shape.getY() + speed * delta);
        }
        if (isPlayer1 && Keyboard.isKeyDown(Keyboard.KEY_A)
                || !isPlayer1 && Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
            shape.setX(shape.getX() - speed * delta);
        }
        if (isPlayer1 && Keyboard.isKeyDown(Keyboard.KEY_D)
                || !isPlayer1 && Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
            shape.setX(shape.getX() + speed * delta);
        }
    }
}

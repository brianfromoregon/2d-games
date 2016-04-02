package pong;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;

class RightPaddle extends Paddle {
    private static final Color red = new Color(150, 0, 0);

    @Override
    int getStartingX(GameContainer game) {
        return game.getWidth() - getWidth();
    }

    @Override
    Color getColor() {
        return red;
    }

    @Override
    void movePaddle(int delta) {

        if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {
            shape.setY(shape.getY() - getSpeed() * delta);
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
            shape.setY(shape.getY() + getSpeed() * delta);
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
            shape.setX(shape.getX() - getSpeed() * delta);
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
            shape.setX(shape.getX() + getSpeed() * delta);
        }
    }
}

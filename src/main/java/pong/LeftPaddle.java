package pong;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;

class LeftPaddle extends Paddle {

    @Override
    int getStartingX(GameContainer game) {
        return 0;
    }

    @Override
    Color getColor() {
        return Color.black;
    }

    @Override
    void movePaddle(int delta) {
        if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
            shape.setY(shape.getY() - getSpeed() * delta);
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
            shape.setY(shape.getY() + getSpeed() * delta);
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
            shape.setX(shape.getX() - getSpeed() * delta);
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
            shape.setX(shape.getX() + getSpeed() * delta);
        }
    }
}

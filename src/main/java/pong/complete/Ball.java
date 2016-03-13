package pong.complete;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;

import java.util.Random;

public class Ball {
    private final Paddle paddle1, paddle2;
    private final Random random = new Random();
    private float dx, dy;
    Circle shape;
    int hits;

    public Ball(Paddle paddle1, Paddle paddle2) {
        this.paddle1 = paddle1;
        this.paddle2 = paddle2;
    }

    public void init(GameContainer game) {
        shape = new Circle(game.getWidth() / 2, game.getHeight() / 2, 10);
        boolean left = random.nextBoolean();
        boolean up = random.nextBoolean();
        dx = .25f;
        if (left) dx *= -1;
        dy = .25f;
        if (up) dy *= -1;
    }

    public void render(GameContainer game, Graphics g) {
        g.setColor(Color.white);
        g.fillOval(shape.getX(), shape.getY(), shape.getRadius() * 2, shape.getRadius() * 2);
    }

    public void update(GameContainer game, int delta) {
        moveBall(delta);
        checkBallHitPaddle();
        checkBallOnTable(game);
    }

    private void checkBallOnTable(GameContainer game) {
        if (shape.getMinY() < 0) {
            shape.setY(0);
            dy = -dy;
        }
        if (shape.getMaxY() > game.getHeight()) {
            shape.setY(game.getHeight() - shape.getRadius() * 2);
            dy = -dy;
        }
    }

    private void checkBallHitPaddle() {
        if (dx < 0 && paddle1.shape.intersects(shape)
                || dx > 0 && paddle2.shape.intersects(shape)) {
            dx *= -1.2f;
            hits++;
        }
    }

    private void moveBall(int delta) {
        shape.setX(shape.getX() + delta * dx);
        shape.setY(shape.getY() + delta * dy);
    }

}

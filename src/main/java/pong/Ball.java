package pong;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;

import java.util.Random;

public class Ball {
    private final Paddle paddle1, paddle2;
    private final Random random = new Random();
    private float xSpeed, ySpeed;
    Circle shape;
    int hits;

    public Ball(Paddle paddle1, Paddle paddle2) {
        this.paddle1 = paddle1;
        this.paddle2 = paddle2;
    }

    public void init(GameContainer game) {
        shape = new Circle(game.getWidth() / 2, game.getHeight() / 2, ballRadius());
        boolean left = random.nextBoolean();
        boolean up = random.nextBoolean();
        xSpeed = startingXSpeed();
        if (left) xSpeed *= -1;
        ySpeed = startingYSpeed();
        if (up) ySpeed *= -1;
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
            ySpeed = -ySpeed;
        }
        if (shape.getMaxY() > game.getHeight()) {
            shape.setY(game.getHeight() - shape.getRadius() * 2);
            ySpeed = -ySpeed;
        }
    }

    private void checkBallHitPaddle() {
        if (xSpeed < 0 && paddle1.shape.intersects(shape)
                || xSpeed > 0 && paddle2.shape.intersects(shape)) {
            xSpeed *= -1.2f;
            hits++;
        }
    }

    private void moveBall(int delta) {
        shape.setX(shape.getX() + delta * xSpeed);
        shape.setY(shape.getY() + delta * ySpeed);
    }

    public float startingXSpeed() {
        return 0.25f;
    }

    public float startingYSpeed() {
        return 0.25f;
    }

    public float ballRadius() {
        return 10;
    }
}

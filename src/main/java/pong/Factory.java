package pong;

import org.newdawn.slick.GameContainer;

public class Factory {
    GameContainer game;

    public Factory(GameContainer game) {
        this.game = game;
    }

    public Ball createBall(Paddle paddle1, Paddle paddle2) {
        Ball ball = new Ball(paddle1, paddle2);
        ball.init(game);
        return ball;
    }

    public Paddle createPaddle(boolean isPlayer1) {
        Paddle paddle = new Paddle(isPlayer1);
        paddle.init(game);
        return paddle;
    }
}

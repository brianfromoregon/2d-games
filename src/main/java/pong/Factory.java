package pong;

import org.newdawn.slick.GameContainer;

class Factory {
    GameContainer game;

    Factory(GameContainer game) {
        this.game = game;
    }

    Ball createBall(Paddle paddle1, Paddle paddle2) {
        Ball ball = new Ball(paddle1, paddle2);
        ball.init(game);
        return ball;
    }

    Paddle createLeftPaddle() {
        Paddle paddle = new LeftPaddle();
        paddle.init(game);
        return paddle;
    }

    Paddle createRightPaddle() {
        Paddle paddle = new RightPaddle();
        paddle.init(game);
        return paddle;
    }
}

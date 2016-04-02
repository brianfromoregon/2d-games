package pong;

class SlowBall extends Ball {
    SlowBall(Paddle paddle1, Paddle paddle2) {
        super(paddle1, paddle2);
    }

    @Override
    float startingXSpeed() {
        return 0.025f;
    }
}

package pong;

public class SlowBall extends Ball {
    public SlowBall(Paddle paddle1, Paddle paddle2) {
        super(paddle1, paddle2);
    }

    @Override
    public float startingXSpeed() {
        return 0.025f;
    }
}

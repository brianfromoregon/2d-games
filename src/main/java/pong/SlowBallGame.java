package pong;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;

/**
 * When running this class in IDE, add VM option: -Djava.library.path=target/natives
 */
public class SlowBallGame extends PingPongGame {

    public static void main(String[] args) throws Exception {
        AppGameContainer app = new AppGameContainer(new SlowBallGame());
        app.setDisplayMode(Display.width, Display.height, false);
        app.start();
    }

    @Override
    Factory createFactory(GameContainer game) {
        return new Factory(game) {
            @Override
            Ball createBall(Paddle paddle1, Paddle paddle2) {
                Ball ball = new SlowBall(paddle1, paddle2);
                ball.init(game);
                return ball;
            }
        };
    }
}

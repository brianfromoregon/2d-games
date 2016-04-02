package pong;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;

/**
 * When running this class in IDE, add VM option: -Djava.library.path=target/natives
 */
public class ObamaBallGame extends PingPongGame {

    public static void main(String[] args) throws Exception {
        AppGameContainer app = new AppGameContainer(new ObamaBallGame());
        app.setDisplayMode(Display.width, Display.height, false);
        app.start();
    }

    @Override
    public Factory createFactory(GameContainer game) {
        return new Factory(game) {
            @Override
            public Ball createBall(Paddle paddle1, Paddle paddle2) {
                Ball ball = new ObamaBall(paddle1, paddle2);
                ball.init(game);
                return ball;
            }
        };
    }
}

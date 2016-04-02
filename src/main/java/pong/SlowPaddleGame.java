package pong;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;

/**
 * When running this class in IDE, add VM option: -Djava.library.path=target/natives
 */
public class SlowPaddleGame extends PingPongGame {

    public static void main(String[] args) throws Exception {
        AppGameContainer app = new AppGameContainer(new SlowPaddleGame());
        app.setDisplayMode(Display.width, Display.height, false);
        app.start();
    }

    @Override
    Factory createFactory(GameContainer game) {
        return new Factory(game) {
            @Override
            Paddle createRightPaddle() {
                Paddle paddle = new SlowPaddle();
                paddle.init(game);
                return paddle;
            }
        };
    }

    class SlowPaddle extends RightPaddle {
        @Override
        float getSpeed() {
            return 0.05f;
        }
    }
}

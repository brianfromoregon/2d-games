package harris;

import org.newdawn.slick.*;

/**
 * When running this class in IDE, add VM option: -Djava.library.path=target/natives
 */
public class PingPongGame extends BasicGame {

    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;

    Table table;

    public PingPongGame() {
        super("Ping Pong");
    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        table.render(container, g);
    }

    @Override
    public void init(GameContainer game) throws SlickException {
        table = new Table();
        table.init(game);
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        table.update(container, delta);
    }
    
    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new PingPongGame());
        app.setDisplayMode(WIDTH, HEIGHT, false);
        app.start();
    }

}

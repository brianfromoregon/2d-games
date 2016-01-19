package harris;

import org.newdawn.slick.*;
import org.newdawn.slick.util.InputAdapter;

import java.awt.event.KeyEvent;

public class PingPong extends BasicGame {

    private static final int WIDTH = 1200;
    private static final int HEIGHT = 700;

    Table table;

    public PingPong() {
        super("Ping Pong");
    }

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
        AppGameContainer app = new AppGameContainer(new PingPong());
        app.setDisplayMode(WIDTH, HEIGHT, false);
        app.start();
    }

}

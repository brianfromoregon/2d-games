package pong;

import org.newdawn.slick.*;

public class PingPongGame extends BasicGame {

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
        table.init(game, createFactory(game));
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        table.update(container, delta);
    }

    public Factory createFactory(GameContainer game) {
        return new Factory(game);
    }
}

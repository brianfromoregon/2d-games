package pong;

import com.google.common.base.Throwables;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ObamaBall extends Ball {
    Image img;

    public ObamaBall(Paddle paddle1, Paddle paddle2) {
        super(paddle1, paddle2);
    }

    @Override
    public void init(GameContainer game) {
        super.init(game);

        try {
            img = new Image("obama-head.png");
        } catch (SlickException e) {
            Throwables.propagate(e);
        }
    }

    @Override
    public void render(GameContainer game, Graphics g) {
        img.draw(shape.getX(), shape.getY(), shape.getRadius() * 2, shape.getRadius() * 2);
    }

    @Override
    public float ballRadius() {
        return 100;
    }
}

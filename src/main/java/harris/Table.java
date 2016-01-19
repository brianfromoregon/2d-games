package harris;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;

import java.awt.*;


/**
 * Created by owner on 1/18/16.
 */
public class Table {
    private static final Color green = new Color(0, 102, 0);
    private static final TrueTypeFont scoreFont;
    private static final TrueTypeFont bottomFont;

    static {
        Font f = new Font("Verdana", Font.PLAIN, 76);
        scoreFont = new TrueTypeFont(f, true);
        f = new Font("Verdana", Font.PLAIN, 36);
        bottomFont = new TrueTypeFont(f, true);
    }

    Paddle paddle1 = new Paddle(true);
    Paddle paddle2 = new Paddle(false);
    Ball ball;
    int score1, score2;
    int longestVolley;

    public void init(GameContainer game) {
        paddle1.init(game);
        paddle2.init(game);
        ball = new Ball(paddle1, paddle2);
        ball.init(game);
    }

    public void render(GameContainer game, Graphics g) {
        g.setColor(green);
        g.fillRect(0, 0, game.getWidth(), game.getHeight());
        String score = score1 + " - " + score2;
        int w = scoreFont.getWidth(score);
        scoreFont.drawString(game.getWidth() / 2 - w / 2, 0, score, Color.black);
        String bottom = "Volley: " + ball.hits + "  Longest: " + longestVolley;
        w = bottomFont.getWidth(bottom);
        int h = bottomFont.getLineHeight();
        bottomFont.drawString(game.getWidth() / 2 - w / 2, game.getHeight() - h, bottom, Color.black);
        paddle1.render(game, g);
        paddle2.render(game, g);
        ball.render(game, g);
    }

    public void update(GameContainer game, int delta) {
        paddle1.update(game, delta);
        paddle2.update(game, delta);
        ball.update(game, delta);

        if (ball.shape.getMaxX() < 0 || ball.shape.getMinX() > game.getWidth()) {
            if (ball.shape.getMaxX() < 0) {
                score2++;
            } else {
                score1++;
            }
            if (ball.hits > longestVolley) {
                longestVolley = ball.hits;
            }
            ball = new Ball(paddle1, paddle2);
            ball.init(game);
        }
    }
}
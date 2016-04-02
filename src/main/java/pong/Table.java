package pong;

import org.newdawn.slick.Color;
import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;

public class Table {
    private static final Color green = new Color(0, 102, 0);

    Factory factory;
    Paddle paddle1;
    Paddle paddle2;
    Ball ball;
    int score1, score2;
    int longestVolley;

    public void init(GameContainer game, Factory factory) {
        this.factory = factory;
        paddle1 = factory.createPaddle(true);
        paddle2 = factory.createPaddle(false);
        ball = factory.createBall(paddle1, paddle2);
    }

    public void render(GameContainer game, Graphics g) {
        drawBackground(game, g);
        drawScore(game, g);
        drawStats(game, g);

        paddle1.render(game, g);
        paddle2.render(game, g);
        ball.render(game, g);
    }

    private void drawStats(GameContainer game, Graphics g) {
        String bottom = "Volley: " + ball.hits + "  Longest: " + longestVolley;
        int w = g.getFont().getWidth(bottom);
        int h = g.getFont().getLineHeight();
        g.getFont().drawString(game.getWidth() / 2 - w / 2, game.getHeight() - h, bottom, Color.black);
    }

    private void drawScore(GameContainer game, Graphics g) {
        String score = score1 + " - " + score2;
        int w = g.getFont().getWidth(score);
        g.getFont().drawString(game.getWidth() / 2 - w / 2, 0, score, Color.black);
    }

    private void drawBackground(GameContainer game, Graphics g) {
        g.setColor(green);
        g.fillRect(0, 0, game.getWidth(), game.getHeight());
    }

    public void update(GameContainer game, int delta) {
        paddle1.update(game, delta);
        paddle2.update(game, delta);
        ball.update(game, delta);

        checkBallOnTable(game);
    }

    private void checkBallOnTable(GameContainer game) {
        if (ball.shape.getMaxX() < 0 || ball.shape.getMinX() > game.getWidth()) {
            if (ball.shape.getMaxX() < 0) {
                score2++;
            } else {
                score1++;
            }
            if (ball.hits > longestVolley) {
                longestVolley = ball.hits;
            }
            ball = factory.createBall(paddle1, paddle2);
        }
    }
}

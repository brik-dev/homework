package java2.lesson1;

import java.awt.*;

public class Background extends GameCanvas {

    Background(MainCircles gameController) {
        super(gameController);
    }

    public static void updateColorCanvas(GameCanvas canvas,float deltaTime) {

        Color color = new Color(
                (int) (Math.random() * 255),
                (int) (Math.random() * 255),
                (int) (Math.random() * 255)

        );
        canvas.setBackground(color);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

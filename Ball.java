import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class Ball extends Canvas {

    private int y = 0;
    private int velocity = 10;
    private Image ballImage;

    public Ball(){
        ballImage = new ImageIcon("tennis-ball.png").getImage();
        setSize(400, 400);
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("Ball");
        Ball drawing = new Ball(); 
        drawing.setSize(400, 400);
        frame.add(drawing);
        frame.pack();
        frame.setVisible(true);

    new Thread(() -> {
        int stopValue = 0;
        while (true) {
            drawing.y += drawing.velocity;

            if (drawing.y >= 300 || drawing.y <= stopValue) {
                drawing.velocity = -drawing.velocity;
                if(stopValue >= 300){
                    break;
                }
            }
            if(drawing.y >= 300){
                stopValue += 50; 
            }

            drawing.repaint();

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {}
    }
        }).start();
    }

    @Override
    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.drawImage(ballImage,175, y, 60, 60, null);

        g.setColor(Color.BLACK);
        g.fillRect(0, 350, 400, 50);
    }
}

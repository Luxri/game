import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Graphics;

public class game extends Canvas {


        int x, y;
        int x1 = 100;
        int y1 = 100;
        double angle = 0;
        Image image;
        Graphics dbg;
        int width = 500;
        int height = 500;

        public game()
        {
            setSize(width, height);
            JFrame frame = new JFrame("Game");
            frame.add(this);
            this.addKeyListener(new KL());
//            frame.addKeyListener(new KL());

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }

        public void paint (Graphics g) {
            if (image == null) { //Create the buffer
                image = createImage(width, height);
                if (image == null) {
                    System.out.println("image is still null!");
                    return;
                } else {
                    dbg = image.getGraphics();
                }
            }


            world(dbg);
            g.drawImage(image, 0, 0, null);
            // Borde inte behövas...
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();

        }

    private void world(Graphics dbg) {
        dbg.setColor(Color.red);
        dbg.fillRect(0, 0, 500, 200);
        dbg.setColor(Color.green);
        dbg.fillRect(0, 300, 500, 200);
        dbg.setColor(Color.blue);
        dbg.fillRect(x1, y1,200,100);

    }

    private class KL implements KeyListener {
        @Override
        public void keyTyped(KeyEvent keyEvent) {

        }

        /**
         * Använd a-s-w-d för att styra cirkelns koordinater
         * @param keyEvent
         */
        @Override
        public void keyPressed(KeyEvent keyEvent) {
            System.out.println("Key pressed: " + keyEvent.getKeyChar());
            if (keyEvent.getKeyChar()=='a') {
                x1-=5;
            } else if (keyEvent.getKeyChar()=='d') {
                x1+=5;
            } else if (keyEvent.getKeyChar()=='w') {
                y1-=5;
            } else if (keyEvent.getKeyChar()=='s') {
                y1+=5;
            }
        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {

        }
    }

    public static void main(String[] args) {
    game g = new game();
        }
}


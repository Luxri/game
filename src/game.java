import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Graphics;

public class game extends Canvas {


        int x, y;
        int x1 = 600;
        int y1 = 600;
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
            frame.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {

                }

                @Override
                public void keyPressed(KeyEvent e) {

                }

                @Override
                public void keyReleased(KeyEvent e) {

                }
            });
            frame.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {

                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
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
        dbg.fillRect(0, 0, 500, 200);
        dbg.fillRect(600, 600, 300, 300);
        dbg.setColor(Color.red);
    }

    public static void main(String[] args) {
    game g = new game();
        }
}


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class game extends Canvas {


        int x, y;
        int x1 = 100;
        int y1 = 100;
        double angle = 0;
        Image image;
        Graphics dbg;
        int width = 500;
        int height = 500;
        private boolean running = false;
        BufferStrategy bs;
        private Thread thread;

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

    public synchronized void start() {
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        double ns = 1000000000.0 / 30.0;
        double delta = 0;
        long lastTime = System.nanoTime();

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while(delta >= 1) {
                // Uppdatera koordinaterna
                update();
                // Rita ut bilden med updaterad data
                render();
                delta--;
            }
        }
        stop();
    }

    /**
     * Eftersom vi inte längre behöver paint och repaint döper jag om metoden till render
     */
    public void render() {
        bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
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

    public static void main(String[] args){
        game g = new game();
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                g.setVisible(true);
            }
        });
        }
}


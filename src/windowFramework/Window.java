package windowFramework;


import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Window {

    static final ScheduledExecutorService repaint = Executors.newScheduledThreadPool(1);

    private static final JFrame frame = new JFrame();
    private static final Container c = frame.getContentPane();

    public static void init() {
        System.out.println("~~~~~   Using WindowFramework   ~~~~~\n\n\n\n\n");

        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.addKeyListener(new KeyHandler());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        c.add(new Draw());

        repaint.scheduleAtFixedRate(re_paint, 0, 1, TimeUnit.MILLISECONDS);
    }

    static final Runnable re_paint = frame::repaint;

    public static void setResolution(int width, int height) {
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
    }

    public static void setBackgroundColor(Color color) {
        frame.setBackground(color);
    }

    public static void addComponent(Component obj) {
        c.add(obj);
        c.add(new Draw());
    }

    public static void setCaption(String caption) {
        frame.setTitle(caption);
    }
}
package window;

import javax.swing.JFrame;
import java.awt.Color;
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Window {

    static ScheduledExecutorService repaint = Executors.newScheduledThreadPool(1);

    private static final JFrame frame = new JFrame();

    public static void init() {
        System.out.println("~~~~~ Using WindowFramework V.0.0.1 ~~~~~\n\n\n\n\n");

        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.add(new Draw());

        repaint.scheduleAtFixedRate(re_paint, 0, 1, TimeUnit.MILLISECONDS);
    }

    static Runnable re_paint = frame::repaint;

    public static void setResolution(int width, int height) {
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
    }

    public static void setBackgroundColor(String color) {
        StackTraceElement[] stackTrace = new Exception().getStackTrace();
        try {
            switch (color) {
                case "BLUE" -> frame.setBackground(Color.BLUE);
                case "BLACK" -> frame.setBackground(Color.BLACK);
                case "GREEN" -> frame.setBackground(Color.GREEN);
                case "ORANGE" -> frame.setBackground(Color.ORANGE);
                case "MAGENTA" -> frame.setBackground(Color.MAGENTA);
                case "LIGHT_GRAY" -> frame.setBackground(Color.LIGHT_GRAY);
                case "DARK_GRAY" -> frame.setBackground(Color.DARK_GRAY);
                case "YELLOW" -> frame.setBackground(Color.YELLOW);
                case "CYAN" -> frame.setBackground(Color.CYAN);
                case "GRAY" -> frame.setBackground(Color.GRAY);
                case "PINK" -> frame.setBackground(Color.PINK);
                case "RED" -> frame.setBackground(Color.RED);
                case "WHITE" -> frame.setBackground(Color.WHITE);
                default -> throw new InvalidParameterException();
            }
        } catch (IllegalArgumentException err) {
            System.err.println(Arrays.toString(new StackTraceElement[]{stackTrace[1]}));
            System.err.println("Error in calling \"Window.setBackgroundColor(String color)\":");
            System.err.println("Color not supported. Supported Colors:");
            System.err.println(" - BLUE");
            System.err.println(" - BLACK");
            System.err.println(" - GREEN");
            System.err.println(" - ORANGE");
            System.err.println(" - MAGENTA");
            System.err.println(" - LIGHT_GRAY");
            System.err.println(" - DARK_GRAY");
            System.err.println(" - YELLOW");
            System.err.println(" - CYAN");
            System.err.println(" - GRAY");
            System.err.println(" - PINK");
            System.err.println(" - RED");
            System.err.println(" - WHITE");
        }
    }

    public static void setCaption(String caption) {
        frame.setTitle(caption);
    }
}

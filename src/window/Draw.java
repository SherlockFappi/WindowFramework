package window;

import javax.swing.*;
import java.awt.*;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;

public class Draw extends JPanel {
    private static final ArrayList<Integer> lineCoords = new ArrayList<>();
    private static final ArrayList<Integer> rectCoords = new ArrayList<>();
    private static final ArrayList<Color> lineColors = new ArrayList<>();
    private static final ArrayList<Color> rectColors = new ArrayList<>();
    private static int lineAmount = 0;
    private static int rectAmount = 0;

    public static void draw_Line(int x1, int y1, int x2, int y2, String color) {
        StackTraceElement[] stackTrace = new Exception().getStackTrace();

        lineCoords.add(lineCoords.size());
        lineCoords.set(lineCoords.size() - 1, x1);

        lineCoords.add(lineCoords.size());
        lineCoords.set(lineCoords.size() - 1, y1);

        lineCoords.add(lineCoords.size());
        lineCoords.set(lineCoords.size() - 1, x2);

        lineCoords.add(lineCoords.size());
        lineCoords.set(lineCoords.size() - 1, y2);
        try {
            switch (color) {
                case "BLUE" -> lineColors.add(lineAmount, Color.BLUE);
                case "BLACK" -> lineColors.add(lineAmount, Color.BLACK);
                case "GREEN" -> lineColors.add(lineAmount, Color.GREEN);
                case "ORANGE" -> lineColors.add(lineAmount, Color.ORANGE);
                case "MAGENTA" -> lineColors.add(lineAmount, Color.MAGENTA);
                case "LIGHT_GRAY" -> lineColors.add(lineAmount, Color.LIGHT_GRAY);
                case "DARK_GRAY" -> lineColors.add(lineAmount, Color.DARK_GRAY);
                case "YELLOW" -> lineColors.add(lineAmount, Color.YELLOW);
                case "CYAN" -> lineColors.add(lineAmount, Color.CYAN);
                case "GRAY" -> lineColors.add(lineAmount, Color.GRAY);
                case "PINK" -> lineColors.add(lineAmount, Color.PINK);
                case "RED" -> lineColors.add(lineAmount, Color.RED);
                case "WHITE" -> lineColors.add(lineAmount, Color.WHITE);
                default -> throw new InvalidParameterException();
            }
        }
        catch(IllegalArgumentException err) {
            System.err.println(Arrays.toString(new StackTraceElement[]{stackTrace[1]}));
            System.err.println("Error in calling \"Draw.draw_Line(String color)\":");
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
            lineColors.add(lineAmount, Color.BLACK);
        }

        lineAmount++;
    }

    public static void draw_Rect(int x, int y, int width, int height, String color) {
        StackTraceElement[] stackTrace = new Exception().getStackTrace();

        rectCoords.add(rectCoords.size());
        rectCoords.set(rectCoords.size() - 1, x);

        rectCoords.add(rectCoords.size());
        rectCoords.set(rectCoords.size() - 1, y);

        rectCoords.add(rectCoords.size());
        rectCoords.set(rectCoords.size() - 1, width);

        rectCoords.add(rectCoords.size());
        rectCoords.set(rectCoords.size() - 1, height);
        try {
            switch (color) {
                case "BLUE" -> rectColors.add(rectAmount, Color.BLUE);
                case "BLACK" -> rectColors.add(rectAmount, Color.BLACK);
                case "GREEN" -> rectColors.add(rectAmount, Color.GREEN);
                case "ORANGE" -> rectColors.add(rectAmount, Color.ORANGE);
                case "MAGENTA" -> rectColors.add(rectAmount, Color.MAGENTA);
                case "LIGHT_GRAY" -> rectColors.add(rectAmount, Color.LIGHT_GRAY);
                case "DARK_GRAY" -> rectColors.add(rectAmount, Color.DARK_GRAY);
                case "YELLOW" -> rectColors.add(rectAmount, Color.YELLOW);
                case "CYAN" -> rectColors.add(rectAmount, Color.CYAN);
                case "GRAY" -> rectColors.add(rectAmount, Color.GRAY);
                case "PINK" -> rectColors.add(rectAmount, Color.PINK);
                case "RED" -> rectColors.add(rectAmount, Color.RED);
                case "WHITE" -> rectColors.add(rectAmount, Color.WHITE);
                default -> throw new InvalidParameterException();
            }
        }
        catch(IllegalArgumentException err) {
            System.err.println(Arrays.toString(new StackTraceElement[]{stackTrace[1]}));
            System.err.println("Error in calling \"Draw.draw_Rect(String color)\":");
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
            rectColors.add(rectAmount, Color.BLACK);
        }

        rectAmount++;
    }

    public void paintComponent(Graphics g) {
        if (lineAmount > 0) {
            for (int i = 0; i < lineAmount * 4; i += 4) {
                g.setColor(lineColors.get(i / 4));
                g.drawLine(lineCoords.get(i), lineCoords.get(i + 1), lineCoords.get(i + 2), lineCoords.get(i + 3));
            }
        }

        if (rectAmount > 0) {
            for (int i = 0; i < rectAmount * 4; i += 4) {
                g.setColor(rectColors.get(i / 4));
                g.fillRect(rectCoords.get(i), rectCoords.get(i + 1), rectCoords.get(i + 2), rectCoords.get(i + 3));
            }
        }
    }
}

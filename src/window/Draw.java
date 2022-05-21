package window;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;

public class Draw extends JPanel {
    private static final ArrayList<Integer> lineCoords = new ArrayList<>();
    private static final ArrayList<Color> lineColors = new ArrayList<>();
    private static int lineAmount = 0;

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

    public void paintComponent(Graphics g) {
        for (int i = 0; i < lineAmount * 4; i += 4) {
            g.setColor(lineColors.get(i / 4));
            g.drawLine(lineCoords.get(i), lineCoords.get(i + 1), lineCoords.get(i + 2), lineCoords.get(i + 3));
        }
    }
}

package window;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Draw extends JPanel {
    private static final ArrayList<Integer> lineCoords = new ArrayList<>();
    private static final ArrayList<Integer> rectCoords = new ArrayList<>();
    private static final ArrayList<Color> lineColors = new ArrayList<>();
    private static final ArrayList<Color> rectColors = new ArrayList<>();
    private static int lineAmount = 0;
    private static int rectAmount = 0;

    public static void draw_Line(int x1, int y1, int x2, int y2, Color color) {
        lineCoords.add(lineCoords.size());
        lineCoords.set(lineCoords.size() - 1, x1);

        lineCoords.add(lineCoords.size());
        lineCoords.set(lineCoords.size() - 1, y1);

        lineCoords.add(lineCoords.size());
        lineCoords.set(lineCoords.size() - 1, x2);

        lineCoords.add(lineCoords.size());
        lineCoords.set(lineCoords.size() - 1, y2);

        lineColors.add(lineAmount, color);

        lineAmount++;
    }

    public static void draw_Rect(int x, int y, int width, int height, Color color) {
        rectCoords.add(rectCoords.size());
        rectCoords.set(rectCoords.size() - 1, x);

        rectCoords.add(rectCoords.size());
        rectCoords.set(rectCoords.size() - 1, y);

        rectCoords.add(rectCoords.size());
        rectCoords.set(rectCoords.size() - 1, width);

        rectCoords.add(rectCoords.size());
        rectCoords.set(rectCoords.size() - 1, height);

        rectColors.add(rectAmount, color);

        rectAmount++;
    }

    public void paintComponent(Graphics g) {
        for (int i = 0; i < lineAmount * 4; i += 4) {
            g.setColor(lineColors.get(i / 4));
            g.drawLine(lineCoords.get(i), lineCoords.get(i + 1), lineCoords.get(i + 2), lineCoords.get(i + 3));
        }

        for (int i = 0; i < rectAmount * 4; i += 4) {
            g.setColor(rectColors.get(i / 4));
            g.fillRect(rectCoords.get(i), rectCoords.get(i + 1), rectCoords.get(i + 2), rectCoords.get(i + 3));
        }
    }
}
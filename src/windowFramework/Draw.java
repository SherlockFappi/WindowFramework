package windowFramework;


import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;

import java.util.ArrayList;


public class Draw extends JPanel {
    private static final ArrayList<Integer> lineCoords = new ArrayList<>();
    private static final ArrayList<Integer> rectCoordsFilled = new ArrayList<>();
    private static final ArrayList<Integer> rectCoordsUnfilled = new ArrayList<>();

    private static final ArrayList<Color> lineColors = new ArrayList<>();
    private static final ArrayList<Color> rectColorsFilled = new ArrayList<>();
    private static final ArrayList<Color> rectColorsUnfilled = new ArrayList<>();

    private static int lineAmount = 0;
    private static int rectAmountFilled = 0;
    private static int rectAmountUnfilled = 0;

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

    public static void draw_Rect_Filled(int x, int y, int width, int height, Color color) {
        rectCoordsFilled.add(rectCoordsFilled.size());
        rectCoordsFilled.set(rectCoordsFilled.size() - 1, x);

        rectCoordsFilled.add(rectCoordsFilled.size());
        rectCoordsFilled.set(rectCoordsFilled.size() - 1, y);

        rectCoordsFilled.add(rectCoordsFilled.size());
        rectCoordsFilled.set(rectCoordsFilled.size() - 1, width);

        rectCoordsFilled.add(rectCoordsFilled.size());
        rectCoordsFilled.set(rectCoordsFilled.size() - 1, height);

        rectColorsFilled.add(rectAmountFilled, color);

        rectAmountFilled++;
    }

    public static void draw_Rect_Unfilled(int x, int y, int width, int height, Color color) {
        rectCoordsUnfilled.add(rectCoordsUnfilled.size());
        rectCoordsUnfilled.set(rectCoordsUnfilled.size() - 1, x);

        rectCoordsUnfilled.add(rectCoordsUnfilled.size());
        rectCoordsUnfilled.set(rectCoordsUnfilled.size() - 1, y);

        rectCoordsUnfilled.add(rectCoordsUnfilled.size());
        rectCoordsUnfilled.set(rectCoordsUnfilled.size() - 1, width);

        rectCoordsUnfilled.add(rectCoordsUnfilled.size());
        rectCoordsUnfilled.set(rectCoordsUnfilled.size() - 1, height);

        rectColorsUnfilled.add(rectAmountUnfilled, color);

        rectAmountUnfilled++;
    }

    public void paintComponent(Graphics g) {
        for (int i = 0; i < lineAmount * 4; i += 4) {
            g.setColor(lineColors.get(i / 4));
            g.drawLine(lineCoords.get(i), lineCoords.get(i + 1), lineCoords.get(i + 2), lineCoords.get(i + 3));
        }

        for (int i = 0; i < rectAmountFilled * 4; i += 4) {
            g.setColor(rectColorsFilled.get(i / 4));
            g.fillRect(rectCoordsFilled.get(i), rectCoordsFilled.get(i + 1), rectCoordsFilled.get(i + 2), rectCoordsFilled.get(i + 3));
        }

        for (int i = 0; i < rectAmountUnfilled * 4; i += 4) {
            g.setColor(rectColorsUnfilled.get(i / 4));
            g.drawRect(rectCoordsUnfilled.get(i), rectCoordsUnfilled.get(i + 1), rectCoordsUnfilled.get(i + 2), rectCoordsUnfilled.get(i + 3));
        }
    }
}
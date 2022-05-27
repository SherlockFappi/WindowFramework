package windowFramework;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    static int closeApp;

    public static void closeApp_Key(int exitKey) {
        closeApp = exitKey;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == closeApp) {
            System.exit(0);
        }
    }
}
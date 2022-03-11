package dev.ruster.game;

import dev.ruster.game.listener.KeyListener;
import dev.ruster.game.listener.MouseListener;

public class Main {

    public static Main instance;

    private final Window window;
    private final MouseListener mouseListener;
    private final KeyListener keyListener;

    private Main() {
        instance = this;

        keyListener = new KeyListener();
        mouseListener = new MouseListener();
        window = new Window();
        window.run();
    }

    public static void main(String[] args) {
        new Main();
    }

    public MouseListener getMouseListener() {
        return mouseListener;
    }

    public Window getWindow() {
        return window;
    }

    public KeyListener getKeyListener() {
        return keyListener;
    }
}

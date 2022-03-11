package dev.ruster.game.listener;

import static org.lwjgl.glfw.GLFW.GLFW_PRESS;
import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;

public class KeyListener {

    public boolean[] keyPressed = new boolean[350];

    public void keyCallback(long window, int key, int scancode, int action, int mods) {
        if(action == GLFW_PRESS) {
            keyPressed[key] = true;
        } else if(action == GLFW_RELEASE) {
            keyPressed[key] = false;
        }
    }

    public boolean isKeyPressed(int keyCode) {
        return keyPressed[keyCode];
    }
}

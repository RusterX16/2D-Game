package dev.ruster.game.listener;

import static org.lwjgl.glfw.GLFW.GLFW_PRESS;
import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;

public class MouseListener {

    private boolean[] mouseBouttonPressed = new boolean[3];
    private double scrollX = 0.0;
    private double scrollY = 0.0;
    private double xPos = 0.0;
    private double yPos = 0.0;
    private double lastX = 0.0;
    private double lastY = 0.0;
    private boolean isDragging = false;

    public void mousePosCallback(long window, double xPos, double yPos) {
        lastX = this.xPos;
        lastY = this.yPos;
        this.xPos = xPos;
        this.yPos = yPos;
        isDragging = mouseBouttonPressed[0] || mouseBouttonPressed[1] || mouseBouttonPressed[2];
    }

    public void mouseButtonCallback(long window, int button, int action, int mods) {
        if(action == GLFW_PRESS) {
            if(button < mouseBouttonPressed.length) {
                mouseBouttonPressed[button] = true;
            }
        } else if(action == GLFW_RELEASE) {
            if(button < mouseBouttonPressed.length) {
                mouseBouttonPressed[button] = false;
                isDragging = false;
            }
        }
    }

    public void mouseScrollCallback(long window, double xOffset, double yOffset) {
        this.scrollX = xOffset;
        this.scrollY = yOffset;
    }

    public void endFrame() {
        scrollX = 0;
        scrollY = 0;
        lastX = xPos;
        lastY = yPos;
    }

    public double getX() {
        return xPos;
    }

    public double getY() {
        return yPos;
    }

    public double getDx() {
        return lastX - xPos;
    }

    public double getDy() {
        return lastY - yPos;
    }

    public double getScrollX() {
        return scrollX;
    }

    public double getScrollY() {
        return scrollY;
    }

    public boolean isDragging() {
        return isDragging;
    }

    public boolean mouseButtonDown(int button) {
        if(button < mouseBouttonPressed.length) {
            return mouseBouttonPressed[button];
        }
        return false;
    }
}

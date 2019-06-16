package com.company;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.util.List;

public class MyRobot {
    private final Robot robot;
    private final List<Character> specialChar = List.of('"','?','!');
    public MyRobot() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    public void write(char[] text, int delay) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (char c : text) {
            if (specialChar.contains(c)) {
                pressSpecialKey(c);
            } else {
                pressKey(c);
            }
            robot.delay(delay);
        }
    }

    private void pressSpecialKey(char c) {
        switch (c) {
            case '"':
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_QUOTE);
                robot.keyRelease(KeyEvent.VK_QUOTE);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                break;
            case '?':
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_SLASH);
                robot.keyRelease(KeyEvent.VK_SLASH);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                break;
            case '!':
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_1);
                robot.keyRelease(KeyEvent.VK_1);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                break;
        }
    }

    private void pressKey(char c) {
        if (Character.isUpperCase(c)) {
            robot.keyPress(KeyEvent.VK_SHIFT);
        }
        int keycode = KeyEvent.getExtendedKeyCodeForChar(c);
        robot.keyPress(keycode);
        robot.keyRelease(keycode);
        robot.keyRelease(KeyEvent.VK_SHIFT);
    }
}


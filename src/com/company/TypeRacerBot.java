package com.company;

public class TypeRacerBot {

    public static final int DELAY = 200;
    MyRobot myRobot = new MyRobot();
    TextReader textReader = new TextReader();

    public void start() {
        start(DELAY);
    }

    public void start(int delay) {

        myRobot.write(textReader.getText(),delay);
    }
}

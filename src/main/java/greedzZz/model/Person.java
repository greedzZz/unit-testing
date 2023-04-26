package greedzZz.model;

import lombok.Getter;

public class Person implements Seeing, Nervous, Stunneable, Smileable {
    @Getter
    private boolean nervous = false;
    @Getter
    private boolean stunned = false;
    @Getter
    private int faithInEyes = 100;
    @Getter
    private boolean droppedJaw = false;
    @Getter
    private int satisfaction = 0;
    @Getter
    private boolean smile = false;


    @Override
    public void nervous() {
        nervous = true;
    }

    @Override
    public void seeStrangeThing(Object o) {
        faithInEyes -= 20;
    }

    @Override
    public void stunned() {
        if (faithInEyes != 100) stunned = true;
    }

    @Override
    public void smile() {
        if (satisfaction == 100) smile = true;
    }

    public void lieDownInAChair() {
        satisfaction += 30;
    }

    public void putFeetOnTheControlPanel() {
        satisfaction += 20;
    }

    public void pickOnesTeeth() {
        satisfaction += 50;
    }

    public void dropJaw() {
        if (faithInEyes == 0) droppedJaw = true;
    }

}

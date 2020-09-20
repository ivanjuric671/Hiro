package me.kagehiro.hiro.clicker;

import me.kagehiro.hiro.core.Core;

import java.awt.event.InputEvent;

public class Clicker implements Runnable {

    public void run() {

        while(true) {
            try {
                Thread.sleep(1L);
                if(Core.getCoreInstance().getToggle()) {

                    if(Core.getCoreInstance().getLeftDown()) {

                        Core.getCoreInstance().getDelayInstance().calculateDelay();
                        int pressDelay = Core.getCoreInstance().getRandomInstance().nextInt((Core.getCoreInstance().getDelayInstance().getMinDelay() - Core.getCoreInstance().getDelayInstance().getMaxDelay()) + 1) + Core.getCoreInstance().getDelayInstance().getMaxDelay();
                        int releaseDelay = Core.getCoreInstance().getRandomInstance().nextInt((Core.getCoreInstance().getDelayInstance().getMinDelay() - Core.getCoreInstance().getDelayInstance().getMaxDelay()) + 1) + Core.getCoreInstance().getDelayInstance().getMaxDelay();
                        Core.getCoreInstance().setPressDelay(pressDelay);
                        Core.getCoreInstance().setReleaseDelay(releaseDelay);

                        if(Core.getCoreInstance().getPressDelay() != 0) {
                            Core.getCoreInstance().setSkipClick(true);
                            Core.getCoreInstance().getRobot().delay(Core.getCoreInstance().getPressDelay());
                            Core.getCoreInstance().getRobot().mousePress(InputEvent.BUTTON1_MASK);
                        }

                        if(Core.getCoreInstance().getReleaseDelay() != 0) {
                            Core.getCoreInstance().getRobot().delay(Core.getCoreInstance().getReleaseDelay());
                            Core.getCoreInstance().getRobot().mouseRelease(InputEvent.BUTTON1_MASK);
                        }
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

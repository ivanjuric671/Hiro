package me.kagehiro.hiro.delay;

import me.kagehiro.hiro.core.Core;

public class Delay {

    private int minDelay;
    private int maxDelay;

    public void calculateDelay() {

        if (Core.getCoreInstance().getMinCps() == 0 || Core.getCoreInstance().getMaxCps() == 0) {
            minDelay = 0;
            maxDelay = 0;
        } else {
            minDelay = (1000 / Core.getCoreInstance().getMinCps()) / 2;
            maxDelay = (1000 / Core.getCoreInstance().getMaxCps()) / 2;
        }

    }
    public int getMinDelay() {
        return this.minDelay;
    }

    public int getMaxDelay() {
        return this.maxDelay;
    }

}

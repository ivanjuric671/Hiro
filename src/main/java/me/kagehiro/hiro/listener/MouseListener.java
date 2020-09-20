package me.kagehiro.hiro.listener;

import lc.kra.system.mouse.event.GlobalMouseEvent;
import lc.kra.system.mouse.event.GlobalMouseListener;
import me.kagehiro.hiro.core.Core;


public class MouseListener implements GlobalMouseListener {

    public void mousePressed(GlobalMouseEvent globalMouseEvent) {
        if(globalMouseEvent.getButton() == 1 && !Core.getCoreInstance().getSkipClick()) {
            Core.getCoreInstance().setLeftDown(true);

        }
    }

    public void mouseReleased(GlobalMouseEvent globalMouseEvent) {
        if(globalMouseEvent.getButton() == 1 && !Core.getCoreInstance().getSkipClick()) {
            Core.getCoreInstance().setLeftDown(false);
        }

        else if(globalMouseEvent.getButton() == 1 && Core.getCoreInstance().getSkipClick()) {
            Core.getCoreInstance().setSkipClick(false);

        }

    }

    public void mouseMoved(GlobalMouseEvent globalMouseEvent) {

    }

    public void mouseWheel(GlobalMouseEvent globalMouseEvent) {

    }
}

package me.kagehiro.hiro.listener;

import lc.kra.system.keyboard.event.GlobalKeyEvent;
import lc.kra.system.keyboard.event.GlobalKeyListener;
import me.kagehiro.hiro.core.Core;

public class KeyboardListener implements GlobalKeyListener {

    public void keyPressed(GlobalKeyEvent globalKeyEvent) {
        if(globalKeyEvent.getVirtualKeyCode() == Core.getCoreInstance().getKeyBind()) {
            boolean toggle = Core.getCoreInstance().getToggle();
            toggle = !toggle;
            Core.getCoreInstance().setToggle(toggle);
        }
        
    }

    public void keyReleased(GlobalKeyEvent globalKeyEvent) {

    }
}

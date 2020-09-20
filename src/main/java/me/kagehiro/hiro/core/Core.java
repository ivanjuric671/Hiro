package me.kagehiro.hiro.core;
import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.mouse.GlobalMouseHook;
import me.kagehiro.hiro.clicker.Clicker;
import me.kagehiro.hiro.delay.Delay;
import me.kagehiro.hiro.listener.KeyboardListener;
import me.kagehiro.hiro.listener.MouseListener;


import java.awt.*;
import java.util.Random;

public class Core {

    private boolean toggle;
    private boolean leftDown;
    private boolean skipClick;

    private int minCps;
    private int maxCps;
    private int pressDelay;
    private int releaseDelay;
    private int keyBind;

    private GlobalMouseHook hook1;
    private GlobalKeyboardHook hook2;

    private Robot robot;
    private Thread thread;
    private Delay delay;
    private Random random;

    private static Core core;

    public Core() {

        toggle = false;
        leftDown = false;
        skipClick = false;
        minCps = 8;
        maxCps = 12;
        pressDelay = 0;
        releaseDelay = 0;
        keyBind = 82;

    }

    public void startProgram() {
        createHooks();
        addListeners();
        createRobot();
        startThread();
    }

    private void createHooks() {
        hook1 = new GlobalMouseHook();
        hook2 = new GlobalKeyboardHook();
    }

    private void addListeners() {
        hook1.addMouseListener(new MouseListener());
        hook2.addKeyListener(new KeyboardListener());
    }

    private void createRobot() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    private void startThread() {
            thread = new Thread(new Clicker());
            thread.start();
    }

    public Delay getDelayInstance() {
        if(delay == null) {
            delay = new Delay();
        }
        return delay;
    }

    public Random getRandomInstance() {
        if(random == null) {
            random = new Random();
        }
        return random;
    }

    public void setToggle(boolean toggle) {
        this.toggle = toggle;
    }

    public boolean getToggle() {
        return toggle;
    }

    public void setLeftDown(boolean leftDown) {
        this.leftDown = leftDown;
    }

    public boolean getLeftDown() {
        return leftDown;
    }

    public void setSkipClick(boolean skipClick) {
        this.skipClick = skipClick;
    }

    public boolean getSkipClick() {
        return skipClick;
    }

    public void setMinCps(int minCps) {
        this.minCps = minCps;
    }

    public int getMinCps() {
        return minCps;
    }

    public void setMaxCps(int maxCps) {
        this.maxCps = maxCps;
    }

    public int getMaxCps() {
        return maxCps;
    }

    public void setPressDelay(int pressDelay) {
        this.pressDelay = pressDelay;
    }

    public int getPressDelay() {
        return pressDelay;
    }

    public void setReleaseDelay(int releaseDelay) {
        this.releaseDelay = releaseDelay;
    }

    public int getReleaseDelay() {
        return releaseDelay;
    }

    public void setKeyBind(int keyBind) {
        this.keyBind = keyBind;
    }

    public int getKeyBind() {
        return keyBind;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    public Robot getRobot() {
        return robot;
    }

    public static Core getCoreInstance() {
        if(Core.core == null) {
            Core.core = new Core();
        }
        return Core.core;
    }

}

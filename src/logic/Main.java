package logic;

import logic.Manager.RenderManager;
import logic.clocking.UpdaterClock;
import logic.state.RenderState;

public class Main {
    public static final int NANO_SECONDS_IN_SECOND = 1000000000;
    public static final int MAX_FPS = 60;


    public static void main(String[] args) {
        UpdaterClock clock = new UpdaterClock();
        RenderState eState = new RenderState();
        RenderManager renderManager = new RenderManager(eState, MAX_FPS);

        Thread renderThread = new Thread(renderManager);
        renderThread.start();
        Thread clockThread = new Thread(clock);
        clockThread.start();
    }
}
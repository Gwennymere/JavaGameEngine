package logic.clocking;

import logic.Main;
import logic.update.fixedUpdate.FixedUpdatable;
import logic.update.fixedUpdate.FixedUpdater;

import java.util.ArrayList;

public class FixedUpdaterClock extends GameClock implements FixedUpdater {
    private static final int DEFAULT_RENDERPROCESSES_PER_SECOND = 60;

    private final ArrayList<FixedUpdatable> fixedUpdatables = new ArrayList<>();

    public FixedUpdaterClock() {
        this(FixedUpdaterClock.DEFAULT_RENDERPROCESSES_PER_SECOND);
    }

    public FixedUpdaterClock(int fixedUpdatesPerSecond) {
        super(Main.NANO_SECONDS_IN_SECOND / fixedUpdatesPerSecond);
    }

    @Override
    protected void clockTick(long lastUpdateTime) {
        updateNow();
    }

    @Override
    public void register(FixedUpdatable updatable) {
        this.fixedUpdatables.add(updatable);
    }

    @Override
    public void deregister(FixedUpdatable updatable) {
        this.fixedUpdatables.remove(updatable);
    }

    @Override
    public void updateNow() {
        fixedUpdatables.forEach(
                FixedUpdatable::update
        );
    }
}

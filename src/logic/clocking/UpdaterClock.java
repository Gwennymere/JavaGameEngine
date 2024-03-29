package logic.clocking;

import logic.update.unfixedUpdate.Updatable;
import logic.update.unfixedUpdate.Updater;

import java.util.ArrayList;

public class UpdaterClock<U extends Updatable> extends GameClock implements Updater<U, Long> {
    private final ArrayList<U> unfixedUpdatables = new ArrayList<>();

    @Override
    protected void clockTick(long lastUpdateTime) {
        this.updateNow(lastUpdateTime);
    }

    @Override
    public void register(U updatable) {
        this.unfixedUpdatables.add(updatable);
    }

    @Override
    public void deregister(U updatable) {
        this.unfixedUpdatables.remove(updatable);
    }

    @Override
    public void updateNow(Long lastUpdateTime) {
        unfixedUpdatables.forEach(
                updatable -> updatable.update(lastUpdateTime)
        );
    }
}

package blackJack.requestObjects;

public class UserInput {
    private boolean wantsToHit;
    private boolean wantsToDoubleDown;
    private boolean wantsToSplit;

    public boolean isWantsToHit() {
        return wantsToHit;
    }

    public void setWantsToHit(boolean wantsToHit) {
        this.wantsToHit = wantsToHit;
    }

    public boolean isWantsToDoubleDown() {
        return wantsToDoubleDown;
    }

    public void setWantsToDoubleDown(boolean wantsToDoubleDown) {
        this.wantsToDoubleDown = wantsToDoubleDown;
    }

    public boolean isWantsToSplit() {
        return wantsToSplit;
    }

    public void setWantsToSplit(boolean wantsToSplit) {
        this.wantsToSplit = wantsToSplit;
    }
}

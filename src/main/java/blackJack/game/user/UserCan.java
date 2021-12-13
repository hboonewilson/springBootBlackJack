package blackJack.game.user;

public class UserCan {

    private boolean canDoubleDown = false;
    private boolean canSplit = false;
    private boolean canHit = false;


    public UserCan() {
    }

    public boolean isCanDoubleDown() {
        return canDoubleDown;
    }

    public void setCanDoubleDown(boolean canDoubleDown) {
        this.canDoubleDown = canDoubleDown;
    }

    public boolean isCanSplit() {
        return canSplit;
    }

    public void setCanSplit(boolean canSplit) {
        this.canSplit = canSplit;
    }

    public boolean isCanHit() {
        return canHit;
    }

    public void setCanHit(boolean canHit) {
        this.canHit = canHit;
    }
}

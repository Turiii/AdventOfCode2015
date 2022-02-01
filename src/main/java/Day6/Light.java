package Day6;

import java.awt.*;

public class Light {
    private int brightness;
    private boolean state = false;

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }


    public Light(Point position) {
    }
}

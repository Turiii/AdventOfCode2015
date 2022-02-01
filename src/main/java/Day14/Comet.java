package Day14;

public class Comet {
    private String name;
    private int speed;
    private int duration;
    private int rest;


    public Comet(String name, int speed, int duration, int rest) {
        this.name = name;
        this.speed = speed;
        this.duration = duration;
        this.rest = rest;
    }
    public int getDistance(int seconds){
        int result = 0;
        while (seconds > 0){
            for (int i = 0; i < duration; i++) {
                result += speed;
                seconds--;
                if(i == duration - 1){
                    seconds -= rest;
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Comet{" +
                "name='" + name + '\'' +
                ", speed=" + speed +
                ", duration=" + duration +
                ", rest=" + rest +
                '}';
    }
}

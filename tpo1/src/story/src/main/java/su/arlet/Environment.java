package su.arlet;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Environment {
    private AtmosphereStatus atmosphereStatus = AtmosphereStatus.USUAL;
    private MoonVisibility moonVisibility = MoonVisibility.VISIBLE;
    private Visibility visibility = Visibility.CLEAR;
    private TimeOfDay timeOfDay = TimeOfDay.DAY;
    private Obstacle[] obstacles;
    private int time = 0;

    public Environment(Obstacle[] obstacles) {
        this.obstacles = obstacles;
    }

    public void timeStep() {
        time += 1;
        time %= 20;

        if (atmosphereStatus == AtmosphereStatus.RAREFIED && moonVisibility == MoonVisibility.INVISIBLE) {
            time += 8;
        }

        setVisibility();
        setTimeOfDay();
    }

    private void setTimeOfDay() {
        if (time >= 10 && timeOfDay == TimeOfDay.DAY) {
            time = 10;
            timeOfDay = TimeOfDay.NIGHT;
            System.out.println("Наступила ночь!");
        } else if (time < 10 && timeOfDay == TimeOfDay.NIGHT) {
            time = 0;
            timeOfDay = TimeOfDay.DAY;
            System.out.println("Наступил день!");
        }
    }

    private void setVisibility() {
        if (0 <= time && time < 10) {
            visibility = Visibility.CLEAR;
            System.out.println("Стало светло!");
        }
        else if (10 <= time && time < 15) {
            visibility = Visibility.POOR;
            System.out.println("Стало темно!");
        }
        else if (15 <= time && time < 20) {
            visibility = Visibility.VERY_POOR;
            System.out.println("Стало очень темно!");
        }
    }
}

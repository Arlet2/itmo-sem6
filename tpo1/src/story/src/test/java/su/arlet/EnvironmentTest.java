package su.arlet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnvironmentTest {

    @Test
    void timeStepFromDay() {
        var env = new Environment(null);
        env.setTime(0);
        var expectedTime = 1;
        var expectedTimeOfDay = TimeOfDay.DAY;
        var expectedVisibility = Visibility.CLEAR;

        env.timeStep();

        assertEquals(expectedTime, env.getTime());
        assertEquals(expectedTimeOfDay, env.getTimeOfDay());
        assertEquals(expectedVisibility, env.getVisibility());
    }

    @Test
    void timeStepFromDayToNight() {
        var env = new Environment(null);
        env.setTime(9);
        var expectedTime = 10;
        var expectedTimeOfDay = TimeOfDay.NIGHT;
        var expectedVisibility = Visibility.POOR;

        env.timeStep();

        assertEquals(expectedTime, env.getTime());
        assertEquals(expectedTimeOfDay, env.getTimeOfDay());
        assertEquals(expectedVisibility, env.getVisibility());
    }

    @Test
    void timeStepFromPoorToVeryPoorVisibility() {
        var env = new Environment(null);
        env.setTime(14);
        env.setTimeOfDay(TimeOfDay.NIGHT);

        var expectedTime = 15;
        var expectedTimeOfDay = TimeOfDay.NIGHT;
        var expectedVisibility = Visibility.VERY_POOR;

        env.timeStep();

        assertEquals(expectedTime, env.getTime());
        assertEquals(expectedTimeOfDay, env.getTimeOfDay());
        assertEquals(expectedVisibility, env.getVisibility());
    }

    @Test
    void timeStepFromNightToDay() {
        var env = new Environment(null);
        env.setTime(19);
        env.setTimeOfDay(TimeOfDay.NIGHT);

        var expectedTime = 0;
        var expectedTimeOfDay = TimeOfDay.DAY;
        var expectedVisibility = Visibility.CLEAR;

        env.timeStep();

        assertEquals(expectedTime, env.getTime());
        assertEquals(expectedTimeOfDay, env.getTimeOfDay());
        assertEquals(expectedVisibility, env.getVisibility());
    }

    @Test
    void timeStepFastChangingToNight() {
        var env = new Environment(null);
        env.setTime(9);
        env.setAtmosphereStatus(AtmosphereStatus.RAREFIED);
        env.setMoonVisibility(MoonVisibility.INVISIBLE);

        var expectedTime = 10;
        var expectedTimeOfDay = TimeOfDay.NIGHT;
        var expectedVisibility = Visibility.VERY_POOR;

        env.timeStep();

        assertEquals(expectedTime, env.getTime());
        assertEquals(expectedTimeOfDay, env.getTimeOfDay());
        assertEquals(expectedVisibility, env.getVisibility());
    }

    @Test
    void timeStepAtmosphereStatusAndMoonVisibilityCost() {
        var env = new Environment(null);
        env.setTime(0);
        env.setAtmosphereStatus(AtmosphereStatus.RAREFIED);
        env.setMoonVisibility(MoonVisibility.INVISIBLE);

        var expectedTime = 8 + 1; // cost + 1
        var expectedTimeOfDay = TimeOfDay.DAY;
        var expectedVisibility = Visibility.CLEAR;

        env.timeStep();

        assertEquals(expectedTime, env.getTime());
        assertEquals(expectedTimeOfDay, env.getTimeOfDay());
        assertEquals(expectedVisibility, env.getVisibility());
    }
}
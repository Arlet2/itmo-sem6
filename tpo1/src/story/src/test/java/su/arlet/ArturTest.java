package su.arlet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArturTest {

    @Test
    void walkWithoutObstaclesWithClearEnv() {
        var env = new Environment(null);
        var artur = new Artur(env);
        var expectedArturCollapsed = false;

        artur.walk();

        assertEquals(expectedArturCollapsed, artur.isCollapsedWithSomebody());
    }

    @Test
    void walkWithoutObstaclesWithVeryPoorVisibility() {
        var env = new Environment(null);
        env.setVisibility(Visibility.VERY_POOR);

        var artur = new Artur(env);
        var expectedArturCollapsed = false;

        artur.walk();

        assertEquals(expectedArturCollapsed, artur.isCollapsedWithSomebody());
    }

    @Test
    void walkWithoutObstaclesWithPoorVisibility() {
        var env = new Environment(null);
        env.setVisibility(Visibility.POOR);

        var artur = new Artur(env);
        var expectedArturCollapsed = false;

        artur.walk();

        assertEquals(expectedArturCollapsed, artur.isCollapsedWithSomebody());
    }

    @Test
    void walkWithVeryPoorVisibility() {
        var oldMan = new OldMan();
        var env = new Environment(new OldMan[]{oldMan});
        env.setVisibility(Visibility.VERY_POOR);

        var artur = new Artur(env);
        var expectedArturCollapsed = true;
        var expectedOldManCollapsed = true;

        artur.walk();

        assertEquals(expectedArturCollapsed, artur.isCollapsedWithSomebody());
        assertEquals(expectedOldManCollapsed, oldMan.isCollapsedWithSomebody());
    }

    @Test
    void walkWithClearVisibility() {
        var oldMan = new OldMan();
        var env = new Environment(new OldMan[]{oldMan});
        env.setVisibility(Visibility.CLEAR);

        var artur = new Artur(env);
        var expectedArturCollapsed = false;
        var expectedOldManCollapsed = false;

        artur.walk();

        assertEquals(expectedArturCollapsed, artur.isCollapsedWithSomebody());
        assertEquals(expectedOldManCollapsed, oldMan.isCollapsedWithSomebody());
    }

    @Test
    void walkWithPoorVisibility() {
        var oldMan = new OldMan();
        var env = new Environment(new OldMan[]{oldMan});
        env.setVisibility(Visibility.POOR);

        var artur = new Artur(env);
        var expectedArturCollapsed = false;
        var expectedOldManCollapsed = false;

        artur.walk();

        assertEquals(expectedArturCollapsed, artur.isCollapsedWithSomebody());
        assertEquals(expectedOldManCollapsed, oldMan.isCollapsedWithSomebody());
    }

    @Test
    void walkWithEmptyObstacles() {
        var env = new Environment(new Obstacle[]{});
        env.setVisibility(Visibility.POOR);

        var artur = new Artur(env);
        var expectedArturCollapsed = false;

        artur.walk();

        assertEquals(expectedArturCollapsed, artur.isCollapsedWithSomebody());
    }
}
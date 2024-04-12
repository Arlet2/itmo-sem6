package su.arlet;

public class Artur extends Obstacle {
    private final Environment environment;

    public Artur(Environment environment) {
        super("Артур");
        this.environment = environment;
    }

    public void walk() {
        var obstacles = environment.getObstacles();

        if (obstacles == null || obstacles.length == 0) {
            System.out.println("Артур спокойно проходит");
            return;
        }

        if (environment.getVisibility() == Visibility.VERY_POOR) {
            for (var obstacle : obstacles) {
                obstacle.setCollapsedWithSomebody(true);
                this.setCollapsedWithSomebody(true);
                System.out.println("Артур сталкивается с " + obstacle.getName() + "!");
            }
        } else {
            System.out.println("Артур удачно обходит все препятствия!");
        }
    }
}

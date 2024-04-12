package su.arlet;

public class Main {
    public static void main(String[] args) {
        OldMan oldMan = new OldMan();
        Environment env = new Environment(new OldMan[]{oldMan});
        Artur artur = new Artur(env);

        env.setTime(8); // вечер
        env.setAtmosphereStatus(AtmosphereStatus.RAREFIED);
        env.setMoonVisibility(MoonVisibility.INVISIBLE);

        env.timeStep();

        artur.walk();
        System.out.println("Глава 22");
    }
}
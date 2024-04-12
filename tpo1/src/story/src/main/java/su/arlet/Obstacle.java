package su.arlet;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Obstacle {
    private String name;
    private boolean collapsedWithSomebody;

    public Obstacle(String name) {
        this.name = name;
    }
}

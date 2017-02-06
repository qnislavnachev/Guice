package guicetasks.core;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class Maggie implements Person {
    private Double distance = 0.0;
    private Double totalSleep = 0.0;
    private final String name = "Maggie";
    private final Integer id;
    @Inject
    public Maggie(@Named("Maggie") Integer id) {
        this.id = id;
        System.out.println("Maggie is up");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void run(Double distance) {
        this.distance += distance;
    }

    @Override
    public void sleep(Double hours) {
        this.totalSleep += hours;
    }

    @Override
    public Double getRunDistance() {
        return distance;
    }

    @Override
    public Double getSleepTime() {
        return totalSleep;
    }
}

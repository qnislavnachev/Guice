package guicetasks.core;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class John implements Person {
    private Double distance = 0.0;
    private Double totalSleep = 0.0;
    private final String name = "John";
    private final Integer id;

    @Inject
    public John(@Named("John") Integer id) {
        this.id = id;
        System.out.println("John is up");
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

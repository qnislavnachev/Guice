package guicetasks.core;

import com.google.inject.Inject;
import guicetasks.core.Car;

public class Person {

    @Inject
    private Car car;

    public Car getCar() {
        return car;
    }
}

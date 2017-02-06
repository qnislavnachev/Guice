package guicetasks.modules;

import com.google.inject.Inject;
import com.google.inject.Provider;
import guicetasks.core.Car;

import java.util.Map;

public class OpelProvider implements Provider<Car> {

    public OpelProvider() {
        System.out.println("Instance was created");
    }

    @Inject
    private Map<Integer, Car> mapBinder;

    @Override
    public Car get() {
        return mapBinder.get(1);
    }
}

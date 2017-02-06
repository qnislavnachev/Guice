package guicetasks.modules;

import com.google.inject.Inject;
import com.google.inject.Provider;
import guicetasks.core.Car;

import java.util.Map;

public class MercedesProvider implements Provider<Car> {

    public MercedesProvider() {
        System.out.println("Instance was created");
    }

    @Inject
    private Map<Integer, Car> mapBinder;

    @Override
    public Car get() {
        return mapBinder.get(2);
    }
}

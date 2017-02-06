package guicetasks.modules;

import com.google.inject.Inject;
import com.google.inject.Provider;
import guicetasks.core.Person;

import java.util.LinkedHashMap;
import java.util.Map;

public class StatisticsProvider implements Provider<Map<String, String>> {
    @Inject
    private Person person;

    @Override
    public Map<String, String> get() {
        return new LinkedHashMap<String, String>() {{
            put("RunDistance", getDistanceResult());
            put("SleepTime", getSleepTimeResult());
        }};
    }

    private String getDistanceResult() {
        return person.getName() + " run Distance is: " + person.getRunDistance();
    }

    private String getSleepTimeResult() {
        return person.getName() + " Sleep Time is: " + person.getSleepTime();
    }
}

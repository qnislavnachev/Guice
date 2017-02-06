package guicetasks;

import guicetasks.core.Person;

public class FakePerson implements Person {
    private final Integer id;
    private final String name;

    public FakePerson(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    }

    @Override
    public void sleep(Double hours) {

    }

    @Override
    public Double getRunDistance() {
        return null;
    }

    @Override
    public Double getSleepTime() {
        return null;
    }
}

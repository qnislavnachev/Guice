package guicetasks.core;

public interface Person {

    String getName();

    Integer getId();

    void run(Double distance);

    void sleep(Double hours);

    Double getRunDistance();

    Double getSleepTime();
}

package guicetasks.core;

import guicetasks.aspects.CheckForOpel;

public class Bmw implements Car {

    @CheckForOpel
    public String getCarName() {
        return "This is a Bmw";
    }
}

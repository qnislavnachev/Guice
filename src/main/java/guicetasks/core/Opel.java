package guicetasks.core;

import guicetasks.aspects.CheckForOpel;

public class Opel implements Car {

    @CheckForOpel
    public String getCarName() {
        return "This is Opel";
    }
}

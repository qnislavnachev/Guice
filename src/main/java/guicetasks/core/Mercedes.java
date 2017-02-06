package guicetasks.core;

import guicetasks.aspects.CheckForOpel;

public class Mercedes implements Car {

    @CheckForOpel
    public String getCarName() {
        return "This is Mercedes";
    }
}

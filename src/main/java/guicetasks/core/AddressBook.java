package guicetasks.core;

import com.google.inject.Inject;
import guicetasks.aspects.Register;

import java.util.LinkedHashMap;
import java.util.Map;

public class AddressBook {
    private Map<String, Person> addressBook = new LinkedHashMap<>();

    @Inject
    private Map<Integer, Person> people;

    @Register
    public void registerUsers() {
        for (Person person : people.values()) {
            addressBook.put(person.getId().toString(), person);
            System.out.println(person.getName() + " was registered successful");
        }
    }
}

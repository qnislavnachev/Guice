package guicetasks.aspects;

import guicetasks.core.AddressBook;
import guicetasks.core.Person;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Field;
import java.util.Set;

public class RegisterInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        AddressBook book = (AddressBook) invocation.getThis();
        Field field = AddressBook.class.getDeclaredField("people");
        field.setAccessible(true);
        Set people = (Set) field.get(book);

        if (people.isEmpty() || containsPersonWithoutId(people)) {
            throw new NullPointerException("Person ID cannot be null");
        }
        System.out.println("Registration was successful !");
        return invocation.proceed();
    }

    private boolean containsPersonWithoutId(Set<Person> people) {
        for (Person person : people) {
            if (person.getId() == null) {
                return true;
            }
        }
        return false;
    }
}

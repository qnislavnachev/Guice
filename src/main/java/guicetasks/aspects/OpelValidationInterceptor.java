package guicetasks.aspects;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class OpelValidationInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        if (invocation.proceed().toString().equals("This is Opel")) {
           return invocation.proceed();
        }
        throw new IllegalStateException("Method does not return opel");
    }
}
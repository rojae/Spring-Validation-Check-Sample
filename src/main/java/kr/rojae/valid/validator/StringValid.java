package kr.rojae.valid.validator;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StringValidator.class)
public @interface StringValid {
    String[] acceptedList();
    String message() default "Invalid Movie Category Type";
    Class[] groups() default {};
    Class[] payload() default {};
    boolean ignoreLetterCase() default false;
}

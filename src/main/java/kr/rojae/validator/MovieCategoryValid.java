package kr.rojae.validator;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MovieCategoryValidator.class)
public @interface MovieCategoryValid {
    String message() default "Invalid Movie Category Type";
    Class[] groups() default {};
    Class[] payload() default {};
}

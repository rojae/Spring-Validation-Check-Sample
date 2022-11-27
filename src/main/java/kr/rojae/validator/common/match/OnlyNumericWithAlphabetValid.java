package kr.rojae.validator.common.match;

import javax.validation.Constraint;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = OnlyNumericWithAlphabetValidator.class)
public @interface OnlyNumericWithAlphabetValid {
    String message() default "Required only digit or alphabet";
    Class[] groups() default {};
    Class[] payload() default {};
}

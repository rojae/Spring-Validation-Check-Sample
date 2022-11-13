package kr.rojae.valid.validator.common.match;

import javax.validation.Constraint;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = OnlyDownerValidator.class)
public @interface OnlyDownerValid {
    String message() default "Required only alphabet downercase";
    Class[] groups() default {};
    Class[] payload() default {};
}

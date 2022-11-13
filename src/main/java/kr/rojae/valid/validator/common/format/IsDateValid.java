package kr.rojae.valid.validator.common.format;

import javax.validation.Constraint;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = IsDateValidator.class)
public @interface IsDateValid {
    String message() default "Required only date Format (yyyy.mm.dd)";
    Class[] groups() default {};
    Class[] payload() default {};
}

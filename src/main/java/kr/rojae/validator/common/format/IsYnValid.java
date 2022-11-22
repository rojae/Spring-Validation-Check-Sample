package kr.rojae.validator.common.format;

import kr.rojae.validator.common.extension.StringValid;

import javax.validation.Constraint;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
@StringValid(acceptedList = {"Y", "N"})
@Constraint(validatedBy = {})
public @interface IsYnValid {
    String message() default "Required only character (Y, N)";
    Class[] groups() default {};
    Class[] payload() default {};
}

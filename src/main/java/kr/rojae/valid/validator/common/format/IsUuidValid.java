package kr.rojae.valid.validator.common.format;

import javax.validation.Constraint;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IsUuidValidator.class)
public @interface IsUuidValid {
    String message() default "Required only UUID Format";
    Class[] groups() default {};
    Class[] payload() default {};
}

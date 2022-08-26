package basetest.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;


@Retention(RetentionPolicy.RUNTIME)
@Target(value = { ElementType.ANNOTATION_TYPE, ElementType.TYPE })
@Constraint(validatedBy = { MarkerValidator.class })
public @interface ValidateMarker {
	String message() default "";
	Class<?>[] groups = new Class<?>[] {};
	Class<?>[] payload = new Class<?>[] {};
}

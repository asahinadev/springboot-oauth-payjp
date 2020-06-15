package com.example.spring.oauth.validator.constraints;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;

import org.hibernate.validator.constraints.Range;

@Documented
@Constraint(validatedBy = {})
@SupportedValidationTarget(ValidationTarget.ANNOTATED_ELEMENT)
@Target({
		METHOD,
		FIELD,
		ANNOTATION_TYPE,
		CONSTRUCTOR,
		PARAMETER,
		TYPE_USE
})
@Retention(RUNTIME)
@Repeatable(Amount.List.class)
@ReportAsSingleViolation
@Range(min = 50, max = 999999)
public @interface Amount {

	@OverridesAttribute(constraint = Range.class, name = "min")
	long min() default 0;

	@OverridesAttribute(constraint = Range.class, name = "max")
	long max() default 999999;

	String message() default "{org.hibernate.validator.constraints.Range.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	/**
	 * Defines several {@code @Range} annotations on the same element.
	 */
	@Target({
			METHOD,
			FIELD,
			ANNOTATION_TYPE,
			CONSTRUCTOR,
			PARAMETER, TYPE_USE
	})
	@Retention(RUNTIME)
	@Documented
	public @interface List {
		Amount[] value();
	}

}

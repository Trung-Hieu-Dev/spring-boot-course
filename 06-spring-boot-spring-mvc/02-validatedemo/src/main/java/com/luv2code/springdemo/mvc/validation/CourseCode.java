package com.luv2code.springdemo.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class) // class that contains business logic
@Target({ElementType.METHOD, ElementType.FIELD}) // where can use this custom annotation
@Retention(RetentionPolicy.RUNTIME) // when run this custom annotation
public @interface CourseCode {
    // define default course code
    public String value() default "LUV";

    // define default error message
    public String message() default "must start with LUV";

    // define default groups
    public Class<?>[] groups() default {}; // can group related constraints

    // define default payloads
    // provide custom details about validation failure (severity level, error code...)
    public Class<? extends Payload>[] payload() default {};
}

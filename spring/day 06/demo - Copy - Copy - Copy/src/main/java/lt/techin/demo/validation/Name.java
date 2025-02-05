package lt.techin.demo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NameValidator.class)
public @interface Name {

  String message() default "FIrstName cannot be null, and must start with uppercase letters, and " +
          "continue with lowecase letters";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}

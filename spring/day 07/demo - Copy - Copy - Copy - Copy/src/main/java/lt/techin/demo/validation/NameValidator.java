package lt.techin.demo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<Name, String> {

  @Override
  public boolean isValid(String firstName, ConstraintValidatorContext constraintValidatorContext) {
    return firstName != null & firstName.matches("^[A-Z][a-z]+$");
  }
}

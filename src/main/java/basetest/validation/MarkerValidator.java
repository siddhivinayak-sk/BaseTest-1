package basetest.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MarkerValidator implements ConstraintValidator<ValidateMarker, Data> {

	@Override
	public boolean isValid(Data value, ConstraintValidatorContext context) {
		if(null != value.getData1()) {
			return true;
		} else {
			return false;
		}
	}

}

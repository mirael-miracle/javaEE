package validation.api;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
public class DoctorValidation {

	@NotNull(message="��� ������ ���� ������")
	  String firstname;

	  @NotNull(message="������� ������ ���� ������")
	  @Size(min = 3, message="����� ������� ������ ���� ������ ����")
	  String lastname;

	  @NotNull(message="Email ������ ���� �����")
	  @Pattern(regexp = "^(?:[a-zA-Z0-9_'^&/+-])+(?:\\.(?:[a-zA-Z0-9_'^&/+-])+)" +
	      "*@(?:(?:\\[?(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?))\\.)" +
	      "{3}(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\]?)|(?:[a-zA-Z0-9-]+\\.)" +
	      "+(?:[a-zA-Z]){2,}\\.?)$",
	      message = "�������� email �� ����� ������������!!!")
	  String email;
	  @Min(value = 18, message = "Age should not be less than 18")
	    @Max(value = 150, message = "Age should not be greater than 150")
	    private int age;
	  @Override
	  public String toString() {
	    return String.format("firstname: [%s], lastname: [%s], email: [%s]",
	        firstname, lastname, email);
	  }

	  public static void validate(Object object, Validator validator) {
	    Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object);
	    
	    System.out.println(object);
	    System.out.println(String.format("���-�� ������: %d",
	        constraintViolations.size()));
	    
	    for (ConstraintViolation<Object> cv : constraintViolations)
	      System.out.println(String.format(
	          "��������, ������! property: [%s], value: [%s], message: [%s]",
	          cv.getPropertyPath(), cv.getInvalidValue(), cv.getMessage()));
	  }

	  public static void main(String[] args) {
	    ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
	    Validator validator = vf.getValidator();

	    DoctorValidation user = new DoctorValidation();
	    validate(user, validator);

	    user.firstname = "����";
	    validate(user, validator);

	    user.lastname = "��";
	    validate(user, validator);
	    
	    user.lastname = "������";
	    validate(user, validator);
	    
	    user.email = "���� ������@example.com";
	    validate(user, validator);

	    user.email = "vasya.poupkine@example.com";
	    validate(user, validator);

	  }
}

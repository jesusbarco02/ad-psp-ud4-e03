package com.salesianostriana.dam.validacion.simple.validadores;

import com.salesianostriana.dam.validacion.simple.anotaciones.StrongPassword;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class StrongPasswordValidator implements ConstraintValidator<StrongPassword, Object> {

    private String minField;
    private String maxField;
    private String hasUpperField;
    private String hasLowerField;
    private String hasNumberField;
    private String hasAlphaField;
    private String hasOthersField;
    private String passwordField;

    @Override
    public void initialize(StrongPassword constraintAnnotation) {

        passwordField = constraintAnnotation.passwordField();


    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        int min = 1;
        int max = 5;
        boolean hasUpper  =true;
        boolean hasLower  =true;
        boolean hasNumber =true;
        boolean hasAlpha   =true;
        boolean hasOthers   = true;
        String password = (String) PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(passwordField);
        Pattern UpperCasePattern = Pattern.compile("[A-Z]");
        Pattern LowerCasePattern = Pattern.compile("[a-z]");
        Pattern NumberCasePattern = Pattern.compile("[1234567890]");
        Pattern AlphaCasePattern = Pattern.compile("[abcdefghijklmnñopqrstuwvxyzABCDEFGHIJKLMNÑOPQRSTUWZYZ]");
        Pattern OthersCasePattern = Pattern.compile("[^a-z0-9]", Pattern.CASE_INSENSITIVE);

        if ((password.length() >= min && password.length() <= max)
                && (hasLower == true && LowerCasePattern.matcher(password).find() || (hasLower == false))
                && (hasUpper == true && UpperCasePattern.matcher(password).find() || (hasUpper == false))
                && (hasNumber == true && NumberCasePattern.matcher(password).find() || (hasNumber == false))
                && (hasAlpha == true && AlphaCasePattern.matcher(password).find() || (hasAlpha == false))
                && (hasOthers == true && OthersCasePattern.matcher(password).find() || (hasOthers == false))

        ){
            return true;
        } else {
            return password == null;
        }
    }

}

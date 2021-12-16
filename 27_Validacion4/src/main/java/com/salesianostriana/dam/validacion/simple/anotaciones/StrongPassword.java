package com.salesianostriana.dam.validacion.simple.anotaciones;

import com.salesianostriana.dam.validacion.simple.validadores.PasswordsMatchValidator;
import com.salesianostriana.dam.validacion.simple.validadores.StrongPasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = StrongPasswordValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface StrongPassword {

    String message() default "La contraseña no cumple con los requisitos de validación especificados";
    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};

    String minField();
    String maxField();
    String hasUpperField();
    String hasLowerField();
    String hasNumberField();
    String hasAlphaField();
    String hasOthersField();
    String passwordField();

}

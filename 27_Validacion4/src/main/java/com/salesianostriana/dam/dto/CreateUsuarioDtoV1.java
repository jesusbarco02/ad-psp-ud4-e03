package com.salesianostriana.dam.dto;

import com.salesianostriana.dam.validacion.multiple.anotaciones.FieldsValueMatch;
import com.salesianostriana.dam.validacion.simple.anotaciones.PasswordsMatch;
import com.salesianostriana.dam.validacion.simple.anotaciones.StrongPassword;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor @AllArgsConstructor
@PasswordsMatch(passwordField = "password", verifyPasswordField = "verifyPassword", message = "{usuario.password.notmatch}")
@StrongPassword(passwordField = "password", minField = "1", maxField = "5", hasLowerField = "false",
hasUpperField = "false", hasAlphaField = "false", hasNumberField = "false", hasOthersField = "false")
public class CreateUsuarioDtoV1 {

    private String login;
    @Email
    private String email;
    @NotEmpty
    private String password;
    private String verifyPassword;

}

package com.example.authsystem.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRegistrationDto {

    @NotBlank(message = "Ho ten khong duoc de trong.")
    private String fullName;

    @NotBlank(message = "Email khong duoc de trong.")
    @Email(message = "Email khong hop le.")
    private String email;

    @NotBlank(message = "Mat khau khong duoc de trong.")
    @Size(min = 6, message = "Mat khau phai co it nhat 6 ky tu.")
    private String password;

    @NotBlank(message = "Vui long nhap lai mat khau.")
    private String confirmPassword;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}

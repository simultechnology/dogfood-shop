package com.example.dogfoodshop.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AdminRegistrationForm {
    @NotBlank(message = "メールアドレスを入力してください")
    @Email(message = "正しいメールアドレスを入力してください")
    private String email;

    @NotBlank(message = "パスワードを入力してください")
    private String password;

    @NotBlank(message = "名を入力してください")
    private String firstName;

    @NotBlank(message = "姓を入力してください")
    private String lastName;
}
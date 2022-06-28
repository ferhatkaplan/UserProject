package com.ecodation.userproject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

//lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserDto {

    private Long userId;

    @NotEmpty(message = "Adı boş geçilemez")
    private String userName;

    @NotEmpty(message = "Soyadı boş geçilemez")
    private String userSurname;

    @NotEmpty(message = "email boş geçilemez")
    private String userEmail;

    @NotEmpty(message = "password boş geçilemez")
    private String userPassword;

    private Date createdDate;
}


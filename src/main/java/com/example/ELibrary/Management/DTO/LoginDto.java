package com.example.ELibrary.Management.DTO;

import lombok.Data;

@Data
public class LoginDto {
    private String userName;
    private String password;
    private String role;
}

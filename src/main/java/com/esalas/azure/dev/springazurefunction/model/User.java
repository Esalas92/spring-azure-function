package com.esalas.azure.dev.springazurefunction.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String login;
    private long id;
    private String url;
    private String company;
    private String blog;
    private String email;
}
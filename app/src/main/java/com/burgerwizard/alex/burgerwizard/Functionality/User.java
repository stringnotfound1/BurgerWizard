package com.burgerwizard.alex.burgerwizard.Functionality;

import java.io.Serializable;

import lombok.Data;

/**
 * Created by Alex on 17.04.2018.
 */

@Data
public class User implements Serializable{

    private String name;
    private String address;
    private String ccn;
    private String telephoneNumber;

    public User(String name, String address, String ccn, String telephoneNumber) {
        this.name = name;
        this.address = address;
        this.ccn = ccn;
        this.telephoneNumber = telephoneNumber;
    }
}

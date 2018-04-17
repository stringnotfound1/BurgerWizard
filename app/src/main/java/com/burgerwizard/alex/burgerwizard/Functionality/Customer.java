package com.burgerwizard.alex.burgerwizard.Functionality;

import lombok.Data;

/**
 * Created by Alex on 17.04.2018.
 */

@Data
public class Customer {

    private String name;
    private String address;
    private int ccn;
    private int telephoneNumber;

    public Customer(String name, String address, int ccn, int telephoneNumber) {
        this.name = name;
        this.address = address;
        this.ccn = ccn;
        this.telephoneNumber = telephoneNumber;
    }
}

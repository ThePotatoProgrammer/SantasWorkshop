package com.santasworkshop.elfmanager.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.UUID;

@Data
public class Elf {
    @JsonIgnore
    private UUID elfId = UUID.randomUUID();

    private String firstName;
    private String lastName;
    private int yearsOfExperience;
    private int payRate;
    private Position position;
    private Factory factory;
}

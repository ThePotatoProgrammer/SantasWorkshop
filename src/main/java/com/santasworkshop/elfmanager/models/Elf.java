package com.santasworkshop.elfmanager.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Elf {
    private String name;
    private Position position;
    private Factory factory;
}

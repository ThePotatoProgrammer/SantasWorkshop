package com.santasworkshop.elfmanager.exception;

public class ElfNotFoundException extends RuntimeException {
    public ElfNotFoundException(String id) {
        super("Could not find an elf with the id: " + id);
    }
}

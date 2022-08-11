package com.santasworkshop.elfmanager.controllers;

import com.santasworkshop.elfmanager.models.Elf;
import com.santasworkshop.elfmanager.persistence.ElfRepo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ElfController {

    private final ElfRepo elfRepo;

    public ElfController(ElfRepo elfRepo) {
        this.elfRepo = elfRepo;
    }

    @PostMapping("/addElf")
    Elf addElf(@RequestBody Elf elf) {
        elfRepo.insert(elf);
        return null;
    }
}

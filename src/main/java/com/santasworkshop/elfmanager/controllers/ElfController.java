package com.santasworkshop.elfmanager.controllers;

import com.santasworkshop.elfmanager.exception.ElfNotFoundException;
import com.santasworkshop.elfmanager.models.Elf;
import com.santasworkshop.elfmanager.persistence.ElfRepo;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ElfController {

    private final ElfRepo elfRepo;

    private final MongoOperations mongoOps;

    public ElfController(ElfRepo elfRepo, MongoOperations mongoOps) {
        this.elfRepo = elfRepo;
        this.mongoOps = mongoOps;
    }

    @GetMapping("/elves")
    List<Elf> getElves() {
        return mongoOps.findAll(Elf.class);
    }

    @PostMapping("/elves")
    Elf addElf(@RequestBody Elf elf) {
        return mongoOps.insert(elf);
    }

    @GetMapping("/elves/{id}")
    Elf getElf(@PathVariable String id) {
        Elf result = mongoOps.findById(id, Elf.class);
        if (result != null) {
            return result;
        } else {
            throw new ElfNotFoundException(id);
        }
//        return elfRepo.findById(id).orElseThrow(() ->
//            new ElfNotFoundException(id)
//        );
    }

    @PutMapping("/elves/{id}")
    Elf replaceElf(@RequestBody Elf newElf, @PathVariable String id) {
        return elfRepo.findById(id)
            .map( elf -> {
                elf.setPosition(newElf.getPosition());
                elf.setFactory(newElf.getFactory());
                elf.setName(newElf.getName());
                return elfRepo.save(elf);
            }).orElseGet( () -> {
                return elfRepo.insert(newElf);
            });
    }

    @DeleteMapping("/elves/{id}")
    void deleteElf(@PathVariable String id) {
        elfRepo.deleteById(id);
    }
}

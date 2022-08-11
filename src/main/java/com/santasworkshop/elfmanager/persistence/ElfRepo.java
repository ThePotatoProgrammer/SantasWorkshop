package com.santasworkshop.elfmanager.persistence;

import com.santasworkshop.elfmanager.models.Elf;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ElfRepo extends MongoRepository<Elf, UUID> {
}

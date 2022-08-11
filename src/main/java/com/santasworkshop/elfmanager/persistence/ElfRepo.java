package com.santasworkshop.elfmanager.persistence;

import com.santasworkshop.elfmanager.models.Elf;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ElfRepo extends MongoRepository<Elf, String> {
}

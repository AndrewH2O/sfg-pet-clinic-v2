package guru.springframework.sfgpetclinicv2.services;

import guru.springframework.sfgpetclinicv2.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findByid(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}

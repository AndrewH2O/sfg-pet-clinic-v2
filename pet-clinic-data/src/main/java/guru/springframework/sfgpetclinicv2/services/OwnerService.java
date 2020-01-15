package guru.springframework.sfgpetclinicv2.services;

import guru.springframework.sfgpetclinicv2.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByLastName(String lastName);

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();

}

package guru.springframework.sfgpetclinicv2.repositories;

import guru.springframework.sfgpetclinicv2.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepsoitory extends CrudRepository<Pet, Long> {
}

package guru.springframework.sfgpetclinicv2.repositories;

import guru.springframework.sfgpetclinicv2.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}

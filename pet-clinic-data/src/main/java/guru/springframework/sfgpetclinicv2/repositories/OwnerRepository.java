package guru.springframework.sfgpetclinicv2.repositories;

import guru.springframework.sfgpetclinicv2.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}

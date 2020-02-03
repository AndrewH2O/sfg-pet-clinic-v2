package guru.springframework.sfgpetclinicv2.repositories;

import guru.springframework.sfgpetclinicv2.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}

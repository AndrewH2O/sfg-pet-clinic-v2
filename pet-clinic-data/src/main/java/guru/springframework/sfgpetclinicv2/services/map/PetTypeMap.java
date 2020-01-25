package guru.springframework.sfgpetclinicv2.services.map;

import guru.springframework.sfgpetclinicv2.model.PetType;
import guru.springframework.sfgpetclinicv2.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeMap extends AbstractMapService<PetType, Long> implements PetTypeService {
}

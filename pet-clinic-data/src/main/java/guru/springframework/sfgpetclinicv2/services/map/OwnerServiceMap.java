package guru.springframework.sfgpetclinicv2.services.map;

import guru.springframework.sfgpetclinicv2.model.Owner;
import guru.springframework.sfgpetclinicv2.services.OwnerService;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Owner findByLastName(String lastName) {
        return super.findAll()
                .stream()
                .filter(o -> o.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
    }
}

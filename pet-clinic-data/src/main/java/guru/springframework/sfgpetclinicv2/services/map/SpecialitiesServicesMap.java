package guru.springframework.sfgpetclinicv2.services.map;

import guru.springframework.sfgpetclinicv2.model.Speciality;
import guru.springframework.sfgpetclinicv2.services.SpecialitiesService;
import org.springframework.stereotype.Service;

@Service
public class SpecialitiesServicesMap extends AbstractMapService<Speciality, Long> implements SpecialitiesService {
}

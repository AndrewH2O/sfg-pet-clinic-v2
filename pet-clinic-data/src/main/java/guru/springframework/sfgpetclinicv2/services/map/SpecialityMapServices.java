package guru.springframework.sfgpetclinicv2.services.map;

import guru.springframework.sfgpetclinicv2.model.Speciality;
import guru.springframework.sfgpetclinicv2.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class SpecialityMapServices extends AbstractMapService<Speciality, Long> implements SpecialityService {

}

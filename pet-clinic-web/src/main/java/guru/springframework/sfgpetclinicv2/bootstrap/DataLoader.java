package guru.springframework.sfgpetclinicv2.bootstrap;

import guru.springframework.sfgpetclinicv2.model.Owner;
import guru.springframework.sfgpetclinicv2.model.Pet;
import guru.springframework.sfgpetclinicv2.model.PetType;
import guru.springframework.sfgpetclinicv2.model.Vet;
import guru.springframework.sfgpetclinicv2.services.OwnerService;
import guru.springframework.sfgpetclinicv2.services.PetTypeService;
import guru.springframework.sfgpetclinicv2.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("123123234");
        ownerService.save(owner1);

        Pet mikesPet = new Pet();
        mikesPet.setName("Rosco");
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setBirthDate(LocalDate.of(2019,2,12));
        mikesPet.setOwner(owner1);
        owner1.getPets().add(mikesPet);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("123123234");
        ownerService.save(owner2);

        Pet fionasPet = new Pet();
        fionasPet.setName("Cat");
        fionasPet.setPetType(savedCatPetType);
        fionasPet.setBirthDate(LocalDate.of(2018,11,21));
        fionasPet.setOwner(owner2);
        owner2.getPets().add(fionasPet);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}

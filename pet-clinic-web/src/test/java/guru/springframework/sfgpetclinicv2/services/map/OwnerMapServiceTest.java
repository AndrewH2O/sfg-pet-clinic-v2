package guru.springframework.sfgpetclinicv2.services.map;

import guru.springframework.sfgpetclinicv2.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * author: Andrew W
 */
class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    final Long ownerId = 1L;
    final String lastName = "Jones";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());

//        Owner owner = new Owner();
//        owner.setId(1L);
//        owner.setLastName(lastName);
        //ownerMapService.save(owner);
        ownerMapService.save(Owner.builder()
                .id(ownerId)
                .lastName(lastName)
                .build());

    }

    @Test
    void testFindAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void testFindById() {
        Owner owner = ownerMapService.findById(ownerId);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void testDelete() {
        // delete by object
        ownerMapService.delete(ownerMapService.findById(ownerId));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void testDeleteById() {
        ownerMapService.deleteById(ownerId);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner jones = ownerMapService.findByLastName(lastName);
        assertNotNull(jones);
        assertEquals(ownerId, jones.getId());
    }

    @Test
    void findByLastNameNotFound() {
        Owner jones = ownerMapService.findByLastName("no name");
        assertNull(jones);
    }

    @Test
    void testSaveExistingId() {
        Long id = 2L;
        Owner owner2 = Owner.builder().id(id).build();
        Owner savedOwner = ownerMapService.save(owner2);
        assertEquals(id, savedOwner.getId());
    }

    @Test
    void testSaveNoId() {
        // we don't supply an id test auto-generate
        Owner owner2 = Owner.builder().build();
        Owner savedOwner = ownerMapService.save(owner2);
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }
}
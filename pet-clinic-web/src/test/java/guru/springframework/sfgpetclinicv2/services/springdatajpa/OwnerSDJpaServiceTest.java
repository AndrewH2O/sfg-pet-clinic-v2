package guru.springframework.sfgpetclinicv2.services.springdatajpa;

import guru.springframework.sfgpetclinicv2.model.Owner;
import guru.springframework.sfgpetclinicv2.repositories.OwnerRepository;
import guru.springframework.sfgpetclinicv2.repositories.PetRepository;
import guru.springframework.sfgpetclinicv2.repositories.PetTypeRepository;
import guru.springframework.sfgpetclinicv2.services.map.AbstractMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest extends AbstractMapService {

    public static final String LAST_NAME = "Jones";
    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService service;

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
        Owner jones = service.findByLastName(LAST_NAME);
        assertEquals("Jones",jones.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void testFindAll() {
        Set<Owner> returnOwnersSet = new HashSet<>();
        returnOwnersSet.add(Owner.builder().id(1L).build());
        returnOwnersSet.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(returnOwnersSet);

        Set<Owner> owners = service.findAll(); // invoke mock here

        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void testFindById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
        Owner owner = service.findById(1L);
        assertNotNull(owner);
    }

    @Test
    void testFindByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner owner = service.findById(1L);
        assertNull(owner);
    }

    @Test
    void testSave() {
        Owner ownerToSave = Owner.builder().id(1L).build();
        when(ownerRepository.save(any())).thenReturn(returnOwner);
        Owner savedOwner = service.save(ownerToSave);
        assertNotNull(savedOwner);
        verify(ownerRepository).save(any());
    }

    @Test
    void testDelete() {
        service.delete(returnOwner);
        verify(ownerRepository).delete(any());
    }

    @Test
    void testDeleteById() {
        service.deleteById(1L);
        verify(ownerRepository).deleteById(anyLong());
    }
}
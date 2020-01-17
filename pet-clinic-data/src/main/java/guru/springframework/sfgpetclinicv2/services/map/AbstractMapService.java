package guru.springframework.sfgpetclinicv2.services.map;

import guru.springframework.sfgpetclinicv2.model.BaseEntity;
import guru.springframework.sfgpetclinicv2.services.CrudService;

import java.util.*;


public class AbstractMapService<T extends BaseEntity, ID extends Long> implements CrudService<T, Long> {
    protected Map<Long, T> map = new HashMap<>();

    @Override
    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    @Override
    public T findById(Long id) {
        return map.get(id);
    }

    @Override
    public T save(T object) {
        if(object != null) {
            if(object.getId() == null){
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("Object cannot be null");
        }

        return object;
    }

    @Override
    public void delete(T object) {
        map.entrySet().removeIf(e -> e.getValue().equals(object));
    }

    @Override
    public void deleteById(Long id) {
        map.remove(id);
    }

    private Long getNextId(){

        Long nextId;
        if(map.isEmpty()){
            nextId = 1L;
        }else{
            nextId = Collections.max(map.keySet()) + 1;
        }

        return nextId;
    }
}

package com.project.service;

import com.project.dao.TypeRepository;
import com.project.model.Type;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TypeService {

    private final TypeRepository typeRepository;

    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public List<Type> findAll() {
        List<Type> types = new ArrayList<>();
        for (Type type : typeRepository.findAll()) {
            types.add(type);
        }
        return types;
    }
    
    public Type findType(int id) {
        return typeRepository.findOne(id);
    }
    
    public void save(Type type) {
        typeRepository.save(type);
    }
}

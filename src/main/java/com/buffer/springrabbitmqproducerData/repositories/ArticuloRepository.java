package com.buffer.springrabbitmqproducerData.repositories;

import com.buffer.springrabbitmqproducerData.models.Articulo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticuloRepository extends MongoRepository<Articulo, String> {
    public List<Articulo> findAll();

    public void deleteById(String id);

    public Optional<Articulo> findById(String id);


}

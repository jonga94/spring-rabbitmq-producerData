package com.buffer.springrabbitmqproducerData.service;

import com.buffer.springrabbitmqproducerData.models.Articulo;
import com.buffer.springrabbitmqproducerData.repositories.ArticuloRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticuloServiceImpl {

    @Autowired
    public ArticuloRepository articuloRepository;


    public List<Articulo> findAll() {
        return articuloRepository.findAll();
    }

    public void save(Articulo articulo) {
        articuloRepository.save(articulo);
    }

    public void deleteById(String id) {
        articuloRepository.deleteById(id);
    }


    public void update(Articulo articulo) {

        Optional<Articulo> oar = articuloRepository.findById(articulo.getId());
        if (oar.isPresent()){
            Articulo a = oar.get();
            a.setNombre(articulo.getNombre());
            a.setUnidad(articulo.getUnidad());
            a.setClave(articulo.getClave());
            a.setPrecio(articulo.getPrecio());
            articuloRepository.save(a);
        }

       /* Articulo a = articuloRepository.findBy(articulo.getId());
        a.setNombre(articulo.getNombre());
        a.setUnidad(articulo.getUnidad());
        a.setClave(articulo.getClave());
        a.setPrecio(articulo.getPrecio());
        articuloRepository.save(a);*/
    }

}

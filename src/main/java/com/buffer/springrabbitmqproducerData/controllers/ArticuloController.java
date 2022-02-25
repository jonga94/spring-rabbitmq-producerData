package com.buffer.springrabbitmqproducerData.controllers;

import com.buffer.springrabbitmqproducerData.MQConfig;
import com.buffer.springrabbitmqproducerData.models.Articulo;
import com.buffer.springrabbitmqproducerData.service.ArticuloServiceImpl;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ArticuloController {

    @Autowired
    private ArticuloServiceImpl articuloServiceImpl;

    @Autowired
    private RabbitTemplate template;

    @GetMapping("/lista")
    public List<Articulo> findAll(){
        return articuloServiceImpl.findAll();
    }

    @PostMapping("/add")
    public Articulo add(@RequestBody Articulo articulo) {
        articuloServiceImpl.save(articulo);
        template.convertAndSend(MQConfig.EXCHANGE,MQConfig.ROUTING_KEY, articulo);
        return articulo;
    }

    @DeleteMapping("/delete")
    public Articulo delete(@RequestBody Articulo articulo) {
        articuloServiceImpl.deleteById(articulo.getId());
        template.convertAndSend(MQConfig.EXCHANGE,MQConfig.ROUTING_KEY, articulo);
        return articulo;
    }

    @PutMapping("/update")
    public Articulo update(@RequestBody Articulo articulo) {
        articuloServiceImpl.update(articulo);
        template.convertAndSend(MQConfig.EXCHANGE,MQConfig.ROUTING_KEY, articulo);
        return articulo;
    }

}

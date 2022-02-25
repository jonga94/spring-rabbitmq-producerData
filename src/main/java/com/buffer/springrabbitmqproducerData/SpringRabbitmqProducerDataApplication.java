package com.buffer.springrabbitmqproducerData;

import com.buffer.springrabbitmqproducerData.models.Articulo;
import com.buffer.springrabbitmqproducerData.repositories.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRabbitmqProducerDataApplication  implements CommandLineRunner {

	@Autowired
	private ArticuloRepository articuloRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringRabbitmqProducerDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if(articuloRepository.findAll().isEmpty()) {
			//articuloRepository.save(new Articulo("silla","Pieza","001","1.5"));
			//articuloRepository.save(new Articulo("mesa","Pieza","002","3.5"));
		}

		for (Articulo articulo: articuloRepository.findAll()) {
			System.out.println(articulo);
		}
	}
}

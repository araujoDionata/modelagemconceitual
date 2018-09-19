package com.dionata.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dionata.cursomc.domain.Category;
import com.dionata.cursomc.domain.City;
import com.dionata.cursomc.domain.Product;
import com.dionata.cursomc.domain.State;
import com.dionata.cursomc.repositories.CategoryRepository;
import com.dionata.cursomc.repositories.CityRepository;
import com.dionata.cursomc.repositories.ProductRepository;
import com.dionata.cursomc.repositories.StateRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private StateRepository stateRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Escritório");

		Product p1 = new Product(null, "Computador", 1200.0);
		Product p2 = new Product(null, "Impressora", 1200.0);
		Product p3 = new Product(null, "Mouse", 80.0);

		cat1.getProduct().addAll(Arrays.asList(p1, p2, p3));
		cat1.getProduct().addAll(Arrays.asList(p2));

		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));

		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));

		State sta1 = new State(null, "Minas Gerais");
		State sta2 = new State(null, "São Paulo");

		City cit1 = new City(null, "Uberlandia", sta1);
		City cit2 = new City(null, "São Paulo", sta2);
		City cit3 = new City(null, "Campinas", sta2);

		sta1.getCities().addAll(Arrays.asList(cit1));
		sta2.getCities().addAll(Arrays.asList(cit2, cit3));

		stateRepository.saveAll(Arrays.asList(sta1, sta2));
		cityRepository.saveAll(Arrays.asList(cit1, cit2, cit3));
	}
}

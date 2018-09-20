package com.dionata.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dionata.cursomc.domain.Address;
import com.dionata.cursomc.domain.Category;
import com.dionata.cursomc.domain.City;
import com.dionata.cursomc.domain.Client;
import com.dionata.cursomc.domain.Payment;
import com.dionata.cursomc.domain.PaymentSlip;
import com.dionata.cursomc.domain.PaymentWithCard;
import com.dionata.cursomc.domain.Product;
import com.dionata.cursomc.domain.PurchaseOrder;
import com.dionata.cursomc.domain.State;
import com.dionata.cursomc.domain.enums.ClientType;
import com.dionata.cursomc.domain.enums.StatusPayment;
import com.dionata.cursomc.repositories.AddressRepository;
import com.dionata.cursomc.repositories.CategoryRepository;
import com.dionata.cursomc.repositories.CityRepository;
import com.dionata.cursomc.repositories.ClientRepository;
import com.dionata.cursomc.repositories.PaymentRepository;
import com.dionata.cursomc.repositories.ProductRepository;
import com.dionata.cursomc.repositories.PurchaseOrderRepository;
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
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;

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

		Client cli1 = new Client(null, "Maria Silva", "maria@gmail.com", "12345678900", ClientType.PESSOAFISICA);
		cli1.getPhones().addAll(Arrays.asList("6232844915", "3484156124"));

		Address a1 = new Address(null, "Edson Luiz", "34-A", "Frente", "Alvorada", "74120030", cli1, cit1);
		Address a2 = new Address(null, "11", "20", "Apt 201", "Setor Oeste", "38435000", cli1, cit2);

		cli1.getAddresses().addAll(Arrays.asList(a1, a2));

		clientRepository.saveAll(Arrays.asList(cli1));
		addressRepository.saveAll(Arrays.asList(a1, a2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		PurchaseOrder order1 = new PurchaseOrder(null, sdf.parse("30/09/2017 10:32"), cli1, a1);
		PurchaseOrder order2 = new PurchaseOrder(null, sdf.parse("10/10/2017 19:35"), cli1, a2);

		Payment pay1 = new PaymentWithCard(null, StatusPayment.PAID, order1, 6);
		order1.setPayment(pay1);
		Payment pay2 = new PaymentSlip(null, StatusPayment.PENDING, order2, sdf.parse("20/10/2017 00:00"), null);
		order2.setPayment(pay2);

		cli1.getOrders().addAll(Arrays.asList(order1, order2));

		purchaseOrderRepository.saveAll(Arrays.asList(order1, order2));
		paymentRepository.saveAll(Arrays.asList(pay1, pay2));

	}
}

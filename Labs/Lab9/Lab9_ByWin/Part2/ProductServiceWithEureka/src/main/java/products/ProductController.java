package products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.function.Function;

@RestController
public class ProductController {
	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/product/{productNumber}")
	@HystrixCommand(fallbackMethod = "getStockFallback")
	public Product getProduct(@PathVariable("productNumber") String productNumber) {
		int availableQuantity = restTemplate.getForObject("http://localhost:8900/stock/"+productNumber,
				int.class);

		return new Product("1", "1000.00", availableQuantity);
	}

	public int getStockFallback() {
		return 0;
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}

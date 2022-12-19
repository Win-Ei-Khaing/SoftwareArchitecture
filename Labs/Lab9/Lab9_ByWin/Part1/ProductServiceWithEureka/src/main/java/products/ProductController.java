package products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.openfeign.FeignClient;

@RestController
public class ProductController {
	@Autowired
	StockFeignClient stockFeignClient;

	@RequestMapping("/product/{productNumber}")
	public Product getProduct(@PathVariable("productNumber") String productNumber) {
		int availableQuantity = stockFeignClient.getAvailableQuantity(productNumber);
		return new Product("1", "1000.00", availableQuantity);
	}

	@FeignClient(name = "StockService")
	interface StockFeignClient {
		@RequestMapping("/stock/{productNumber}")
		public int getAvailableQuantity(@PathVariable("productNumber") String productNumber);
	}
}

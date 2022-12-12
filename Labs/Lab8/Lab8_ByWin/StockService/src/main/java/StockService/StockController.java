package StockService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {
	@RequestMapping("/stock/{productNumber}")
	public int getAvailableQuantity(@PathVariable("productNumber") String productNumber) {
		return 10;
	}
}

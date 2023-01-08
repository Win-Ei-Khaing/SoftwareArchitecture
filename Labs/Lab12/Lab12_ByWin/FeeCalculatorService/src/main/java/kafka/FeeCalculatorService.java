package kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Console;

@Component
public class FeeCalculatorService {
	public void handleRecord(OwnerRecord ownerRecord) {
		int fee = 0;
		if(ownerRecord.speed < 77)
			fee=25;
		else if (ownerRecord.speed<82)
			fee=45;
		else if (ownerRecord.speed<90)
			fee=80;
		else
			fee=125;

		System.out.println(ownerRecord.toString() + ":fee - "+fee);

	}

}

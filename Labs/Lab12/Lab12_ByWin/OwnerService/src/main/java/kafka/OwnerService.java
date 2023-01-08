package kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OwnerService {
	@Autowired
	Sender sender;
	int count = 0;
	public void handleRecord(SpeedRecord speedRecord) {
		count++;
		Owner owner = new Owner("Win_"+count, "Bergenfield, New Jersey_"+count);
		sender.send(new OwnerRecord(owner.getName(), owner.getAddress(),speedRecord.getLicencePlate(), speedRecord.getSpeed()));
	}

}

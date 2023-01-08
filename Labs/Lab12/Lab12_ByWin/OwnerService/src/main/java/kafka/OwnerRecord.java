package kafka;

//this is to send to Kafka
public class OwnerRecord {
    public String name;
    public String address;
    public String licencePlate;
    public int speed;

    public OwnerRecord() {
    }

    public OwnerRecord(String name, String address, String licencePlate, int speed) {
        this.name = name;
        this.address = address;
        this.licencePlate = licencePlate;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String toString(){
        return "licencePlate - "+licencePlate + ": owner's name - "+name+": owner's address - " +address+": speed - "+speed;
    }
}

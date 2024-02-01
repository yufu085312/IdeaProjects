public class Address {
    private String name;
    private String phoneNumber;

    public Address(String name, String num){
        this.name = name;
        phoneNumber = num;
    }

    public void setName(String name) { this.name = name;}
    public void setNum(String num) { phoneNumber = num; }
    public String getName() {
        return name;
    }
    public String getNum() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return name + ":" + phoneNumber;
    }
}
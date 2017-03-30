public class Store{

  private String phone_number;
  private String location;
  private int id;

  public Store(String phone_number, String location){
    this.phone_number = phone_number;
    this.location = location;
  }

  public String getPhoneNumber(){
    return phone_number;
  }

  public String getLocation(){
    return location;
  }

}

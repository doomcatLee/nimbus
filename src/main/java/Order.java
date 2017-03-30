
import java.util.ArrayList;
import java.util.List;

public class Order{

  private int id;
  private int invoice;
  private int total_price;
  List<String> cart = new ArrayList<String>();

  public Order(int invoice, int total_price){
    this.invoice = invoice;
    this.total_price = total_price;
  }

  public int getInvoice(){
    return invoice;
  }

  public int totalPrice(){
    return total_price;
  }

  public List<String> returnItems(){
    return cart;
  }

  public void addItem(String input){
    cart.add(input);
  }

  public String toString(){
    return "hello";
  }




}

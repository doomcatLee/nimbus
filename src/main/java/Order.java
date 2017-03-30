
import java.util.ArrayList;
import java.util.List;
import java.time.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import org.sql2o.*;

public class Order{

  private int id;
  private int invoice;
  private int total_price;
  private String date_created;
  List<String> cart = new ArrayList<String>();

  public Order(int invoice, int total_price){
    this.invoice = invoice;
    this.total_price = total_price;
    Date makeDate = new Date();
    this.date_created = new SimpleDateFormat("MM-dd-yyyy").format(makeDate);
  }

  public int getInvoice(){
    return invoice;
  }

  public int getTotalPrice(){
    return total_price;
  }

  public int getId(){
    return id;
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


  public static List<Order> all() {
    String sql = "SELECT id, invoice, total_price, date_created FROM orders";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Order.class);
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO orders(invoice, total_price, date_created) VALUES (:invoice, :total_price, :date_created)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("invoice", this.invoice)
        .addParameter("total_price", this.total_price)
        .addParameter("date_created",  this.date_created)
        .executeUpdate()
        .getKey();
    }
  }

  public static Order find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM orders WHERE id=:id";
      return con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Order.class);
    }
  }

  @Override
  public boolean equals(Object otherOrder) {
    if (!(otherOrder instanceof Order)) {
      return false;
    } else {
      Order newOrder = (Order) otherOrder;
      return this.getInvoice() == (newOrder.getInvoice()) &&
             this.getId() == newOrder.getId();
    }
  }



}

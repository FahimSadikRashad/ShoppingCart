package newpack;

public class CartValues_1 {
    String itemName=new String();
    Integer quantity=null;
    public CartValues_1(String itemName, Integer quantity){
        this.itemName=itemName;
        this.quantity=quantity;
    }
    public String getItemName(){
        return this.itemName;
    }
    public Integer getQuantity(){
        return  this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

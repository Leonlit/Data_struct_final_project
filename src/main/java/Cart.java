import java.util.ArrayList;

public class Cart {
    private ArrayList<Book> cart;
    
    public Cart(){
        cart = new ArrayList<Book>();
    }
    
    public ArrayList<Book> getCart () {
        return this.cart;
    }
    
    public void addBookIntoCart(Book book){
        if (book == null) {
            Menu.printMessage("Failed to add book into the cart. Nothing is given!");
        }
        this.cart.add(book);
        Menu.printMessage("Added " + book.getTitle() + " into the cart");
    }
    
    public void removeBookfromCart(int index){
        if (index > this.cart.size() - 1 || index < 0) {
            displayCartInvalidMessage();
        }
        Menu.printMessage("Removed " + this.cart.get(index).getTitle() + " with index " + index + " from the cart");
        this.cart.remove(index);
    }
    
    public Book getCartItem (int index) {
        if (index > cart.size() - 1 || index < 0) {
            displayCartInvalidMessage();
            return null;
        }
        return cart.get(index);
    }
    
    private void displayCartInvalidMessage() {
        String start = (this.cart.size() > 1)? "between 1 and " : ""; 
            Menu.printMessage("The cart index is not valid, please choose " + start + this.cart.size());
    }

    public void displayCart () {
        Menu.printTitle("Displaying Cart items");
        Menu.printEmptyRow();
        if(cart.size() == 0) {
            Menu.printTextContent("Cart is empty");
        }else {
            for (int idx = 0; idx< cart.size();idx++) {
                Menu.printOrderedOption(Integer.toString(idx + 1), cart.get(idx).getTitle());
            }
        }
        Menu.printEmptyRow();
        Menu.printHorizontalBorder(true);
    }
}
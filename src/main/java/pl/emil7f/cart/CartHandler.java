package pl.emil7f.cart;

public interface CartHandler {

    boolean canHandleCart(Cart cart);

    void sendToPrepare(Cart cart);
}

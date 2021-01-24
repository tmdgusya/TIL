package hello.order;

public interface OrderServie {

    Order createOrder(Long memberId, String itemName, int itemPrice);
}

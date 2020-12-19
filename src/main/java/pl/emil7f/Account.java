package pl.emil7f;

public class Account {

    private boolean active;
    private Address defaultDeliveryAddress;

    Account() {
        this.active = false;
    }

    void activate() {
        this.active = true;
    }

    boolean isActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Address getDefaultDeliveryAddress() {
        return defaultDeliveryAddress;
    }

    public void setDefaultDeliveryAddress(Address defaultDeliveryAddress) {
        this.defaultDeliveryAddress = defaultDeliveryAddress;
    }
}

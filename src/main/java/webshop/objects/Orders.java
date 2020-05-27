package webshop.objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Class representing one order.
 */
@Entity
public class Orders {

    @Id
    @GeneratedValue
    long ID;
    /**
     * The ID of the product.
     */
    long productnumb;
    /**
     * The ID of the product.
     */
    long purchasernumb;

    public Orders() {
    }

    public Orders(long purchasernumb) {
        this.purchasernumb = purchasernumb;
    }

    public Orders(long productnumb, long purchasernumb) {
        this.productnumb = productnumb;
        this.purchasernumb = purchasernumb;
    }

    public Orders(long ID, long productnumb, long purchasernumb) {
        this.productnumb = productnumb;
        this.purchasernumb = purchasernumb;
        this.ID = ID;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public long getProductnumb() {
        return productnumb;
    }

    public void setProductnumb(long productID) {
        this.productnumb = productID;
    }

    public long getPurchasernumb() {
        return purchasernumb;
    }

    public void setPurchasernumb(long purcasherID) {
        this.purchasernumb = purcasherID;
    }
}

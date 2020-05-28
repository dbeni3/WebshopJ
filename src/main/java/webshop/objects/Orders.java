package webshop.objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Class representing one order.
 */
@Entity
public class Orders {
    /**
     * The ID of the order.
     */
    @Id
    @GeneratedValue
    private long id;
    /**
     * The ID of the product.
     */
    private long productnumb;
    /**
     * The ID of the product.
     */
    private long purchasernumb;

    public Orders() {
    }

    public Orders(long purchasernumb) {
        this.purchasernumb = purchasernumb;
    }

    public Orders(long productnumb, long purchasernumb) {
        this.productnumb = productnumb;
        this.purchasernumb = purchasernumb;
    }

    public Orders(long id, long productnumb, long purchasernumb) {
        this.productnumb = productnumb;
        this.purchasernumb = purchasernumb;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long ID) {
        this.id = ID;
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

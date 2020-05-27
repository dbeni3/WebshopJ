package webshop.objects;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Class representing one purchaser.
 */
@Entity
public class Purchaser {
    /**
     * The ID of the purchaser.
     */
    @Id
    @GeneratedValue
    long ID;
    /**
     * The name of the purchaser.
     */
    private String name;
    /**
     * The phone number of the purchaser.
     */
    private String phoneNumb;
    /**
     * The email address of the purchaser.
     */
    private String email;
    /**
     * The postal code of the purchaser.
     */
    private String postalCode;
    /**
     * The address of the purchaser.
     */
    private String address;
    /**
     * The discount of the purchaser.
     */
    private String discount;


    public Purchaser() {
    }

    public Purchaser(String name, String phoneNumb, String email, String postalCode, String address, String discount) {
        this.name = name;
        this.address = address;
        this.phoneNumb = phoneNumb;
        this.email = email;
        this.postalCode = postalCode;
        this.discount = discount;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumb() {
        return phoneNumb;
    }

    public void setPhoneNumb(String phoneNumb) {
        this.phoneNumb = phoneNumb;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
}

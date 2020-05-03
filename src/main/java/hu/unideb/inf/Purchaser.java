package hu.unideb.inf;

public class Purchaser {
    private String name;
    private String phoneNumb;
    private String email;
    private String postalCode;
    private String address;
    public Purchaser(String name,String phoneNumb,String email,String postalCode,String address){
        this.name=name;
        this.address=address;
        this.phoneNumb=phoneNumb;
        this.email=email;
        this.postalCode=postalCode;
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
}

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

// PetOwner.java

public class PetOwner {
    // Private attributes (Encapsulation applied)
    private String name;
    private String petName;
    private String contactNumber;

    // Constructor to initialize all attributes
    public PetOwner(String name, String petName, String contactNumber) {
        this.name = name;
        this.petName = petName;
        this.contactNumber = contactNumber;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for petName
    public String getPetName() {
        return petName;
    }

    // Setter for petName
    public void setPetName(String petName) {
        this.petName = petName;
    }

    // Getter for contactNumber
    public String getContactNumber() {
        return contactNumber;
    }

    // Setter for contactNumber
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    // Method to print owner details
    public void printOwnerDetails() {
        System.out.println("Owner Name: " + name);
        System.out.println("Pet Name: " + petName);
        System.out.println("Contact Number: " + contactNumber);
    }

    /*
     * Encapsulation Explanation:
     * - The class uses private access modifiers for all fields.
     * - Public getters and setters control access to these fields.
     * - This hides internal data and allows validation or logic in future changes.
     */
}

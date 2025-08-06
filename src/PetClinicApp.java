//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PetClinicApp {
    static PetOwner[] owners = new PetOwner[20];
    static int ownerCount = 0;
    static int[] dogSlots = new int[10];
    static int[] catSlots = new int[10];
    static int[] rabbitSlots = new int[10];

    public static void main(String[] args) {
        System.out.println("Welcome to the Pet Clinic App!");
        runMenu();
    }

    public static void runMenu() {
        Scanner input = new Scanner(System.in);
        boolean cont = true;

        while(cont) {
            System.out.println();
            System.out.println("+------------------------------+");
            System.out.println("|         MAIN MENU           |");
            System.out.println("+------------------------------+");
            System.out.println("| 1) Book Appointment          |");
            System.out.println("| 2) Register Pet Owner        |");
            System.out.println("| 3) Search Owner by Pet Name  |");
            System.out.println("| 4) Save Data to File         |");
            System.out.println("| 0) Exit                      |");
            System.out.println("+------------------------------+");
            System.out.print("Select an option: ");
            int option = input.nextInt();
            switch (option) {
                case 0:
                    cont = false;
                    break;
                case 1:
                    bookAppointment();
                    break;
                case 2:
                    registerOwner();
                    break;
                case 3:
                    searchOwnerByPetName();
                    break;
                case 4:
                    saveToFile();
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

    }

    public static void bookAppointment() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter pet type (dog/cat/rabbit): ");
        String petType = input.nextLine().toLowerCase();

        int[] slots;

        switch (petType) {
            case "dog":
                slots = dogSlots;
                break;
            case "cat":
                slots = catSlots;
                break;
            case "rabbit":
                slots = rabbitSlots;
                break;
            default:
                System.out.println("Invalid pet type. Please enter dog, cat, or rabbit.");
                return;
        }

        System.out.println("Enter slot number (1-10): ");
        int slotNumber;

        try {
            slotNumber = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Slot number must be an integer.");
            return;
        }

        if (slotNumber < 1 || slotNumber > 10) {
            System.out.println("Slot number must be between 1 and 10.");
            return;
        }

        if (slots[slotNumber - 1] == 0) {
            slots[slotNumber - 1] = 1;
            System.out.println("Appointment booked successfully for a " + petType + " in slot " + slotNumber + ".");
        } else {
            System.out.println("Sorry, this slot is not available.");
        }
    }

    // 2. Complete registerOwner() method
    // ========== Your Code Here ==========
    public static void registerOwner() {
        if (ownerCount >= owners.length) {
            System.out.println("Cannot register more owners. Maximum limit reached.");
            return;
        }

        Scanner input = new Scanner(System.in);

        System.out.print("Enter owner's name: ");
        String name = input.nextLine();

        System.out.print("Enter pet's name: ");
        String petName = input.nextLine();

        System.out.print("Enter contact number: ");
        String contactNumber = input.nextLine();

        // Create new PetOwner object
        PetOwner newOwner = new PetOwner(name, petName, contactNumber);

        // Add to array
        owners[ownerCount] = newOwner;
        ownerCount++;

        System.out.println("Pet owner registered successfully!");
    }


    public static void searchOwnerByPetName() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter pet name to search: ");
        String searchName = input.nextLine().toLowerCase();

        boolean found = false;

        for (int i = 0; i < ownerCount; i++) {
            if (owners[i].getPetName().equalsIgnoreCase(searchName)) {
                owners[i].printOwnerDetails();
                found = true;
                break; // Stop after first match
            }
        }

        if (!found) {
            System.out.println("No owner found for that pet name.");
        }
    }

    public static void saveToFile() {
        try {
            FileWriter fw = new FileWriter("ClinicData.txt");

            for (int i = 0; i < ownerCount; i++) {
                PetOwner owner = owners[i];
                fw.write(owner.getName() + " " + owner.getPetName() + " " + owner.getContactNumber() + "\n");
            }

            fw.close();
            System.out.println("Data saved to file.");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

}

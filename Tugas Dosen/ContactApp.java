import java.util.ArrayList;
import java.util.Scanner;

public class ContactApp {

    static class Contact {
        String contactName;
        String contactPhone;

        Contact(String contactName, String contactPhone) {
            this.contactName = contactName;
            this.contactPhone = contactPhone;
        }
    }

    public static void main(String[] args) {
        ArrayList<Contact> contactList = new ArrayList<>();
        Scanner inputScanner = new Scanner(System.in);

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n--- Contact App ---");
            System.out.println("1. Tambah Kontak");
            System.out.println("2. Lihat Semua Kontak");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");

            try {
                int menuChoice = Integer.parseInt(inputScanner.nextLine());

                // Program Verification: pastikan logika tiap pilihan menu benar
                if (menuChoice == 1) {
                    System.out.print("Masukkan Nama: ");
                    String nameInput = inputScanner.nextLine();
                    System.out.print("Masukkan Nomor Telepon: ");
                    String phoneInput = inputScanner.nextLine();

                    // Defensive Programming: validasi input
                    if (nameInput == null || nameInput.isEmpty() || phoneInput == null || phoneInput.isEmpty()) {
                        System.out.println("Nama dan Nomor Telepon tidak boleh kosong.");
                    } else {
                        contactList.add(new Contact(nameInput, phoneInput));
                        System.out.println("Kontak berhasil ditambahkan.");
                    }

                } else if (menuChoice == 2) {
                    if (contactList.isEmpty()) {
                        System.out.println("Daftar kontak masih kosong.");
                    } else {
                        for (Contact c : contactList) {
                            System.out.println(c.contactName + " - " + c.contactPhone);
                        }
                    }

                } else if (menuChoice == 3) {
                    isRunning = false;
                    System.out.println("Aplikasi ditutup.");

                } else {
                    System.out.println("Pilihan menu tidak valid.");
                }

            } catch (Exception e) {
                // Best Practice: tangani kesalahan agar program tetap berjalan
                System.out.println("Terjadi kesalahan: " + e.getMessage());
            }
        }

        inputScanner.close();
    }
}
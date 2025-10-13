/*
Buatlah sebuah program yang meminta pengguna untuk memasukkan usia mereka. Program ini
harus memastikan bahwa usia yang dimasukkan valid (lebih besar dari 0 dan kurang dari 120).
Jika usia tidak valid, lemparkan custom exception InvalidAgeException dengan pesan
kesalahan yang sesuai.
*/

import java.util.Scanner;

public class Codelab2 {
    public static void main(String[] args) {
        Scanner myscanner = new Scanner(System.in);

        System.out.println("Masukkan Umur");

        try{
            int age = myscanner.nextInt();
            if(age <= 0 || age >= 120){
                throw new InvalidAge("Age invalid");
            }else {
                System.out.println("Age Valid");
            }
        }catch (InvalidAge e){
            System.out.println(e);
        }

    }

}

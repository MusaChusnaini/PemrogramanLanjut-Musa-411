package Codelab;

import java.util.Random;
import java.util.Scanner;

public class RandomNumber {
    static Random random = new Random();
    static Scanner myScanner = new Scanner(System.in);
    public static void RandomNumberGenerator(){

        int randomized = 0;

        System.out.print("Min Nilai : ");
        int boundLeft = myScanner.nextInt();
        System.out.print("Max Nilai : ");
        int boundRight = myScanner.nextInt();

        randomized = random.nextInt(boundLeft,boundRight);
        System.out.println("Nilai random dari "+boundLeft+" : "+boundRight+" Adalah : "+randomized);
    }

    public static void MenambahkanKalimat(){

        String input = myScanner.nextLine();

        int randomChar = random.nextInt(0,input.length());

        System.out.println("Random char from strin : " + input.charAt(randomChar));
    }

    public static void main(String[] args) {
        int pilihan = 0;
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Menu : ");
        System.out.println("1. Menghasilkan bilangan bulat acak");
        System.out.println("2. Mengambil karakter acak dari string");
        System.out.println("3. Keluar");
        System.out.print("Pilihan :");
        pilihan = myScanner.nextInt();

        switch (pilihan){
            case 1:
                RandomNumberGenerator();
                break;
            case 2:
                MenambahkanKalimat();
                break;
            case 3:
                break;
        }
    }
}

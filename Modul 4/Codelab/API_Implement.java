package Codelab;

import java.util.Scanner;

public class API_Implement {
    public static void main(String[] args) {
        String kalimat;
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Masukkan Kalimat : ");
        kalimat = myScanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder(kalimat);

        String[] kalimatPecah = kalimat.split(" ");
        System.out.println("Kalimat kedua : " + kalimatPecah[1]);
        System.out.println("Huruf Kapital : " + kalimat.toUpperCase());



        System.out.print("Apakah ada java? : ");
        for (String kal : kalimatPecah){
            boolean val;
            kal.toLowerCase();
            if(kal.contains("java")) {
                val = true;
                System.out.println(val);
                break;
            }

        }
        System.out.println("Masukkan Kalimat yang mau ditambahkan : ");
        String input = myScanner.nextLine();

        System.out.println("Setelah menambahkan kalimat baru : " + stringBuilder.append(" "+input));
        System.out.println("Kalimat terbalik : " + stringBuilder.reverse());

        myScanner.close();
    }
}

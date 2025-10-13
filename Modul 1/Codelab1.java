/*
Buatlah program untuk mencari nama terpanjang dalam sebuah array nama. Program ini
memiliki kesalahan dalam cara mengakses array dan memproses string. Identifikasi kesalahan
dan perbaiki agar program dapat berjalan sesuai dengan yang diharapkan.
*/


import java.util.ArrayList;

public class Codelab1 {
    public static void main(String[] args) {
        String[] nama = {"Adi","Budi","Cahyo","Diana","Muhammad Abu Bakar","Ahmad Balwi","Eva","Retno"};
        ArrayList<String> namaTerpanjang = IdentifikasiIsiArray(nama);

        for (String name : namaTerpanjang){

            System.out.println("Nama terpanjang adalah : " + name);
        }
    }

    private static String CariNamaTerpanjang(String[] array) {
        String namaTerpendek = array[0];
        for(String nama : array){
            if(nama.length() > namaTerpendek.length()){
                namaTerpendek = nama;
            }
            if(nama.length() == namaTerpendek.length()){
                namaTerpendek = nama;
            }
        }
        return namaTerpendek;
    }

    private static ArrayList<String> IdentifikasiIsiArray(String[] array){
        // loop array dan bandingkan setiap string yang terpanjang dan terpendek

        String longName;

        ArrayList<String> longestName = new ArrayList<>();
        // sebelum 5 sesuah 8
        // sebelum 8 sesuah 4
        // sebelum 8 sesudah 8
        // sebelum 8 sesuah 9
        // 9
        for (int i = 0; i < array.length; i++) {
            if(i < array.length -1){
                if(array[i].length() < array[i+1].length()){
                    longName = array[i+1];
                    longestName.add(longName);
                }
            }

        }

        return longestName;
    }
}

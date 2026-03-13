package Tugas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class FilmManagement {

    public static class Film{
        String namaFilm;
        int tahunRilis;

        public String getNamaFilm() {
            return namaFilm;
        }

        public int getTahunRilis() {
            return tahunRilis;
        }

        public Film(String namaFilm, int tahunRilis) {
            this.namaFilm = namaFilm;
            this.tahunRilis = tahunRilis;
        }
    }
    public static Scanner myScanner = new Scanner(System.in);
    public static ArrayList<Film> films = new ArrayList<>();

    public static void main(String[] args) {
        int pilihan;
        do {

            System.out.println("=== Menu Manajemen Film ===");
            System.out.println("1. Tambah Film Baru");
            System.out.println("2. Urutkan Berdasarkan Nama Film (A-Z)");
            System.out.println("3. Urutkan Berdasarkan Tahun (Ascending)");
            System.out.println("4. Keluar Program");

            System.out.print("Masukkan pilihan (1-4) :");
            pilihan = myScanner.nextInt();
            switch (pilihan){
                case 1:
                    TambahFilm();
                    break;
                case 2:
                    UrutkanSesuaiNama();
                    break;
                case 3:
                    UrutkanSesuaiTahunRilis();
                    break;
                case 4:
                    return;
                default:
                    break;
            }
        }while (pilihan<4 || pilihan<=0);
    }

    private static void UrutkanSesuaiTahunRilis() {
        Collections.sort(films,(Comparator.comparingInt(Film::getTahunRilis)));
        ShowFilms();
    }

    static void ShowFilms(){
        for (Film film : films){
            System.out.println(film.getNamaFilm()+", "+film.getTahunRilis());
        }
    }

    private static void UrutkanSesuaiNama() {
        Collections.sort(films, (Comparator.comparing(Film::getNamaFilm))); // lambda expression
        ShowFilms();
    }

    public static void TambahFilm(){
        myScanner.nextLine();
        System.out.print("Masukkan Nama Film : ");
        String namaFilm = myScanner.nextLine();
        System.out.print("Masukkan Tahun Rilis : ");
        int tahunRilis = myScanner.nextInt();
        Film film = new Film(namaFilm,tahunRilis);

        films.add(film);
    }
}
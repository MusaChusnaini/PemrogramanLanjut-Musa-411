import java.util.Scanner;

public class Tugas1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan jumlah angka: ");
        int n = scanner.nextInt();

        int[] angka = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Masukkan angka ke:"+ (i+1));
            angka[i] = scanner.nextInt();
        }

        int total = 0;
        for(int nilai : angka){
            total += nilai;
        }

        double rataRata = (double) total / n;
        System.out.println("Rata-rata adalah: " + rataRata);

        scanner.close();
    }
}

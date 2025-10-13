import java.util.Scanner;

public class Tugas3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String namaMahasiswa = null;
        int nilaiMahasiswa = 0;

        namaMahasiswa = scanner.nextLine();
        nilaiMahasiswa = scanner.nextInt();

        if(nilaiMahasiswa >= 60){
            // lulus
            System.out.println("Selamat kepada mahasiswa "+namaMahasiswa+", Telah dinyatakan lulus dengan nilai sebesar "+nilaiMahasiswa+".");
        }else {
            // tidak lulus
            System.out.println("Mohon maaf, mahasiswa "+namaMahasiswa+", dinyatakan tidak lulus dengan nilai sebesar "+nilaiMahasiswa+".");
        }
    }
}

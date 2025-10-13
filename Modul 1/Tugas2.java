import java.util.Scanner;

public class Tugas2 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Masukkan angka positif: ");
            int input = scanner.nextInt();

            if (input < 0) {
                throw new PositiveChecker("Angka harus positif.");
            }else {
                System.out.println("Positif coy");
            }
        } catch (PositiveChecker positiveChecker) {
            System.err.println(positiveChecker);
        }
    }


}

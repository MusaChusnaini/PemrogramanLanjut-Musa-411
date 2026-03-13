import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MetodeIterasiGaussSeidel {

    public void hitungPersamaan(double e) {
        List<String> csvList = new ArrayList<>();

        final double TOLERANSI_ERROR = 0.000001;
        int iterasi = 1;

        // Persamaan:
        // 4x1 +  x2 +  x3 = 7
        // -2x1 + 6x2 +  x3 = 9
        //  x1 +  x2 + 5x3 = -6

        double[][] A = {
                {4, 1, 1},
                {-2, 6, 1},
                {1, 1, 5}
        };

        double[] b = {e, 9, -6};

        double x1 = 0, x2 = 0, x3 = 0;
        double newx1, newx2, newx3;
        double error1, error2, error3;

        System.out.printf("4x₁ + x₂ + x₃ = %.7f%n", b[0]);
        System.out.println("-2x₁ + 6x₂ + x₃ = 9");
        System.out.println("x₁ + x₂ + 5x₃ = -6\n");

        do {
            // Iterasi Gauss-Seidel
            newx1 = (b[0] - A[0][1] * x2 - A[0][2] * x3) / A[0][0];
            newx2 = (b[1] - A[1][0] * newx1 - A[1][2] * x3) / A[1][1];
            newx3 = (b[2] - A[2][0] * newx1 - A[2][1] * newx2) / A[2][2];

            // Hitung error
            error1 = Math.abs(newx1 - x1);
            error2 = Math.abs(newx2 - x2);
            error3 = Math.abs(newx3 - x3);

            double errorMaks = Math.max(error1, Math.max(error2, error3));

            System.out.println("Iterasi ke-" + iterasi);
            System.out.printf("x₁ = (%.7f - %.7f*%.4f - %.7f*%.4f) / %.7f = %.6f%n",
                    b[0], A[0][1], x2, A[0][2], x3, A[0][0], newx1);
            System.out.printf("x₂ = (%.7f - (%.7f*%.4f) - %.7f*%.4f) / %.7f = %.6f%n",
                    b[1], A[1][0], newx1, A[1][2], x3, A[1][1], newx2);
            System.out.printf("x₃ = (%.7f - (%.7f*%.4f) - %.7f*%.4f) / %.7f = %.6f%n",
                    b[2], A[2][0], newx1, A[2][1], newx2, A[2][2], newx3);
            System.out.printf("Error Maksimum = %.10f%n%n", errorMaks);

            // Simpan ke list
            String baris = String.format("%d:%.6f:%.6f:%.6f:%.7f:%.7f:%.7f:%.7f",
                    iterasi, newx1, newx2, newx3, error1, error2, error3, errorMaks);
            csvList.add(baris);

            // Simpan CSV di setiap iterasi
            writeToCSV("D:/hasilgaussseidel.csv", csvList);

            // Update nilai lama
            x1 = newx1;
            x2 = newx2;
            x3 = newx3;

            if (errorMaks < TOLERANSI_ERROR)
                break;

            iterasi++;
        } while (true);

        System.out.println("Hasil Akhir:");
        System.out.printf("x₁ = %.6f%n", x1);
        System.out.printf("x₂ = %.6f%n", x2);
        System.out.printf("x₃ = %.6f%n", x3);
    }

    private void writeToCSV(String namaFile, List<String> list) {
        try (FileWriter writer = new FileWriter(namaFile)) {
            for (String baris : list) {
                writer.write(baris + "\n");
            }
        } catch (IOException ex) {
            System.out.println("Gagal menyimpan CSV: " + ex.getMessage());
        }
    }

    // Main untuk uji coba
    public static void main(String[] args) {
        MetodeIterasiGaussSeidel m = new MetodeIterasiGaussSeidel();
        m.hitungPersamaan(0); // ganti sesuai nilai e yang kamu mau
    }
}

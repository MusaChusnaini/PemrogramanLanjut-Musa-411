package MetodeNumerik.Metode;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ErrorFindBisection {

    private List<String> hasil = new ArrayList<>();

    // Hitung f(x) = x * e^(-x) + 1
    private double HitungFungsi(double x, double e) {
        double eX = Math.pow(e, -x);
        return x * eX + 1;
    }

    // Menulis ke file CSV
    private void WriteToCSV(String namaFile, List<String> list) {
        try (FileWriter writer = new FileWriter(namaFile)) {
            for (String line : list) {
                writer.write(line + "\n");
            }
        } catch (IOException ex) {
            System.out.println("Gagal menyimpan CSV: " + ex.getMessage());
        }
    }

    // Proses utama mencari akar
    public void HitungAkar(double batasA, double batasB, double e) {
        final double ERROR_TOLERATION = 0.001;
        double a = batasA;
        double b = batasB;

        double x = (a + b) / 2;
        double funA = HitungFungsi(a, e);
        double funB = HitungFungsi(b, e);
        double funX = HitungFungsi(x, e);
        String keterangan;

        if (funA * funB > 0) {
            System.out.println("Akar tidak ada.");
            return;
        }

        int iterasi = 0;
        DecimalFormat fmt = new DecimalFormat("0.000000");

        hasil.add("Iterasi;a;b;x;f(x);f(a);Keterangan");

        do {
            iterasi++;
            x = (a + b) / 2;
            funX = HitungFungsi(x, e);
            funA = HitungFungsi(a, e);
            funB = HitungFungsi(b, e);

            if ((funX * funA) < 0) {
                b = x;
                keterangan = "berlawanan";
            } else {
                a = x;
                keterangan = "";
            }

            System.out.println("Iterasi ke " + iterasi);
            System.out.println("x = (" + a + " + " + b + ") / 2");
            System.out.println("f(x) = " + x + " * " + e + "^(-" + x + ") + 1 = " + funX);
            System.out.println("f(a) = " + a + " * " + e + "^(-" + a + ") + 1 = " + funA);
            System.out.println("a = " + a + "\nb = " + b + "\nx = " + x + "\nf(x) = " + funX + "\nf(a) = " + funA);
            System.out.println();

            hasil.add(iterasi + ";" +
                    fmt.format(a) + ";" +
                    fmt.format(b) + ";" +
                    fmt.format(x) + ";" +
                    fmt.format(funX) + ";" +
                    fmt.format(funA) + ";" +
                    keterangan);

            WriteToCSV("D:/hasil.csv", hasil);

            if (iterasi >= 1000) break; // biar aman dari loop tak hingga
        } while (Math.abs(funX) > ERROR_TOLERATION);

        System.out.println("Pada iterasi ke-" + iterasi + " diperoleh x = " + x);
        System.out.println("Dan f(x) = " + funX);
        System.out.println("Jadi, akar-nya adalah = " + x);
    }

    // Contoh penggunaan
    public static void main(String[] args) {
        ErrorFindBisection efb = new ErrorFindBisection();
        efb.HitungAkar(-1, 0, 10411);
    }
}

import java.util.InputMismatchException;
import java.util.Scanner;

public class HitungLuasPersegiPanjang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hasil = 0, p, l;
        try{
            System.out.println("Masukkan Panjang");
            p = scanner.nextInt();
            System.out.println("Masukkan Luas");
            l = scanner.nextInt();
            if(p <= 0 || l <= 0){
                throw new RuntimeException("Input harus tidak boleh 0");
            }else {

                hasil = luasPersegiPanjang(p,l);
            }


        }catch (InputMismatchException inputMismatchException){
            System.err.println("Kamu memasukkan input yang salah");
        }catch (NullPointerException nullPointerException){
            System.err.println("Scanner belum dibuat.");
        }finally {
            System.out.println("Hasil : " + hasil);
            scanner.close();
        }

    }

    private static int luasPersegiPanjang(int p, int l) {
        return  p * l;
    }
}

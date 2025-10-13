public class Tugas4 {
    public static int findMin(int a, int b, int c) {
        if (a <= b && a <= c) {
            return a;
        } else if (b <= a && b <= c) {
            return b;
        } else {
            return c;
        }
    }

    public static void main(String[] args) {
        System.out.println("Skenario 1 : Membandingkan (1, 2,dan 3)");
        System.out.println("Hasil : "+findMin(1,2,3));
        System.out.println("Skenario 2 : Membandingkan (-1, -2,dan -3)");
        System.out.println("Hasil : "+findMin(-1,-2,-3));
        System.out.println("Skenario 3 : Membandingkan (0, 0,dan 3)");
        System.out.println("Hasil : "+findMin(0,0,3));

    }
}

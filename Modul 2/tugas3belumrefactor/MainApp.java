package tugas3belumrefactor;

import java.util.Scanner;

public class MainApp {
     static int currentIndex = 0;

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        Dialog dialog = new Dialog();
        dialog.AddDialogue("Halo");
        dialog.AddDialogue("Halo Juga");
        dialog.AddDialogue("Iya");

        // muncul pertama kali
        dialog.ShowDialogue(currentIndex);


        while (currentIndex < dialog.getDialogs().size()){
            currentIndex++;
            myScanner.nextLine();
            myScanner.reset();
            if(currentIndex < dialog.getDialogs().size()){
                dialog.ShowDialogue(currentIndex);
            }

        }

    }


}

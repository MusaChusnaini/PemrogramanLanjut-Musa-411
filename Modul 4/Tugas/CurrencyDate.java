package Tugas;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

public class CurrencyDate {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.print("Masukkan Uang : ");
        double jumlahUang = myScanner.nextInt();
        myScanner.nextLine();
        System.out.print("Masukkan Tanggal : ");
        String date = myScanner.nextLine();

        FormatInput(Locale.CHINA,jumlahUang,date);
        FormatInput(Locale.JAPAN,jumlahUang,date);
        FormatInput(Locale.US,jumlahUang,date);
    }

    public static void FormatInput(Locale negara,double jumlahUang,String date){

        // Date Format
        System.out.println("=== Locale : "+negara.getCountry()+" ===");
        try{
            NumberFormat numberFormat = NumberFormat.getCurrencyInstance(negara);
            System.out.println("Country : " + negara.getDisplayCountry());
            System.out.println("Currency Code : " + numberFormat.getCurrency().getCurrencyCode());
            System.out.println("Currency Symbol : " + numberFormat.getCurrency().getSymbol());

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate parsedDate = LocalDate.parse(date,formatter);

            DateTimeFormatter localFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withLocale(negara);
            System.out.println("Formatted Currency : " +numberFormat.format(jumlahUang));
            System.out.println("Formatted Date : " + parsedDate.format(localFormatter));
        }catch (Exception e){
            System.err.println("Date can't be parsed " +e);
        }

        System.out.println();


}
}

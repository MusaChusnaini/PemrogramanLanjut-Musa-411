import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WriteFileXLS {
    public static class DataMahasiswa{
        private String nama;
        private int semester;
        private String mataKuliah;

        public DataMahasiswa(String nama, int semester, String mataKuliah) {
            this.nama = nama;
            this.semester = semester;
            this.mataKuliah = mataKuliah;
        }
    }
    static Scanner myScanner = new Scanner(System.in);
    static ArrayList<DataMahasiswa> dataMahasiswaArrayList = new ArrayList<>();
    public static void main(String[] args) {
        InputToList();
    }

    public static void InputToList(){
        String nama = "";
        int iterasi =1;

        do {
            System.out.print("Masukkan Nama : ");
            nama = myScanner.nextLine();
            if(nama.equals("selesai")){
                InitializeExcel();
                System.out.println("Program selesai");
                break;
            }else if(CheckNameAvailability(nama)){
                System.out.println("Nama tidak boleh sama");
                continue;
            }
            System.out.print("Masukkan Semester : ");
            int semester = myScanner.nextInt();
            myScanner.nextLine();
            System.out.print("Masukkan Mata Kuliah : ");
            String mataKuliah = myScanner.nextLine();

            DataMahasiswa dataMahasiswa = new DataMahasiswa(nama,semester,mataKuliah);
            dataMahasiswaArrayList.add(dataMahasiswa);
            System.out.println("Ditambahkan ke data.");
        }while (true);



    }

    static boolean CheckNameAvailability(String nama) {
        for (DataMahasiswa dm : dataMahasiswaArrayList) {
            if (dm.nama.equals(nama)) return true;
        }
        return false;
    }


    static void InitializeExcel() {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet1");

        // Header
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Nama");
        header.createCell(1).setCellValue("Semester");
        header.createCell(2).setCellValue("Mata Kuliah");

        // Loop data
        for (int i = 0; i < dataMahasiswaArrayList.size(); i++) {
            DataMahasiswa dm = dataMahasiswaArrayList.get(i);
            Row row = sheet.createRow(i + 1);

            row.createCell(0).setCellValue(dm.nama);
            row.createCell(1).setCellValue(dm.semester);
            row.createCell(2).setCellValue(dm.mataKuliah);
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("data_mahasiswa.xlsx");
            workbook.write(fileOutputStream);
            fileOutputStream.close();
            workbook.close();
            System.out.println("Excel berhasil diperbarui.");
        } catch (IOException e) {
            System.out.println("Gagal menyimpan file: " + e.getMessage());
        }
    }



}

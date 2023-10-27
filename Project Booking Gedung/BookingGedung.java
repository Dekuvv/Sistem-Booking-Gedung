import java.util.Scanner;

public class BookingGedung {

    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        String identitasPemesan, jenisGedung, tanggalPelaksanaanAcara, layananTambahan, nomorTelepon,alamatEmail, konfirmasi, acara;
        String layananTambahan2 [] = new String[5];
        int jumlahTamu, tanggalPemesanan;
        
        //Penampilan awal
        System.out.println("===================================================================");
        System.out.println("||                                                               ||");
        System.out.println("||                       SELAMAT DATANG                          ||");
        System.out.println("||                      DI HOTEL DE'LOBBY                        ||");
        System.out.println("||                                                               ||");
        System.out.println("===================================================================");
        
        //INPUT
        System.out.print("Masukkan Nama\t\t: ");
        identitasPemesan = input.nextLine();

        System.out.print("Masukkan Tanggal\t: ");
        tanggalPemesanan = input.nextInt();

        System.out.print("Acara yang akan digelar (pernikahan / rapat) : ");
        acara = input.next();
        if (acara.equalsIgnoreCase("pernikahan")) {

            System.out.print("Tanggal Pelaksanaan Acara : ");
            input.nextLine();
            tanggalPelaksanaanAcara = input.nextLine();
            
            System.out.print("Jumlah Tamu Undangan:\n Gedung A = 100 - 200\n Gedung B = 200 - 300\n Gedung C = 300 - 400\n Masukkan Jumlah Tamu :  ");
            jumlahTamu = input.nextInt();
            
        if (jumlahTamu <=200) {
                System.out.println("Anda akan menggunakan Gedung A");
        }else if (200 <= jumlahTamu && jumlahTamu <=300 ) {
            System.out.println("Anda akan menggunakan Gedung B");
        }else if (300<= jumlahTamu && jumlahTamu <= 400) {
            System.out.println("Anda akan menggunakan Gedung C");
        }else{
            System.out.println("Pemesanan Anda Melebihi Kapasitas Gedung");
        }
        
        System.out.print("Masukkan Nomor Telepon : ");
        nomorTelepon = input.next();
        
        System.out.print("Masukkan Alamat Email  : ");
        alamatEmail = input.next();
        
        while (!(jumlahTamu <= 400)){
            System.out.println("Tamu undangan anda melebihi kapasitas");
            System.out.println("Silahkan coba lagi");
            System.out.print("Jumlah Tamu Undangan:\n Gedung A = 100 - 200\n Gedung B = 200 - 300\n Gedung C = 300 - 400\n Masukkan Jumlah Tamu:  ");
            jumlahTamu = input.nextInt();
        }
        
        if (jumlahTamu <=200) {
            jenisGedung = "Gedung A";
        }else if (200 <= jumlahTamu && jumlahTamu <=300 ) {
            jenisGedung = "Gedung B";
        }else if (300<= jumlahTamu && jumlahTamu <= 400){
            jenisGedung = "Gedung C";
        }else {
            jenisGedung = "coba lagi";
        }
        
        System.out.println("Layanan Tambahan : ");
        System.out.println("1. Catering");
        System.out.println("2. MC");
        System.out.println("3. Photography + Video Graphy");
        System.out.println("4. Dekorasi");
        System.out.println("5. Musik dan Hiburan");
        int jmlLayananTambahan = 0;

        do{
            System.out.print("Masukkan nomor layanan tambahan yang anda pilih : ");
            layananTambahan = input.next();
            if (layananTambahan.equals("1")){
                layananTambahan2[jmlLayananTambahan] = "Catering";
                jmlLayananTambahan++;
            }if (layananTambahan.equals("2")){
                layananTambahan2[jmlLayananTambahan] = "MC";
                jmlLayananTambahan++;
            }if (layananTambahan.equals("3")){
                layananTambahan2[jmlLayananTambahan] = "Photography + Video Graphy";
                jmlLayananTambahan++;
            }if (layananTambahan.equals("4")){
                layananTambahan2 [jmlLayananTambahan]= "Dekorasi";
                jmlLayananTambahan++;
            }if (layananTambahan.equals("5")){
                layananTambahan2 [jmlLayananTambahan] = "Musik dan Hiburan";
                jmlLayananTambahan++;
            }
            System.out.print("Apakah Ingin Menambah Layanan Tambahan?\n(y) untuk iya\n(t) untuk tidak : ");
            konfirmasi = input.next();
        }while (konfirmasi.equalsIgnoreCase("y"));
        
        
        
        boolean pemesananBerhasil = true;
        //OUTPUTTTT
        if (pemesananBerhasil) {
            System.out.println("\n=======================================================================");
            System.out.println("                          NOTA PEMESANAN                        ");
            System.out.println("         Nama Pemesan\t\t\t: " + identitasPemesan);
            System.out.println("         Nomor Handphone Pemesan\t: " + nomorTelepon);
            System.out.println("         Alamat Email Pemesan\t\t: " + alamatEmail);
            System.out.println("         Tanggal Pemesanan\t\t: " + tanggalPemesanan);
            System.out.println("         Tanggal Pelaksanaan Acara\t: " + tanggalPelaksanaanAcara);
            System.out.println("         Jumlah Tamu Undangan\t\t: " + jumlahTamu);
            System.out.println("         Jenis Gedung\t\t\t: " + jenisGedung);

            int i = 0, j = 1;
            System.out.print("         Layanan Tambahan\t\t: " );
            while (i < jmlLayananTambahan){
                System.out.println("" + j + "." + " " + layananTambahan2[i] );
                i++;
                j++;
            }
            
            System.out.println("         Nomor Telepon\t\t\t: " + nomorTelepon);
            System.out.println("         Alamat Email\t\t\t: " + alamatEmail);
            System.out.println("=======================================================================");
        } else {
            System.out.println("Maaf, Pemesanan yang anda minta tidak dapat kami proses. Silahkan coba lagi nanti.");
            
        }
            
        }
        System.out.println("\n===================================================================");
        System.out.println("||                                                               ||");
        System.out.println("||                        TERIMAKASIH                            ||");
        System.out.println("||                   SUDAH MEMESAN LAYANAN KAMI                  ||");
        System.out.println("||                                                               ||");
        System.out.println("==================================================================="); 
        //CLOSING SCANNER
        input.close();
    }
}
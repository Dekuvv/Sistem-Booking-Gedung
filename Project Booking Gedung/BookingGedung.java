import java.util.Scanner;

public class BookingGedung {

    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        String identitasPemesan, jenisGedung, tanggalPelaksanaanAcara, layananTambahan, tanggalPemesanan ,nomorTelepon,alamatEmail, konfirmasi;
        String layananTambahan2 [] = new String[5];
        int jumlahTamu;
        
        //INPUT
        System.out.print("Masukkan Nama : ");
        identitasPemesan = input.nextLine();

        System.out.print("Masukkan Tanggal : ");
        tanggalPemesanan = input.nextLine();

        System.out.print("Tanggal Pelaksanaan Acara : ");
        tanggalPelaksanaanAcara = input.nextLine();

        System.out.print("Jumlah Tamu Undangan:\n Gedung A = 100 - 200\n Gedung B = 200 - 300\n Gedung C = 300 - 400\n Masukkan Jumlah Tamu:  ");
        jumlahTamu = input.nextInt();

         if (jumlahTamu <=200) {
            System.out.println("Anda akan menggunakan Gedung A");
        }else if (200 <= jumlahTamu && jumlahTamu <=300 ) {
            System.out.println("Anda akan menggunakan Gedung B");
        }else if (300<= jumlahTamu && jumlahTamu <= 400) {
            System.out.println("Anda akan menggunakan Gedung C");
        }else{
            System.out.println("Yang bener masukin tamunya woi");
        }

        System.out.print("Masukkan Nomor Telepon : ");
        nomorTelepon = input.next();

        System.out.print("Masukkan Alamat Email : ");
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
                if (layananTambahan.equalsIgnoreCase("1")){
                    layananTambahan2[jmlLayananTambahan] = "Catering";
                    jmlLayananTambahan++;
                }else if (layananTambahan.equalsIgnoreCase("2")){
                    layananTambahan2[jmlLayananTambahan] = "MC";
                    jmlLayananTambahan++;
                }else if (layananTambahan.equalsIgnoreCase("3")){
                    layananTambahan2[jmlLayananTambahan] = "Photography + Video Graphy";
                    jmlLayananTambahan++;
                }else if (layananTambahan.equalsIgnoreCase("4")){
                    layananTambahan2 [jmlLayananTambahan]= "Dekorasi";
                    jmlLayananTambahan++;
                }else if (layananTambahan.equalsIgnoreCase("5")){
                    layananTambahan2 [jmlLayananTambahan] = "Musik dan Hiburan";
                    jmlLayananTambahan++;
                }
            System.out.print("Apakah Ingin Menambah Layanan Tambahan?\n(y) untuk iya\n(t) untuk tidak : ");
            konfirmasi = input.next();
            }while (konfirmasi.equalsIgnoreCase("y"));
            
           

        boolean pemesananBerhasil = true;
        //OUTPUTTTT
        if (pemesananBerhasil) {
            System.out.println("------ Pemesanan Telah Berhasil------");
            System.out.println("Nama Pemesan : " + identitasPemesan);
            System.out.println("Nomor Handphone Pemesan : " + nomorTelepon);
            System.out.println("Alamat Email Pemesan : " + alamatEmail);
            System.out.println("Tanggal Pemesanan : " + tanggalPemesanan);
            System.out.println("Tanggal Pelaksanaan Acara : " + tanggalPelaksanaanAcara);
            System.out.println("Jumlah Tamu Undangan : " + jumlahTamu);
            System.out.println("Jenis Gedung : " + jenisGedung);
    
            int i = 0, j = 1;
            System.out.println("Layanan Tambahan:");
            while (i < jmlLayananTambahan){
                System.out.println(j + "." + " " +layananTambahan2[i]);
                i++;
                j++;
            }

            System.out.println("Nomor Telepon : " + nomorTelepon);
            System.out.println("Alamat Email : " + alamatEmail);
        } else {
            System.out.println("Maaf, Pemesanan yang anda minta tidak dapat kami proses. Silahkan coba lagi nanti.");

        }
        //CLOSING SCANNER
        input.close();
    }
}
import java.util.Arrays;
import java.util.Scanner;

public class BookingGedung {

    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        String identitasPemesan, jenisGedung, tanggalPelaksanaanAcara , tanggalPelaksanaanRapat, layananTambahan, nomorTelepon,alamatEmail, konfirmasi, acara;
        String layananTambahan2 []  = new String[5];
        int jumlahTamu, tanggalPemesanan;

        String [][] akun = {{"Adit Bagus Sadewa"}, {"Muhammad Kemal Syahru Ramadhan"}, {"Dhevina Agustina"}};
        String [][] password = {{"2341760149"} , {"2341760196"}, {"2341760065"}};

        //Penampilan awal
        System.out.println("===================================================================");
        System.out.println("||                                                               ||");
        System.out.println("||                       SELAMAT DATANG                          ||");
        System.out.println("||                      DI HOTEL DE'LOBBY                        ||");
        System.out.println("||                                                               ||");
        System.out.println("===================================================================");
    
        //lOGIN
        boolean login = false;

        do {
            System.out.print("Masukkan Akun Anda\t: ");
            String username = input.nextLine();
            System.out.print("Masukkan PIN Anda\t: ");
            String pin = input.nextLine();
            
            for (int i = 0; i < akun.length; i++) {
                for (int j = 0; j < akun[i].length; j++)
                if (username.equals(akun[i][j]) && pin.equals(password[i][j])) {
                    login = true;
                    System.out.println("=======================");
                    System.out.println("|| Login anda berhasil ||");
                    System.out.println("=======================");
                    break;
                }
            }
        
            if (!login) {
                System.out.println("Akun dan PIN yang Anda masukkan salah!");
            }
        } while (!login);
        

        
        //INPUT
        System.out.print("Masukkan Nama\t\t: ");
        identitasPemesan = input.nextLine();

        System.out.print("Masukkan Tanggal\t: ");
        tanggalPemesanan = input.nextInt();
        input.nextLine();
        System.out.print("Acara yang akan digelar (pernikahan / rapat) : ");
        acara = input.next();
        //Acara pernikahan
        if (acara.equalsIgnoreCase("pernikahan")) 
        {

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
            
            String pilihanMenu, confirmCatering;
            String menu [] = new String[3];
            int k = 0, l = 0;
            boolean cateringBoolean = false;
            int jmlLayananTambahan = 0;
            do{
                System.out.println("Layanan Tambahan : ");
                System.out.println("1. Catering");
                System.out.println("2. MC");
                System.out.println("3. Photography + Video Graphy");
                System.out.println("4. Dekorasi");
                System.out.println("5. Musik dan Hiburan");
                System.out.print("Masukkan nomor layanan tambahan yang anda pilih : ");
                layananTambahan = input.next();
                if (layananTambahan.equals("1")){
                    layananTambahan2[jmlLayananTambahan] = "Catering";
                    jmlLayananTambahan++;
                    cateringBoolean = true;
                    do {
                        System.out.print("1. Paket A: makan    makan   makan \n2. Paket B: makan2    makan2    makan2\n3. Paket C: Makan3  makan3\nPilih nomor untuk paket catering: ");
                        pilihanMenu = input.next();
                            switch (pilihanMenu) {
                                case "1" : menu [k] = "makan    makan   makan";
                                    k++;
                                    break;
                                case "2" : menu [k] = "makan2   makan2    makan2";
                                    k++;
                                    break;
                                case "3" : menu [k] = "Makan3  makan3";
                                    k++;
                                    break;
                                default:
                                    break;
                            }
                        System.out.print("Apakah anda mau menambah paket lagi? (y/t): ");
                        confirmCatering = input.next();
                        l++;
                    }while (confirmCatering.equalsIgnoreCase("y"));
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
                System.out.println("         Layanan Tambahan\t\t: " );
                while (i < jmlLayananTambahan){
                    System.out.println("         " + j + "." + " " + layananTambahan2[i] );
                    i++;
                    j++;
                }
                if (cateringBoolean = true){
                    System.out.println("         Pesanan Catering: ");
                    for (int m = 0 ; m < l ; m++){
                        System.out.println("          - " + menu [m]);
                    } 
                }
                
                System.out.println("         Nomor Telepon\t\t\t: " + nomorTelepon);
                System.out.println("         Alamat Email\t\t\t: " + alamatEmail);
                System.out.println("=======================================================================");
            } else {
                System.out.println("Maaf, Pemesanan yang anda minta tidak dapat kami proses. Silahkan coba lagi nanti.");
            
            }return;
                
            }
        //Acara rapat
        else if (acara.equalsIgnoreCase("rapat")){
            System.out.print("Tanggal Pelaksanaan Acara: ");
            input.nextLine();
            tanggalPelaksanaanRapat = input.nextLine();

            System.out.print ("Jumlah Tamu Undangan:\n Gedung Aa = 10 - 20\n Gedung Bb = 20 - 30\n Gedung Cc = 30 - 50\n Masukkan Jumlah Tamu :  ");
            jumlahTamu = input.nextInt();

            if (jumlahTamu <= 20){
                System.out.println("Anda akan menggunakan Gedung Aa");
            }else if (20 <= jumlahTamu && jumlahTamu <= 30){
                System.out.println("Anda akan menggunakan Gedung Bb");
            }else if (30 <= jumlahTamu && jumlahTamu <= 50 ){
                System.out.println("Anda akan menggunakan Gedung Cc");
            }else{
                System.out.println("Jumlah tamu melebihi daya tampung gedung kami");
            }

            System.out.print("Masukkan Nomor Telepon : ");
            nomorTelepon = input.next();
            
            System.out.print("Masukkan Alamat Email  : ");
            alamatEmail = input.next();
            
            while (!(jumlahTamu <= 50)){
                System.out.println("Tamu undangan anda melebihi kapasitas");
                System.out.println("Silahkan coba lagi");
                System.out.print("Jumlah Tamu Undangan:\n Gedung Aa = 10 - 20\n Gedung Bb = 20 - 30\n Gedung Cc = 30 - 50\n Masukkan Jumlah Tamu:  ");
                jumlahTamu = input.nextInt();
            }
            
            if (jumlahTamu <= 20) {
                jenisGedung = "Gedung Aa";
            }else if (20 <= jumlahTamu && jumlahTamu <= 30 ) {
                jenisGedung = "Gedung Bb";
            }else if (30 <= jumlahTamu && jumlahTamu <= 50){
                jenisGedung = "Gedung Cc";
            }else {
                jenisGedung = "Coba lagi";
            }

            //LAYANAN TAMBAHAN RAPAT
            String layananTambahanRapat [] = new String [4];
            System.out.println("Layanan Tambahan: ");
            System.out.println("1. Snack ");
            System.out.println("2. Minuman");
            System.out.println("3. LCD Proyektor");
            System.out.println("4. Kabel");
            char confirm;
            do {
                System.out.print("Pilih layanan tambahan anda: ");
                int pilihan = input.nextInt();
                switch (pilihan) {
                    case 1:
                    layananTambahanRapat[0] = "Snack";
                    break;
                    case 2:
                    layananTambahanRapat[1] = "Minuman";
                    case 3:
                    layananTambahanRapat[2] = "LCD Proyektor";
                    case 4:
                    layananTambahanRapat[3] = "Kabel";
                    default:
                    System.out.println("Pilihan layanan tambahan tidak dapat diproses");
                    break;
                }
                System.out.print("Layanan Tambahan yang Anda Pilih: " );
                for (String layanan : layananTambahanRapat) {
                    if (layanan != null) {
                        System.out.println(layanan);
                    }
                }
                System.out.println("Apakah Anda ingin Menambah Layanan Tambahan?");
                System.out.println("Y (untuk Ya)\nT (untuk Tidak) : ");
                confirm = input.next().charAt(0);
                
            } while (confirm == 'Y' || confirm == 'y');

            //NOTA PEMESANAN RAPAT
            boolean pemesananBerhasil = true;
            if (pemesananBerhasil){
                 System.out.println("\n=======================================================================");
                System.out.println("                          NOTA PEMESANAN                        ");
                System.out.println("         Nama Pemesan\t\t\t: " + identitasPemesan);
                System.out.println("         Nomor Handphone Pemesan\t: " + nomorTelepon);
                System.out.println("         Alamat Email Pemesan\t\t: " + alamatEmail);
                System.out.println("         Tanggal Pemesanan\t\t: " + tanggalPemesanan);
                System.out.println("         Tanggal Pelaksanaan Acara\t: " + tanggalPelaksanaanRapat);
                System.out.println("         Jumlah Tamu Undangan\t\t: " + jumlahTamu);
                System.out.println("         Jenis Gedung\t\t\t: " + jenisGedung);
                System.out.println("         Layanan Tambahan\t\t: " + Arrays.toString(layananTambahanRapat));
                System.out.println("         Nomor Telepon\t\t\t: " + nomorTelepon);
                System.out.println("         Alamat Email\t\t\t: " + alamatEmail);
                System.out.println("=======================================================================");
            } else {
                System.out.println("Maaf, Pemesanan yang anda minta tidak dapat kami proses. Silahkan coba lagi nanti.");
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
}

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class BookingGedung {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String layananTambahan2[] = new String[5];
        String[][] akun = {};
        String[][] password = {};
        LocalDateTime tanggalPemesanan = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattanggalPemesanan = tanggalPemesanan.format(format);

        //Penampilan awal
        PenampilanAwal();

        //lOGIN
        String backToMenu;
        do {
        boolean menuLogin = true;
        String pilihanLogin;
        System.out.println("====================");
        System.out.println("||   MENU LOGIN   ||");
        System.out.println("====================");
        System.out.println("|| 1. Admin       ||");
        System.out.println("|| 2. Pelanggan   ||");
        System.out.println("====================");
        System.out.println("--------------------");
        System.out.println("Masukkan pilihan anda");
        System.out.println("--------------------");
        pilihanLogin = input.nextLine();

        if (pilihanLogin.equalsIgnoreCase("Admin")) {
            adminLogin(akun, password);
        } else if (pilihanLogin.equalsIgnoreCase("Pelanggan")) {
            menu(layananTambahan2, formattanggalPemesanan);;
        } else {
            System.out.println("Pilihan tidak valid. Silahkan pilih Admin atau Pelanggan.");
        }
        

        System.out.print("Apakah anda ingin kembali ke menu login? (y/t): ");
        backToMenu = input.nextLine();
            while (!backToMenu.equalsIgnoreCase("t") && !backToMenu.equalsIgnoreCase("y")) {
                System.out.println("INPUT YANG ANDA MASUKKAN TIDAK SESUAI\nSILAHKAN ULANGI ");
                System.out.print("Apakah anda ingin kembali ke menu login? (y/t): ");
                backToMenu = input.nextLine();
            }

        } while (!backToMenu.equalsIgnoreCase("t"));

        tampilanClosing();
    }
    
    // Admin ID and Password
    static String ADMIN_ID = "admin";
    static String ADMIN_PASSWORD = "admin123";

    static void adminLogin(String[][] akun, String[][] password) {
        Scanner input = new Scanner(System.in);
        boolean login = false;
        int attemptCount = 0;
        do {
            System.out.print("Masukkan ID Admin\t: ");
            String adminIdInput = input.nextLine();
            System.out.print("Masukkan Password Admin\t: ");
            String adminPasswordInput = input.nextLine();

            if (adminIdInput.equals(ADMIN_ID) && adminPasswordInput.equals(ADMIN_PASSWORD)) {
                login = true;
                System.out.println("=========================");
                System.out.println("|| Login Admin Berhasil ||");
                System.out.println("=========================");
                adminMenu(gedungNikah, ruangRapat, tanggalPelaksanaanAcara, tanggalPelaksanaanRapat);
            } else {
                System.out.println("ID Admin atau Password yang Anda masukkan salah!");
                attemptCount++;

                if (attemptCount >= 3) {
                    System.out.println("Anda sudah mencoba login sebanyak 3 kali. Aplikasi akan keluar.");
                    break;
                }
            }
        } while (!login);
    }

    //untuk mengecek apakah tempat tersedia
    static boolean[] gedungNikahAvailable = { true, true, true };
    static boolean[] ruangRapatAvailable = { true, true, true };
    static void displayAvailableVenues() {
        System.out.println("========== Gedung Tersedia ==========");

        for (int i = 0; i < gedungNikah.length; i++) {
            if (gedungNikahAvailable[i]) {
                System.out.println("Gedung " + (char) ('A' + i) + " Tersedia");
            } else {
                System.out.println("Gedung " + (char) ('A' + i) + " Sudah Dipesan untuk Tanggal " + tanggalPelaksanaanAcara[i]);
            }
        }

        for (int i = 0; i < ruangRapat.length; i++) {
            if (ruangRapatAvailable[i]) {
                System.out.println("Ruang " + (char) ('A' + i) + " Tersedia");
            } else {
                System.out.println("Ruang " + (char) ('A' + i) + " Sudah Dipesan untuk Tanggal " + tanggalPelaksanaanRapat[i]);
            }
        }

        System.out.println("===================================");
    }
   
    static int jumlahTamu;
    static String jenisRuang;
    static int HargaRuang;
    static String tanggalPelaksanaanAcara[] = new String[5];
    static String tanggalPelaksanaanRapat[] = new String[5];
    static String ruangRapat[] = new String[5];
    static String gedungNikah[] = new String[5];
    static String nomorTelepon, alamatEmail;
    static String jenisGedung;
    static Scanner input = new Scanner(System.in);

    static boolean isValidJumlahTamu ( int tamu){
        while (tamu > 400) {
            System.out.println("Tamu undangan anda melebihi kapasitas");
            System.out.println("Silahkan coba lagi");
            System.out.println("Jumlah Tamu Undangan: ");
            System.out.println("Gedung A = 100 - 200 ");
            System.out.println("Gedung B = 200 - 300 ");
            System.out.println("Gedung C = 300 - 400 ");
            System.out.print("Masukkan Jumlah Tamu: ");
            tamu = input.nextInt();
        }
        
        if (tamu <= 200) {
            jenisGedung = "Gedung A";
        } else if (200 <= tamu && tamu <= 300) {
            jenisGedung = "Gedung B";
        } else if (300 <= tamu && tamu <= 400) {
            jenisGedung = "Gedung C";
        } else {
            jenisGedung = "coba lagi";
        }
        
        return true;
        
    }
    //fungsi untuk pemesanan Rapat
    static int totalHargaRapat = 0;
    static int e = 0;
    static void pemesananRapat() {
        do{
            System.out.println("=======================================");
            System.out.println("|| Jumlah Tamu Undangan:             ||");
            System.out.println("|| Ruangan A = 10 - 20\t Rp. 500.000 ||");
            System.out.println("|| Ruangan B = 20 - 30\t Rp. 550.000 ||");
            System.out.println("|| Ruangan C = 30 - 50\t Rp. 600.000 ||");
            System.out.println("=======================================");
            System.out.print("Masukkan Jumlah Tamu :  ");
            jumlahTamu = input.nextInt();
            
            if (jumlahTamu <= 20) {
                System.out.println("Anda akan menggunakan Ruangan A");
                ruangRapat[e] = "Ruangan A";
            } else if (20 <= jumlahTamu && jumlahTamu <= 30) {
                System.out.println("Anda akan menggunakan Ruangan B");
                ruangRapat[e] = "Ruangan B";
            } else if (30 <= jumlahTamu && jumlahTamu <= 50) {
                System.out.println("Anda akan menggunakan Ruangan C");
                ruangRapat[e] = "Ruangan C";
            } else {
                System.out.println("Jumlah tamu melebihi daya tampung Ruangan kami");
            }
        } while (jumlahTamu > 50);
         
        while (!(jumlahTamu <= 50)) {
            System.out.println("Tamu undangan anda melebihi kapasitas");
            System.out.println("Silahkan coba lagi");
            System.out.print("Jumlah Tamu Undangan:\n Ruangan A = 10 - 20  ");
            System.out.print("Ruangan B = 20 - 30 ");
            System.out.print("Ruangan C = 30 - 50 ");
            System.out.print("Masukkan Jumlah Tamu  : ");
            jumlahTamu = input.nextInt();
        }
        
        
        if (jumlahTamu <= 20) {
            jenisRuang = "Ruangan A";
            HargaRuang = 500000;
            totalHargaRapat += HargaRuang;
        } else if (20 <= jumlahTamu && jumlahTamu <= 30) {
            jenisRuang = "Ruangan B";
            HargaRuang = 550000;
            totalHargaRapat += HargaRuang;
        } else if (30 <= jumlahTamu && jumlahTamu <= 50) {
            jenisRuang = "Ruangan C";
            HargaRuang = 600000;
            totalHargaRapat += HargaRuang;
        } else {
            jenisRuang = "Coba lagi";
        }
    }
    
    static int totalHargaPernikahan = 0;
    static int hargaGedung;
    static int a = 0;
    static int b = 0;
    static int c = 0;
    static int d = 0;
    static boolean tanggal = true;
    static void menu(String[] layananTambahan2,String formattanggalPemesanan){
        String identitasPemesan, layananTambahan, konfirmasi, acara, confirmMenu;
        do {
            System.out.println("========================");
            System.out.println("||   Menu Pelanggan   ||");
            System.out.println("========================");
            System.out.print("1. Cek Gedung yang tersedia\n2. Booking Gedung\n3. Reschedule Jadwal\n4. Exit\nMasukkan Angka dari menu: ");
            int pilihanmenu = input.nextInt();
            while (pilihanmenu > 4){
                System.out.println("INPUT YANG ANDA MASUKKAN TIDAK TERSEDIA DALAM MENU\nSILAHKAN ANDA ULANGI!!");
                System.out.print("Masukkan angka dari menu kembali: ");
                pilihanmenu = input.nextInt();
            }
            //INPUT
            
            input.nextLine();
            if (pilihanmenu == 2) {
                System.out.print("Masukkan Nama Pemesan\t: ");
                identitasPemesan = input.nextLine();
                System.out.print("Acara yang akan digelar (pernikahan / rapat) : ");
                acara = input.nextLine();
                while (!(acara.equalsIgnoreCase("pernikahan")) && !(acara.equalsIgnoreCase("rapat"))){
                    System.out.println("input yang anda masukkan error, silahkan coba lagi");
                    System.out.print("Acara yang akan digelar (pernikahan / rapat) : ");
                    acara = input.nextLine();
                }
                //Acara pernikahan
                if (acara.equalsIgnoreCase("pernikahan")) {
                    do {
                        System.out.print("Tanggal Pelaksanaan Acara : ");
                        tanggalPelaksanaanAcara[a] = input.nextLine();
                        do {
                            System.out.println("=================================================");
                            System.out.println("|| Jumlah Tamu Undangan :\t\t       ||");
                            System.out.println("|| Gedung A = 100 - 200 \t Rp. 1.000.000 ||");
                            System.out.println("|| Gedung B = 200 - 300 \t Rp. 1.500.000 ||");
                            System.out.println("|| Gedung C = 300 - 400 \t Rp. 2.000.000 ||");
                            System.out.println("=================================================");
                            System.out.print("Masukkan Jumlah Tamu : ");
                            jumlahTamu = input.nextInt();
                            
                            if (jumlahTamu <= 200) {
                                System.out.println("Anda akan menggunakan Gedung A");
                                gedungNikah[c] = "Gedung A";
                                hargaGedung = 1000000;
                                totalHargaPernikahan += hargaGedung;
                            } else if (200 <= jumlahTamu && jumlahTamu <= 300) {
                                System.out.println("Anda akan menggunakan Gedung B");
                                gedungNikah[c] = "Gedung B";
                                hargaGedung = 1500000;
                                totalHargaPernikahan += hargaGedung;
                            } else if (300 <= jumlahTamu && jumlahTamu <= 400) {
                                System.out.println("Anda akan menggunakan Gedung C");
                                gedungNikah[c] = "Gedung C";
                                hargaGedung = 2000000;
                                totalHargaPernikahan += hargaGedung;
                            } else {
                                System.out.println("Pemesanan Anda Melebihi Kapasitas Gedung");
                            }
                        } while (jumlahTamu > 400);
                        if (a >= 1){
                            int i = 0;
                            for ( ; i < a ; i++){
                                if (tanggalPelaksanaanAcara [a].equalsIgnoreCase(tanggalPelaksanaanAcara[i]) && gedungNikah [a].equalsIgnoreCase(gedungNikah [i])){
                                        System.out.println(gedungNikah [a] + " sudah dipesan untuk tanggal " + tanggalPelaksanaanAcara [a]);
                                        System.out.println("SILAHKAN COBA LAGI");
                                        tanggal = false;
                                }else {
                                    tanggal = true;
                                }

                            }
                        }
                        input.nextLine(); 
                        } while (tanggal == false);
                    c++;
                    a++;

                    System.out.print("Masukkan Nomor Telepon : ");
                    nomorTelepon = input.nextLine();

                    System.out.print("Masukkan Alamat Email  : ");
                    alamatEmail = input.nextLine();


                    String pilihanMenu, confirmCatering;
                    String menu[] = new String[3];
                    int k = 0, l = 0;
                    boolean cateringBoolean = false;
                    int jmlLayananTambahan = 0;
                    int hargaLayananTambahan [] = new int [5];
                    int hargaCatering [] = new int [3];
                    int jumlahPaketCatering[] = new int [3];
                    int m = 0;
                    int hargaPaket [] = new int[3];
                    int LayananTambahan [] = new int[4];
                    int n = 0;
                    int r = 0;
                    do {
                        System.out.println("==========================================================");
                        System.out.println("|| Layanan Tambahan :                                   ||");
                        System.out.println("|| 1. Catering                                          ||");
                        System.out.println("|| 2. MC\t\t\t\t Rp. 800.000    ||");
                        System.out.println("|| 3. Photography + Video Graphy\t Rp. 3.000.000  ||");
                        System.out.println("|| 4. Dekorasi\t\t\t\t Rp. 10.000.000 ||");
                        System.out.println("|| 5. Musik dan Hiburan\t\t\t Rp. 5.000.000  ||");
                        System.out.println("==========================================================");
                        System.out.print("Masukkan nomor layanan tambahan yang anda pilih : ");
                        layananTambahan = input.nextLine();

                        if (layananTambahan.equals("1")) {
                            layananTambahan2[jmlLayananTambahan] = "Catering";
                            jmlLayananTambahan++;
                            cateringBoolean = true;
                            do {
                                menuCatering();
                                System.out.print("Pilih nomor untuk paket catering: ");
                                pilihanMenu = input.nextLine();
                                switch (pilihanMenu) {
                                    case "1":
                                        menu[k] = "Nasi Putih, Gurami telor Asin, Soup sosis, Pudding Coklat, Air Mineral ";
                                        k++;
                                        System.out.print("Masukkan jumlah pesanan untuk paket 1: ");
                                        jumlahPaketCatering [m] = input.nextInt();
                                        hargaPaket [n] = 50000;
                                        totalHargaPernikahan += hargaPaket [n] * jumlahPaketCatering [m]; 
                                        m++;
                                        n++;
                                        input.nextLine();
                                        break;
                                    case "2":
                                        menu[k] = "Nasi Putih, Ayam Bakar, Tumis Kangkung, Soft Drink, Air Mineral ";
                                        System.out.print("Masukkan jumlah pesanan untuk paket 2: ");
                                        jumlahPaketCatering [m] = input.nextInt();
                                        hargaPaket [n] = 40000;
                                        totalHargaPernikahan += hargaPaket [n] * jumlahPaketCatering [m];
                                        m++;
                                        n++;
                                        k++;
                                        input.nextLine();
                                        break;
                                    case "3":
                                        menu[k] = "Nasi Putih, Ayam Teriyaki, Air Mineral ";
                                        System.out.print("Masukkan jumlah pesanan untuk paket 3: ");
                                        jumlahPaketCatering [m] = input.nextInt();
                                        hargaPaket [n] = 30000;
                                        totalHargaPernikahan += hargaPaket [n];
                                        m++;
                                        n++;
                                        k++;
                                        input.nextLine();
                                        break;
                                    default:
                                        break;
                                }
                                System.out.print("Apakah anda mau menambah paket lagi? (y/t): ");
                                confirmCatering = input.nextLine();
                                l++;
                            } while (confirmCatering.equalsIgnoreCase("y"));

                        }
                        if (layananTambahan.equals("2")) {
                            layananTambahan2[jmlLayananTambahan] = "MC";
                            jmlLayananTambahan++;
                            LayananTambahan [r] = 800000;
                            totalHargaPernikahan += LayananTambahan [r];
                            r++;

                        }
                        if (layananTambahan.equals("3")) {
                            layananTambahan2[jmlLayananTambahan] = "Photography + Video Graphy";
                            jmlLayananTambahan++;
                            LayananTambahan [r] = 3000000;
                            totalHargaPernikahan += LayananTambahan [r];
                            r++;

                        }
                        if (layananTambahan.equals("4")) {
                            layananTambahan2[jmlLayananTambahan] = "Dekorasi";
                            jmlLayananTambahan++;
                            LayananTambahan [r] = 10000000;
                            totalHargaPernikahan += LayananTambahan [r];
                            r++;
                        }
                        if (layananTambahan.equals("5")) {
                            layananTambahan2[jmlLayananTambahan] = "Musik dan Hiburan";
                            jmlLayananTambahan++;
                            LayananTambahan [r] = 5000000;
                            totalHargaPernikahan += LayananTambahan [r];
                            r++;
                        }
                        System.out.print("Apakah Ingin Menambah Layanan Tambahan?\n(y) untuk iya\n(t) untuk tidak : ");
                        konfirmasi = input.nextLine();
                    } while (konfirmasi.equalsIgnoreCase("y"));


                    boolean pemesananBerhasil = true;
                    //OUTPUTTTT
                    isValidJumlahTamu(jumlahTamu);
                    if (pemesananBerhasil) {
                        System.out.println("\n=================================================================================");
                        System.out.println("                            NOTA PEMESANAN                        ");
                        System.out.println("           Nama Pemesan\t\t\t: " + identitasPemesan);
                        System.out.println("           Nomor Handphone Pemesan\t: " + nomorTelepon);
                        System.out.println("           Alamat Email Pemesan\t\t: " + alamatEmail);
                        System.out.println("           Tanggal Pemesanan\t\t: " + formattanggalPemesanan);
                        System.out.println("           Tanggal Pelaksanaan Acara\t: " + tanggalPelaksanaanAcara[a - 1]);
                        System.out.println("           Jumlah Tamu Undangan\t\t: " + jumlahTamu);
                        System.out.println("           Jenis Gedung\t\t\t: " + jenisGedung  + "\t = Rp. " + hargaGedung);

                        int i = 0, j = 1, b = 0;
                        System.out.println("\t   Layanan Tambahan\t\t: ");
                        while (i < jmlLayananTambahan) {
                            System.out.println("\t     " + j + "." + " " + layananTambahan2[i]);
                            if (!(layananTambahan2[i].equalsIgnoreCase("catering"))) {
                                for ( ; b < i ; b++ ){
                                System.out.println("\t     Rp. " + LayananTambahan [b]);
                            }
                            }
                            i++;
                            j++;
                        }
                        if (cateringBoolean = true) {
                            System.out.println("\t     Pesanan Catering: ");
                            int o = 0;
                            int p = 0;
                            int q = 0;
                            for (  ; o < l; o++) {
                                System.out.print("     - " + menu[o]);
                                for ( ; p <= o ; p++){
                                    System.out.print(" = " + jumlahPaketCatering[p]);
                                }
                                for (; q <= o ; q++){
                                    System.out.print(" = Rp. " + hargaPaket [q]);
                                }
                                System.out.println();
                            }
                            
                        }

                        System.out.println("           Nomor Telepon\t\t: " + nomorTelepon);
                        System.out.println("           Alamat Email\t\t\t: " + alamatEmail);
                        System.out.println("           Biaya total = " + " Rp. " + totalHargaPernikahan);
                        System.out.println("=================================================================================");
                    } else {
                        System.out.println("Maaf, Pemesanan yang anda minta tidak dapat kami proses. Silahkan coba lagi nanti.");

                    }
                    //tampilanClosing();

                    //Acara rapat
                } else if (acara.equalsIgnoreCase("rapat")) {
                    do{
                        System.out.print("Tanggal Pelaksanaan Acara: ");
                        tanggalPelaksanaanRapat[b] = input.nextLine();
                        pemesananRapat();
                        int f = 0;
                        if (b >= 1){
                            for ( ; f < b ; f++){
                                if (tanggalPelaksanaanRapat [b].equalsIgnoreCase(tanggalPelaksanaanRapat[f]) && ruangRapat [e].equalsIgnoreCase(ruangRapat[f])){
                                    System.out.println(ruangRapat [e] + " sudah di pesan untuk tanggal " + tanggalPelaksanaanRapat [e]);
                                    System.out.println("SILAHKAN COBA LAGI");
                                    tanggal = false;
                                }else {
                                    tanggal = true;
                                }
                            }
                        }
                    input.nextLine();    
                    } while (tanggal == false);
                    b++;
                    e++;
                    System.out.print("Masukkan Nomor Telepon : ");
                    nomorTelepon = input.nextLine();
        
                    System.out.print("Masukkan Alamat Email  : ");
                    alamatEmail = input.nextLine();
                    //LAYANAN TAMBAHAN RAPAT
                    String layananTambahanRapat[] = new String[4];
                    String confirm;
                    int g = 0;
                    int h = 0;
                    int hargaLayananTambahanRapat[] = new int [4];
                    int totalHargaSnack = 0;
                    int jumlahSnack;
                    int jumlahKursi;
                 
            
                    do {
                        System.out.println("Layanan Tambahan: ");
                        System.out.println("1. Snack & Minuman\t Rp. 20.000");
                        System.out.println("2. Sound System\t\t Rp. 500.000 ");
                        System.out.println("3. LCD Proyektor\t Rp. 100.000");
                        System.out.println("4. Kursi Tambahan\t Rp. 0");
                        System.out.print("Pilih layanan tambahan anda : ");
                        int pilihan = input.nextInt();
                        switch (pilihan) {
                            case 1:
                                layananTambahanRapat[g] = "Snack & Minuman";
                                hargaLayananTambahanRapat[h] = 20000;
                                System.out.print("Masukkan jumlah pesanan : ");
                                jumlahSnack = input.nextInt();
                                hargaLayananTambahanRapat[h] *= jumlahSnack;
                                layananTambahanRapat[g] = "Snack & Minuman = " + jumlahSnack;
                                totalHargaRapat += hargaLayananTambahanRapat[h];
                                h++;
                                g++;
                                input.nextLine();
                                break;
                            case 2:
                                layananTambahanRapat[g] = "Sound System";
                                hargaLayananTambahanRapat[h] = 500000;
                                totalHargaRapat += 500000;
                                h++;
                                g++;
                                input.nextLine();
                                break;
                            case 3:
                                layananTambahanRapat[g] = "LCD Proyektor";
                                hargaLayananTambahanRapat[h] = 100000;
                                totalHargaRapat += 100000;
                                h++;
                                g++;
                                input.nextLine();
                                break;
                            case 4:
                                layananTambahanRapat[g] = "Kursi";
                                hargaLayananTambahanRapat[h] = 0;
                                System.out.print("Masukkan jumlah kursi tambahan : ");
                                jumlahKursi = input.nextInt();
                                layananTambahanRapat[g] = "Kursi =  " + jumlahKursi;
                                totalHargaRapat += 0;
                                h++;
                                g++;
                                input.nextLine();
                                break;

                            default:
                                System.out.println("Pilihan layanan tambahan tidak dapat diproses");
                                break;
                        
                        }
                        System.out.println("Layanan Tambahan yang Anda Pilih: ");
                        for (String layanan : layananTambahanRapat) {
                            if (layanan != null) {
                                System.out.println(layanan);
                            }
                        }
                        System.out.println("Apakah Anda ingin Menambah Layanan Tambahan?");
                        System.out.print("Y (untuk Ya)\nT (untuk Tidak) : ");
                        confirm = input.nextLine();

                    } while (confirm.equalsIgnoreCase("y"));

                    //NOTA PEMESANAN RAPATT
                    boolean pemesananBerhasil = true;
                    if (pemesananBerhasil) {
                        System.out.println("\n=======================================================================");
                        System.out.println("                          NOTA PEMESANAN                        ");
                        System.out.println("         Nama Pemesan\t\t\t: " + identitasPemesan);
                        System.out.println("         Nomor Handphone Pemesan\t: " + nomorTelepon);
                        System.out.println("         Alamat Email Pemesan\t\t: " + alamatEmail);
                        System.out.println("         Tanggal Pemesanan\t\t: " + formattanggalPemesanan);
                        System.out.println("         Tanggal Pelaksanaan Acara\t: " + tanggalPelaksanaanRapat[b - 1]);
                        System.out.println("         Jumlah Tamu Undangan\t\t: " + jumlahTamu);
                        System.out.println("         Jenis Ruangan\t\t\t: " + jenisRuang + " : " + HargaRuang);
                        System.out.println("\t Layanan Tambahan\t\t: ");
                        int i = 0;
                        int x = 0;
                        for (; i < g; i++) {
                            System.out.println("\t   " + (i + 1) + ". " + layananTambahanRapat[i]);
                            for (; x <= i ; x++ ){
                                System.out.print("\t   Harga  = " +  " " + " Rp. " + hargaLayananTambahanRapat[x]);
                            }
                            System.out.println();
                        }
                        System.out.println("         Nomor Telepon\t\t\t: " + nomorTelepon);
                        System.out.println("         Alamat Email\t\t\t: " + alamatEmail);
                        System.out.println("        Total Biaya : " + totalHargaRapat);
                        System.out.println("=======================================================================");
                    } else {
                        System.out.println("Maaf, Pemesanan yang anda minta tidak dapat kami proses. Silahkan coba lagi nanti.");
                    }
                    

                    //tampilanClosing();
                    //CLOSING SCANNER

                }
            }else if (pilihanmenu == 1) {
                for (int i = 0; i < gedungNikah.length; i++) {
                    if (gedungNikah[i] != null) {
                        System.out.println(gedungNikah[i] + " SUDAH DIPESAN UNTUK TANGGAL " + tanggalPelaksanaanAcara[i]);
                    }
                    if (ruangRapat[i] != null) {
                        System.out.println(ruangRapat[i] + " SUDAH DIPESAN UNTUK TANGGAL " + tanggalPelaksanaanRapat[i]);
                    }
                }
                if (gedungNikah[0] == null && gedungNikah[1] == null && gedungNikah[2] == null && gedungNikah [3] == null && gedungNikah [4] == null) {
                    System.out.println("SEMUA GEDUNG UNTUK PERNIKAHAN KOSONG");
                }
                if (ruangRapat[0] == null && ruangRapat[1] == null && ruangRapat[2] == null && ruangRapat [3] == null && ruangRapat [4] == null) {
                    System.out.println("SEMUA RUANGAN UNTUK RAPAT KOSONG");
                }
            }else if (pilihanmenu == 3){
                reschedulingJadwal(tanggalPelaksanaanAcara, tanggalPelaksanaanRapat);
            }else if (pilihanmenu == 4){
                return;
            }
            System.out.print("Apakah anda ingin kembali ke menu? (y/t): ");
            confirmMenu = input.nextLine();
        } while (confirmMenu.equalsIgnoreCase("y"));
    }
    //Display Admin Menu
    static void adminMenu(String [] gedungNikah, String[] ruangRapat, String[] tanggalPelaksanaanAcara, String[] tanggalPelaksanaanRapat) {
        Scanner input = new Scanner(System.in);
        String confirmMenu;

        do {
            System.out.println("====================");
            System.out.println("||   Menu Admin   ||");
            System.out.println("====================");
            System.out.print("1. Lihat Gedung yang Terpesan\n2. Laporan Harian\n3. Laporan Bulanan\n4. Keluar\nMasukkan Angka dari menu: ");
            int pilihanmenu = input.nextInt();
            while (pilihanmenu > 4) {
                System.out.println("INPUT YANG ANDA MASUKKAN SALAH\nSILAHKAN ULANGI LAGI!!");
                System.out.print("Masukkan angka kembali: ");
                pilihanmenu = input.nextInt();
            }

            if (pilihanmenu == 1) {
                displayBookedVenues(gedungNikah, ruangRapat, tanggalPelaksanaanAcara, tanggalPelaksanaanRapat);
            } else if (pilihanmenu == 2) {
                laporanHarian(gedungNikah, ruangRapat, tanggalPelaksanaanAcara, tanggalPelaksanaanRapat);
            } else if (pilihanmenu == 3){
                laporanBulanan(gedungNikah, ruangRapat, tanggalPelaksanaanAcara, tanggalPelaksanaanRapat);
            } else if (pilihanmenu == 4) {
                System.out.println("Keluar dari menu admin");
                break;
            }

            System.out.print("Apakah anda ingin kembali ke menu? (y/t): ");
            input.nextLine();
            confirmMenu = input.nextLine();
            while (!confirmMenu.equalsIgnoreCase("y") && !confirmMenu.equalsIgnoreCase("t")){
                System.out.println("INPUT YANG ANDA MASUKKAN TIDAK SESUAI\nSILAHKAN ANDA ULANGI!!");
                System.out.print("Apakah anda ingin kembali ke menu? (y/t): ");
                input.nextLine();
            }
        } while (confirmMenu.equalsIgnoreCase("y"));
    }
    //display tempat yang dipesan
    static void displayBookedVenues(String [] gedungNikah, String [] ruangRapat, String [] tanggalPelaksanaanAcara, String [] tanggalPelaksanaanRapat) {
        System.out.println("========== Booked Venues ==========");

        for (int i = 0; i < gedungNikah.length; i++) {
            if (gedungNikah[i] != null) {
                System.out.println(gedungNikah[i] + " SUDAH DIPESAN UNTUK TANGGAL " + tanggalPelaksanaanAcara[i]);
            }
        }

        for (int i = 0; i < ruangRapat.length; i++) {
            if (ruangRapat[i] != null) {
                System.out.println(ruangRapat[i] + " SUDAH DIPESAN UNTUK TANGGAL " + tanggalPelaksanaanRapat[i]);
            }
        }

        System.out.println("===================================");

    }
     // laporan harian
     public static void laporanHarian(String [] gedungNikah, String [] ruangRapat, String [] tanggalPelaksanaanAcara, String [] tanggalPelaksanaanRapat) {
        System.out.println("==========================================");
        System.out.println("Laporan Harian Gedung Nikah & Ruang Rapat");
        System.out.println("==========================================");

        int jumlahGedungNikahterpakai = 0;
        int jumlahRuangRapatterpakai = 0;

        for (int i = 0; i < gedungNikah.length; i++) {
            if (gedungNikah[i] != null) {
                System.out.println(gedungNikah[i] + " SUDAH DIPESAN PADA TANGGAL " + tanggalPelaksanaanAcara[i]);
                jumlahGedungNikahterpakai++;
            }
        }

        for (int i = 0; i < ruangRapat.length; i++) {
            if (ruangRapat[i] != null) {
                System.out.println(ruangRapat[i] + " SUDAH DIPESAN PADA TANGGAL " + tanggalPelaksanaanRapat[i]);
                jumlahRuangRapatterpakai++;
            }
        }

        System.out.println("Total gedung nikah yang dipesan: " + jumlahGedungNikahterpakai);
        System.out.println("Total ruang rapat yang dipesan: " + jumlahRuangRapatterpakai);
        System.out.println("===========================================");
    }

    // laporan bulanan
    public static void laporanBulanan(String [] gedungNikah, String [] ruangRapat, String [] tanggalPelaksanaanAcara, String [] tanggalPelaksanaanRapat) {
        System.out.println("===========================================");
        System.out.println("Laporan Bulanan Gedung Nikah & Ruang Rapat");
        System.out.println("===========================================");

        int jumlahGedungNikahterpakai = 0;
        int jumlahRuangRapatterpakai = 0;

        for (int i = 0; i < gedungNikah.length; i++) {
            if (gedungNikah[i] != null ) {
                System.out.println(gedungNikah[i] + " SUDAH DIPESAN PADA TANGGAL " + tanggalPelaksanaanAcara[i]);
                jumlahGedungNikahterpakai++;
            }
        }

        for (int i = 0; i < ruangRapat.length; i++) {
            if (ruangRapat[i] != null ) {
                System.out.println(ruangRapat[i] + " SUDAH DIPESAN PADA TANGGAL  " + tanggalPelaksanaanRapat[i]);
                jumlahRuangRapatterpakai++;
            }
        }

        System.out.println("Total gedung nikah yang dipesan bulan ini: " + jumlahGedungNikahterpakai);
        System.out.println("Total ruang rapat yang dipesan bulan ini: " + jumlahRuangRapatterpakai);
        System.out.println("===========================================");
    }

    static String reschedulingJadwal (String tanggalPelaksanaanAcara[], String tanggalPelaksanaanRapat[]){
        String tanggalSebelum;
        String tanggalBaru = " ";
        System.out.print("Masukkan acara yang akan di reschedule (pernikahan/rapat): ");
        String acara = input.nextLine();
        if (acara.equalsIgnoreCase("pernikahan")){
            System.out.print("Tanggal pelaksanaan acara sebelumnya: ");
            tanggalSebelum = input.nextLine();
            for (int i = 0 ; i < a ; i++){
                if (tanggalPelaksanaanAcara [i].equals(tanggalSebelum)){
                    System.out.print("Masukkan tanggal untuk perubahan jadwal: ");
                    tanggalBaru = input.nextLine();
                    tanggalPelaksanaanAcara [i] = tanggalBaru;
                }
            }
        }else if (acara.equalsIgnoreCase("rapat")){
            System.out.print("Tanggal pelaksanaan acara sebelumnya: ");
            tanggalSebelum = input.nextLine();
            for (int i = 0 ; i < b ; i++){
                if (tanggalPelaksanaanRapat [i].equals(tanggalSebelum)){
                    System.out.print("Masukkan tanggal untuk perubahan jadwal: ");
                    tanggalBaru = input.nextLine();
                    tanggalPelaksanaanRapat [i] = tanggalBaru;
                }
            }
        }
        return tanggalBaru;
    }
    //fungsi tampilan awal
    static void PenampilanAwal(){
        System.out.println("===================================================================");
        System.out.println("||                                                               ||");
        System.out.println("||                       SELAMAT DATANG                          ||");
        System.out.println("||                      DI HOTEL DE'LOBBY                        ||");
        System.out.println("||                                                               ||");
        System.out.println("===================================================================");
    }
    //fungsi tampilan Closing
    static void tampilanClosing() {
        System.out.println("\n===================================================================");
        System.out.println("||                                                               ||");
        System.out.println("||                        TERIMAKASIH                            ||");
        System.out.println("||                   SUDAH MEMESAN LAYANAN KAMI                  ||");
        System.out.println("||                                                               ||");
        System.out.println("===================================================================");

    }
    //fungsi menu catering
    static void menuCatering() {
        System.out.println("=========================================================================================================");
        System.out.println("||  1. Paket A: Nasi Putih, Gurami Telor Asin, Soup sosis, Pudding Coklat, Air Mineral\t Rp. 50.000\t||");
        System.out.println("||  2. Paket B: Nasi Putih, Ayam Bakar, Tumis Kangkung, Soft Drink, Air Mineral\t\t Rp. 40.000\t||");
        System.out.println("||  3. Paket C: Nasi Putih, Ayam Teriyaki, Air Mineral\t\t\t\t\t Rp. 30.000\t||");
        System.out.println("=========================================================================================================");
    }
}
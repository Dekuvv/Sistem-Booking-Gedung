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


        } while (backToMenu.equalsIgnoreCase("y"));

        tampilanClosing();
    }
    
    // Admin ID and Password
    static final String ADMIN_ID = "admin";
    static final String ADMIN_PASSWORD = "admin123";

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
                    System.exit(0);
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
    static String tanggalPelaksanaanAcara[] = new String[5];
    static String tanggalPelaksanaanRapat[] = new String[5];
    static String ruangRapat[] = new String[5];
    static String gedungNikah[] = new String[5];
    static String nomorTelepon, alamatEmail;
    static String jenisGedung;
    static Scanner input = new Scanner(System.in);

    private static boolean isValidJumlahTamu ( int tamu){
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
    static void pemesananRapat() {

        System.out.println("Jumlah Tamu Undangan: ");
        System.out.println("Ruangan A = 10 - 20 ");
        System.out.println("Ruangan B = 20 - 30 ");
        System.out.println("Ruangan C = 30 - 50 ");
        System.out.print("Masukkan Jumlah Tamu :  ");
        jumlahTamu = input.nextInt();

        if (jumlahTamu <= 20) {
            System.out.println("Anda akan menggunakan Ruangan A");
            ruangRapat[0] = "Ruangan A";
        } else if (20 <= jumlahTamu && jumlahTamu <= 30) {
            System.out.println("Anda akan menggunakan Ruangan B");
            ruangRapat[1] = "Ruangan B";
        } else if (30 <= jumlahTamu && jumlahTamu <= 50) {
            System.out.println("Anda akan menggunakan Ruangan C");
            ruangRapat[2] = "Ruangan C";
        } else {
            System.out.println("Jumlah tamu melebihi daya tampung Ruangan kami");
        }

        System.out.print("Masukkan Nomor Telepon : ");
        nomorTelepon = input.next();

        System.out.print("Masukkan Alamat Email  : ");
        alamatEmail = input.next();

        while (!(jumlahTamu <= 50)) {
            System.out.println("Tamu undangan anda melebihi kapasitas");
            System.out.println("Silahkan coba lagi");
            System.out.print("Jumlah Tamu Undangan:\n Ruangan A = 10 - 20  ");
            System.out.print("Ruangan B = 20 - 30  ");
            System.out.print("Ruangan C = 30 - 50  ");
            System.out.print("Masukkan Jumlah Tamu  : ");
            jumlahTamu = input.nextInt();
        }

        if (jumlahTamu <= 20) {
            jenisRuang = "Ruangan A";
        } else if (20 <= jumlahTamu && jumlahTamu <= 30) {
            jenisRuang = "Ruangan B";
        } else if (30 <= jumlahTamu && jumlahTamu <= 50) {
            jenisRuang = "Ruangan C";
        } else {
            jenisRuang = "Coba lagi";
        }
    }

    private static void menu(String[] layananTambahan2,String formattanggalPemesanan){
        String identitasPemesan, layananTambahan, konfirmasi, acara, confirmMenu;
        do {
            System.out.println("========================");
            System.out.println("||   Menu Pelanggan   ||");
            System.out.println("========================");
            System.out.print("1. Cek Gedung yang tersedia\n2. Booking Gedung\n3. Exit\nMasukkan Angka dari menu: ");
            int pilihanmenu = input.nextInt();
            //INPUT

            if (pilihanmenu == 2) {
                System.out.print("Masukkan Nama Pemesan\t: ");
                input.nextLine();
                identitasPemesan = input.nextLine();

                System.out.print("Acara yang akan digelar (pernikahan / rapat) : ");
                acara = input.next();
                //Acara pernikahan
                if (acara.equalsIgnoreCase("pernikahan")) {

                    System.out.print("Tanggal Pelaksanaan Acara : ");
                    input.nextLine();
                    int a = 0;
                    tanggalPelaksanaanAcara[a] = input.nextLine();
                    a++;

                    System.out.println("Jumlah Tamu Undangan :  ");
                    System.out.println("Gedung A = 100 - 200 ");
                    System.out.println("Gedung B = 200 - 300 ");
                    System.out.println("Gedung C = 300 - 400 ");
                    System.out.print("Masukkan Jumlah Tamu : ");
                    jumlahTamu = input.nextInt();

                    if (jumlahTamu <= 200) {
                        System.out.println("Anda akan menggunakan Gedung A");
                        gedungNikah[0] = "Gedung A";
                    } else if (200 <= jumlahTamu && jumlahTamu <= 300) {
                        System.out.println("Anda akan menggunakan Gedung B");
                        gedungNikah[1] = "Gedung B";
                    } else if (300 <= jumlahTamu && jumlahTamu <= 400) {
                        System.out.println("Anda akan menggunakan Gedung C");
                        gedungNikah[2] = "Gedung C";
                    } else {
                        System.out.println("Pemesanan Anda Melebihi Kapasitas Gedung");
                    }

                    System.out.print("Masukkan Nomor Telepon : ");
                    nomorTelepon = input.next();

                    System.out.print("Masukkan Alamat Email  : ");
                    alamatEmail = input.next();


                    String pilihanMenu, confirmCatering;
                    String menu[] = new String[3];
                    int k = 0, l = 0;
                    boolean cateringBoolean = false;
                    int jmlLayananTambahan = 0;

                    do {
                        System.out.println("Layanan Tambahan : ");
                        System.out.println("1. Catering");
                        System.out.println("2. MC");
                        System.out.println("3. Photography + Video Graphy");
                        System.out.println("4. Dekorasi");
                        System.out.println("5. Musik dan Hiburan");
                        System.out.print("Masukkan nomor layanan tambahan yang anda pilih : ");
                        layananTambahan = input.next();

                        if (layananTambahan.equals("1")) {
                            layananTambahan2[jmlLayananTambahan] = "Catering";
                            jmlLayananTambahan++;
                            cateringBoolean = true;
                            do {
                                menuCatering();
                                System.out.print("Pilih nomor untuk paket catering: ");
                                pilihanMenu = input.next();
                                switch (pilihanMenu) {
                                    case "1":
                                        menu[k] = "Nasi Putih, Gurami telor Asin, Soup sosis, Pudding Coklat, Air Mineral ";
                                        k++;
                                        break;
                                    case "2":
                                        menu[k] = "Nasi Putih, Ayam Bakar, Tumis Kangkung, Soft Drink, Air Mineral";
                                        k++;
                                        break;
                                    case "3":
                                        menu[k] = "Nasi Putih, Ayam Teriyaki, Air Mineral";
                                        k++;
                                        break;
                                    default:
                                        break;
                                }
                                System.out.print("Apakah anda mau menambah paket lagi? (y/t): ");
                                confirmCatering = input.next();
                                l++;
                            } while (confirmCatering.equalsIgnoreCase("y"));

                        }
                        if (layananTambahan.equals("2")) {
                            layananTambahan2[jmlLayananTambahan] = "MC";
                            jmlLayananTambahan++;
                        }
                        if (layananTambahan.equals("3")) {
                            layananTambahan2[jmlLayananTambahan] = "Photography + Video Graphy";
                            jmlLayananTambahan++;
                        }
                        if (layananTambahan.equals("4")) {
                            layananTambahan2[jmlLayananTambahan] = "Dekorasi";
                            jmlLayananTambahan++;
                        }
                        if (layananTambahan.equals("5")) {
                            layananTambahan2[jmlLayananTambahan] = "Musik dan Hiburan";
                            jmlLayananTambahan++;
                        }
                        System.out.print("Apakah Ingin Menambah Layanan Tambahan?\n(y) untuk iya\n(t) untuk tidak : ");
                        konfirmasi = input.next();
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
                        System.out.println("           Jenis Gedung\t\t\t: " + jenisGedung);

                        int i = 0, j = 1;
                        System.out.println("\t   Layanan Tambahan\t\t: ");
                        while (i < jmlLayananTambahan) {
                            System.out.println("\t     " + j + "." + " " + layananTambahan2[i]);
                            i++;
                            j++;
                        }
                        if (cateringBoolean = true) {
                            System.out.println("\t     Pesanan Catering: ");
                            for (int m = 0; m < l; m++) {
                                System.out.println("\t     - " + menu[m]);
                            }
                        }

                        System.out.println("           Nomor Telepon\t\t: " + nomorTelepon);
                        System.out.println("           Alamat Email\t\t\t: " + alamatEmail);
                        System.out.println("=================================================================================");
                    } else {
                        System.out.println("Maaf, Pemesanan yang anda minta tidak dapat kami proses. Silahkan coba lagi nanti.");

                    }
                    //tampilanClosing();

                    //Acara rapat
                } else if (acara.equalsIgnoreCase("rapat")) {
                    System.out.print("Tanggal Pelaksanaan Acara: ");
                    input.nextLine();
                    int b = 0;
                    tanggalPelaksanaanRapat[b] = input.nextLine();
                    b++;
                    pemesananRapat();
                    //LAYANAN TAMBAHAN RAPAT
                    String layananTambahanRapat[] = new String[4];
                    char confirm;
                    int g = 0;
                    do {
                        System.out.println("Layanan Tambahan: ");
                        System.out.println("1. Snack & Minuman");
                        System.out.println("2. Sound System");
                        System.out.println("3. LCD Proyektor");
                        System.out.println("4. Kursi");
                        System.out.print("Pilih layanan tambahan anda : ");
                        int pilihan = input.nextInt();
                        switch (pilihan) {
                            case 1:
                                layananTambahanRapat[g] = "Snack & Minuman";
                                g++;
                                break;
                            case 2:
                                layananTambahanRapat[g] = "Sound System";
                                g++;
                                break;
                            case 3:
                                layananTambahanRapat[g] = "LCD Proyektor";
                                g++;
                                break;
                            case 4:
                                layananTambahanRapat[g] = "Kursi";
                                g++;
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
                        System.out.println("Y (untuk Ya)\nT (untuk Tidak) : ");
                        confirm = input.next().charAt(0);

                    } while (confirm == 'Y' || confirm == 'y');

                    //NOTA PEMESANAN RAPAT
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
                        System.out.println("         Jenis Ruangan\t\t\t: " + jenisRuang);
                        System.out.println("\t Layanan Tambahan\t\t: ");
                        for (int i = 0; i < g; i++) {
                            System.out.println("\t   " + (i + 1) + ". " + layananTambahanRapat[i]);
                        }
                        System.out.println("         Nomor Telepon\t\t\t: " + nomorTelepon);
                        System.out.println("         Alamat Email\t\t\t: " + alamatEmail);
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
                if (gedungNikah[0] == null && gedungNikah[1] == null && gedungNikah[2] == null) {
                    System.out.println("SEMUA GEDUNG UNTUK PERNIKAHAN KOSONG");
                }
                if (ruangRapat[0] == null && ruangRapat[1] == null && ruangRapat[2] == null) {
                    System.out.println("SEMUA RUANGAN UNTUK RAPAT KOSONG");
                }
            }else if (pilihanmenu == 3){
                return;
            }
            System.out.print("Apakah anda ingin kembali ke menu? (y/t): ");
            input.nextLine();
            confirmMenu = input.nextLine();
        } while (confirmMenu.equalsIgnoreCase("y"));
    }
    //Display Admin Menu
    private static void adminMenu(String [] gedungNikah, String[] ruangRapat, String[] tanggalPelaksanaanAcara, String[] tanggalPelaksanaanRapat) {
        Scanner input = new Scanner(System.in);
        String confirmMenu;

        do {
            System.out.println("====================");
            System.out.println("||   Menu Admin   ||");
            System.out.println("====================");
            System.out.print("1. Lihat Gedung yang Terpesan\n2. Keluar\nMasukkan Angka dari menu: ");
            int pilihanmenu = input.nextInt();

            if (pilihanmenu == 1) {
                displayBookedVenues(gedungNikah, ruangRapat, tanggalPelaksanaanAcara, tanggalPelaksanaanRapat);
            } else if (pilihanmenu == 2) {
                System.out.println("Keluar dari Menu Admin.");
                break;
            }

            System.out.print("Apakah anda ingin kembali ke menu? (y/t): ");
            input.nextLine();
            confirmMenu = input.nextLine();
        } while (confirmMenu.equalsIgnoreCase("y"));
    }
    //display tempat yang dipesan
    private static void displayBookedVenues(String [] gedungNikah, String [] ruangRapat, String [] tanggalPelaksanaanAcara, String [] tanggalPelaksanaanRapat) {
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
        System.out.println("=========================================================================================");
        System.out.println("||  1. Paket A: Nasi Putih, Gurami Telor Asin, Soup sosis, Pudding Coklat, Air Mineral ||");
        System.out.println("||  2. Paket B: Nasi Putih, Ayam Bakar, Tumis Kangkung, Soft Drink, Air Mineral        ||");
        System.out.println("||  3. Paket C: Nasi Putih, Ayam Teriyaki, Air Mineral                                 ||");
        System.out.println("=========================================================================================");
    }
}
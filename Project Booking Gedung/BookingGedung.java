import java.util.Scanner;

public class BookingGedung {

    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        String identitasPemesan, jenisGedung, layananTambahan, tanggalPelaksanaanAcara, tanggalPemesanan;
        int jumlahTamu;

        //INPUT
        System.out.print("Masukkan Nama : ");
        identitasPemesan = input.nextLine();

        System.out.print("Masukkan Tanggal : ");
        tanggalPemesanan = input.nextLine();

        System.out.print("Tanggal Pelaksanaan Acara : ");
        tanggalPelaksanaanAcara = input.nextLine();

        System.out.print("Jumlah Tamu Undangan : ");
        jumlahTamu = input.nextInt();

        System.out.print("Jenis Gedung : ");
        jenisGedung = input.next();

        System.out.print("Layanan Tambahan : ");
        layananTambahan = input.next();

        System.out.print("Jumlah Tamu Undangan:\n Gedung A = 100 - 200\n Gedung B = 200 - 300\n Gedung C = 300 - 400\n Masukkan Jumlah Tamu:  ");
        jumlahTamu = input.nextInt();

        boolean pemesananBerhasil = true;
        //OUTPUT
        if (pemesananBerhasil) {
            System.out.println("------ Pemesanan Telah Berhasil------");
            System.out.println("Nama Pemesan :" + identitasPemesan);
            System.out.println("Tanggal Pemesanan :" + tanggalPemesanan);
            System.out.println("Tanggal Pelaksanaan Acara :" + tanggalPelaksanaanAcara);
            System.out.println("Jumlah Tamu Undangan :" + jumlahTamu);
            System.out.println("Jenis Gedung :" + jenisGedung);
            System.out.println("Layanan Tambahan: " + layananTambahan);
        } else {
            System.out.println("Maaf, Pemesanan yang anda minta tidak dapat kami proses. Silahkan coba lagi nanti.");

        }
        //CLOSING SCANNER
        input.close();
    }
}

public class ContohTipeData22 {
    public static void main(String[] args) {
        char golonganDarah = 'B';
        int jarak =  130;
        short myJarak = (short) jarak;
        short jumlahPendudukDalamSatuDusun = 1025;
        float suhu = 60.50F;
        double berat = 0.50000001111;
        long saldo = 150000000;
        int angkaDesimal = 0x10;

        System.out.println("Golongan Darah\t\t\t\t\t\t\t: " +  golonganDarah);
        System.out.println("jarak\t\t\t\t\t\t\t\t: " + myJarak );
        System.out.println("Jumlah Penduduk Dalam Satu Dusun\t\t\t\t: " + jumlahPendudukDalamSatuDusun);
        System.out.println("suhu\t\t\t\t\t\t\t\t: " + (float) suhu);
        System.out.println("berat\t\t\t\t\t\t\t\t: " +  (double) berat);
        System.out.println("saldo\t\t\t\t\t\t\t\t: " + saldo);
        System.out.println("angka desimal\t\t\t\t\t\t\t: " + angkaDesimal);

    }
}

import java.util.Scanner;

public class pleasepoo {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);

        int panjang;
        int lebar;
        int keliling;
        int luas;
        
        System.out.print("masukkan panjang persegi panjang: ");
        panjang = input.nextInt ();
        
        System.out.print("masukkan lebar persegi panjang: ");
        lebar = input.nextInt ();
        
        keliling = 2 * (panjang + lebar);
       
        System.out.print("Keliling Persegi adalah panjang:");
        System.out.println(keliling);

        System.out.print("Luas Persegi panjang adalah: ");
         luas = (panjang * lebar);
         System.out.print(luas);

    }
}

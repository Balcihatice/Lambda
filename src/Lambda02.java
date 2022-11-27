import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda02 {

    public static void main(String[] args) {

        List<Integer> sayi = new ArrayList<>(Arrays.asList(4, 2, 6, 11, -5, 7, 3, 15));
        ciftKarePrint(sayi);
        System.out.println("\n***********");
        tekSayiKupuBirdenFazla(sayi);
        System.out.println("\n***********");
        ciftKarekok(sayi);
        System.out.println("\n***********");
        maxBul(sayi);
        System.out.println("\n***********");
        structuredMaxBul(sayi);
        System.out.println("\n***********");
        ciftKareMaxPrint(sayi);
        System.out.println("\n***********");
        elTopla(sayi);
        System.out.println("\n***********");
        ciftElCarp(sayi);
        System.out.println("\n***********");
        minBul(sayi);
        System.out.println("\n***********");
        bestenBykEnKucuk(sayi);
        System.out.println("\n***********");
        ciftKareKckByge(sayi);
    }
    // Task-1 : Functional Programming ile listin cift elemanlarinin  karelerini
    // ayni satirda aralarina bosluk bırakarak print ediniz

    //once filter yapip listin icinden ciftleri alacagiz,sonra karelerini alacagiz

    public static void ciftKarePrint(List<Integer> sayi) {
        sayi.
                stream().
                filter(Lambda01::ciftBul).//akistaki cift sayilari filtreledik,diger classtan ciftbul methodunu cagirdik
                map(t -> t * t). //map ile yeni stream yapi baska degerlere donusur(16,4,36)
                forEach(Lambda01::yazdir);
    }


    // Task 2 : Functional Programming ile listin tek elemanlarinin  kuplerinin bir fazlasini
    // ayni satirda aralarina bosluk birakarak print edi


    public static void tekSayiKupuBirdenFazla(List<Integer> sayi) {
        sayi.
                stream().
                filter(t -> t % 2 != 0).//tek sayilari filtreledik
                map(t -> (t * t * t) + 1).//tek sayilarinin kupunun 1 fazlasini aldik
                forEach(Lambda01::yazdir);//sonucu yazdirdik
    }


    // Task-3 : Functional Programming ile listin cift elemanlarinin
// karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz

    public static void ciftKarekok(List<Integer> sayi) {
        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(Math::sqrt).//double deger geldigi icin asagida yazdir methodu yerine sout kullandik
                forEach(t -> System.out.print(t + " "));

    }

// Task-4 : list'in en buyuk elemanini yazdiriniz

    public static void maxBul(List<Integer> sayi) {
        Optional<Integer> maxSayi = sayi.//eger ifadem sol tarafa deger atayacaksa ve null olma ihtimali varsa optinal ile exceptin handle edilir
                                  stream().
                                  reduce(Math::max);//terminal opretorudur,arkasindan foreach gelmez
        System.out.println(maxSayi);//Optional[15]
        //eger benim resultim tek bir deger ise o zaman reduce terminal opr.kullanilir
    }//Integer degere null atanirsa nullpointerexceptions alinir,Java8de Optional geldi ve bu exceptions sorunu cozuldu

    //Bunu structored ile yazalim
    public static void structuredMaxBul(List<Integer> sayi) {
        int max = Integer.MIN_VALUE;
        System.out.println("max = " + max);

        for (int i = 0; i < sayi.size(); i++) {
            if (sayi.get(i) > max) max = sayi.get(i);
        }
        System.out.println("en buyuk sayi" + max);
    }

// Task-5 : List'in cift elemanlarin karelerinin en buyugunu print ediniz


    public static void ciftKareMaxPrint(List<Integer> sayi) {
        //bir degiskene atayacaksak Optional`e cast etmek gerekiyor.
        Optional<Integer> ciftKaremax = sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(t -> t * t).
                reduce(Integer::max);
       System.out.println(ciftKaremax);//Optional[36]
        //yada
        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(t -> t * t).reduce(Integer::max)); //seklinde de yazdirabilirdik
//Integer::max methodu , Math::max`a gore daha hizli calistigindan  Integer yazdik

    }


    // Task-6: List'teki tum elemanlarin toplamini yazdiriniz.Lambda Expression...
    public static void elTopla(List<Integer> sayi) {
        int topla = sayi.
                stream().
                reduce(0, (a, b) -> a + b);
        //toplamadaki etkisiz eleman sifiri yazdik ve akistan gelen iki sayiyi topla dedik
        System.out.println("topla = " + topla);//topla = 43
/*
* a ilk degerini her zaman atanan degerden (ilk parametre) alır,
    bu örnekte 0 oluyor
* b degerini her zamana  stream()'dan akısdan alır
* a ilk degerinden sonraki her değeri action(işlem)'dan alır

*/
    }

    // Task-7 : List'teki cift elemanlarin carpimini  yazdiriniz.
    public static void ciftElCarp(List<Integer> sayi) {
        System.out.println(sayi.//method refrance
                stream().
                filter(Lambda01::ciftBul).
                reduce(Math::multiplyExact));//Optional[48]

        //optional olmayan sekilde yazalim, bu lambda expression dir daha mantikli cozum olur.
        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul)
                .reduce(1, (a, b) -> (a * b)));// herhalukarda icinde 1 var nulpointer gelmez->> 48geldi
    }

    // Task-8 : List'teki elemanlardan en kucugunu  print ediniz.
    //1.Yol:
    public static void minBul(List<Integer> sayi) {
        System.out.println(sayi.stream().reduce(Integer::min));//Optional[-5]
        // Integer::min yerine->Math::min de kullanilabilir

   //2.Yol : asagidaki method ile
        System.out.println(sayi.stream().reduce(Lambda02::byMiracMin));//Optional[-5]



    }
    //bunun structured olarak yazariz
    public static int byMiracMin(int a,int b){
        return a<b ? a : b;//en kucuk olani handle ettik,yukarida bu methodu kullandik
    }



  /*
eger biz ilave birseyler yazmadan  hazir java methodlarindan cagiriyor isek "Method  reference" ;
biz ilave biseyler yaziyor isek "lambda expression"  oluyor.
   */

    // Task-9 : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.
    public static void bestenBykEnKucuk(List<Integer> sayi){
        System.out.println(sayi.
                stream().
                filter(a -> a > 5 && a % 2 == 1).// filter: ara operatorduk akisi devam ettirir
                reduce(Lambda02::byMiracMin));//Optional[7]

    }

    // Task-10 : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.
    public static void ciftKareKckByge(List<Integer> sayi){ //reduce kullanamayiz cunku ciktida birden cok sayi olacak
       sayi.stream().
               filter(Lambda01::ciftBul).//ciftsayilari aldik
               map(t->t*t).//sayilarin karesini aldik,akisi devam ettirdik
               sorted().// sadece natural order ise sorted() yeterli
               forEach(Lambda01::yazdir);//4 16 36
    }
}
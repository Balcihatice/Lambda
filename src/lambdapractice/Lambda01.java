package lambdapractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda01 {
    public static void main(String[] args) {


        List<Integer> list = new ArrayList<>(Arrays.asList(-5, -8, -2, -12, 0, 1, 12, 5, 5, 6, 9, 15, 8));
        // S1:listi aralarinda bosluk birakarak yazdiriniz
        hepsiniYazdir(list);
        System.out.println("\n*****");
        negatifYaz(list);
        System.out.println("\n*****");
        pozitifYaz(list);
        System.out.println("\n*****");
        ciftYaz(list);
        System.out.println("\n*****");
        pozitifCiftYazdir(list);
        System.out.println("\n*****");
        kareYazdir(list);
        System.out.println("\n*****");
        ciftKupYazdir(list);
        System.out.println("\n*****");
        kareTaktarsiz(list);
        System.out.println("\n*****");
        KcktenBuyuge(list);
        System.out.println("\n*****");
        buyuktenKucuge(list);
        System.out.println("\n*****");
        System.out.println(pozitifNewList(list));
        System.out.println("\n*****");
        System.out.println(pozKare5Degil(list));
        System.out.println("\n*****");
        System.out.print(elTopla(list));
        System.out.println("\n*****");
        System.out.print(elToplaReferance(list));
        System.out.println("\n*****");
        System.out.print(elToplaReferanceInt(list));
        System.out.println("\n*****");
        pozElTopla(list);
    }

    public static void hepsiniYazdir(List<Integer> l) {
        l.stream().forEach(t -> System.out.print(t + " "));//lambda exprecion
    }


    //S2: sadece negatif olanlari yazdir
    public static void negatifYaz(List<Integer> l) {
        l.stream().filter(t -> t < 0).forEach(t -> System.out.print(t + " "));//lambda exprecion
    }

    //S3: pozitif olanlardan yeni bir liste olustur
    public static void pozitifYaz(List<Integer> l) {
        l.stream().filter(t -> t > 0).forEach(t -> System.out.print(t + " "));//lambda exprecion
    }


    //S4:pozitif ve çift olanları yazdırın

    public static void ciftYaz(List<Integer> l) {
        l.stream().filter(t -> t % 2 == 0).forEach(t -> System.out.print(t + " "));//lambda exprecion
    }

    //S5:pozitif veya çift olanları yazdırın

    public static void pozitifCiftYazdir(List<Integer> l) {
        l.stream().filter(t -> t % 2 == 0 || t > 0).forEach(t -> System.out.print(t + " "));//lambda exprecion
    }

    //map():stream den gelen elemanları baska ttıplere donusturmek veya uzerlerınde
    //ıslem yapmak ıcın (update) kullanılır
    // S6: list in elemanlarin karelerini aynı satırda bır bosluklu yazdıralım

    public static void kareYazdir(List<Integer> l) {
        l.stream().map(t -> t * t).forEach(t -> System.out.print(t + " "));//lambda exprecion
    }

    //S7: Listin cift elemanlarının kuplerini  aynı satırda bır bosluklu yazdıralım

    public static void ciftKupYazdir(List<Integer> l) {
        l.stream().filter(t -> t % 2 == 0).map(t -> t * t * t).forEach(t -> System.out.print(t + " "));//lambda exprecion
    }

    //S8 : list in elemanlarin karelerinden tekrarsiz yazdıralım
    public static void kareTaktarsiz(List<Integer> l) {
        l.stream().map(t -> t * t * t).distinct().forEach(t -> System.out.print(t + " "));//lambda exprecion
    }


    //S9: listin elemanlarini kucukten buyuge siralayalim
    public static void KcktenBuyuge(List<Integer> l) {
        l.stream().sorted().forEach(t -> System.out.print(t + " "));//lambda exprecion
    }

    //S10: listin elemanlarini buyukten kucuge siralayalim

    public static void buyuktenKucuge(List<Integer> l) {
        l.stream().sorted(Comparator.reverseOrder()).forEach(t -> System.out.print(t + " "));

    }

    // S11: list pozitif elemanlari icn kuplerini bulup birler basamagi 5 olanlardan yeni
    // bir list olusturalim

    public static List<Integer> pozitifNewList(List<Integer> l) {
        return l.stream().
                filter(t -> t > 0).
                map(t -> t * t * t).
                filter(t -> t % 10 == 5).
                collect(Collectors.toList());


    }

//S12: list pozitif elemanlari icn karelerini bulup birler basamagi 5 olmayanlardan yeni bir list olusturalim

    public static List<Integer> pozKare5Degil(List<Integer> l) {
        List<Integer> newList = l.
                stream().
                filter(t -> t > 0).
                map(t -> t * t).
                filter(t -> t % 10 != 5).
                collect(Collectors.toList());
        return newList;
    }

    /*
reduce()-->azaltmak ... bir cok datayi tek bir dataya(max min carp top vs islemlerde) cevirmek icin kullanilir.
kullanımı yaygındır pratiktir.
Bir Stream içerisindeki verilerin teker teker işlenmesidir. Teker teker işleme sürecinde, bir önceki adımda elde edilen sonuç
bir sonraki adıma girdi olarak sunulmaktadır. Bu sayede yığılmlı bir hesaplama süreci elde edilmiş olmaktadır.
reduce metodu ilk parametrede identity değeri, ikinci parametrede ise BinaryOperator türünden bir obj kullanılır.
reduce işleminde bir önceki hesaplanmış değer ile sıradaki değer bir işleme tabi tutulmaktadır.
İşleme başlarken bir önceki değer olmadığı için bu değer identity parametresinde tanımlanmaktadır.

*/

    // S13 :list elemanlarini toplamini bulalim
    public static int elTopla(List<Integer> l) {

        int i = l.stream().reduce(0, (x, y) -> x + y);
        return i;
    }

    // S13  2. yol
        public static int elToplaReferance(List<Integer> l) {
            int i = l.stream().reduce(0,Math::addExact);
        return i;
    }

    //S13 3.yol:Optinal vermemesi icin: bu methoddan herhangi bir eleman gelmeme durumunda
    // nullPointerException verir,baslangic degeri ( 0 )oldugunda elimizde herhalukarda sifir olur
    // ve bunu return ederiz
    public static int elToplaReferanceInt(List<Integer> l) {
        int i = l.stream().reduce(0,Integer::sum);
        return i;
    }


    //S14 : Listin pozitif elemanları toplamını bulalım

    public static void pozElTopla(List<Integer> l) {
        l.stream().filter(t->t>0).reduce(0,Integer::sum);

    }


}
import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {

    /*
TASK :
fields --> Universite (String)
           bolum (String)
           ogrcSayisi (int)
           notOrt (int)
           olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.

  /*
     Pojo(Plain Old Java Object) Class nedir?
1)Variable ları private olan (Encapsulation yapılmış olan)
2)Bir parametresiz birde parametreli Constructor olan
3)Getter ve Setter methodlar olan
4)toString() methodu olan
 Class'lara kısaltma isim olarak Pojo(Plain Old Java Object) Class denir
     */




    public static void main(String[] args) {

        Universite u01 = new Universite("bogazici", "matematik", 571, 93);
        Universite u02 = new Universite("istanbul tk", "matematik", 600, 81);
        Universite u03 = new Universite("istanbul", "hukuk", 1400, 71);
        Universite u04 = new Universite("marmara", "bilg muh", 1080, 77);
        Universite u05 = new Universite("odtu", "gemi mh", 333, 74);

        List<Universite> unv = new ArrayList<>(Arrays.asList(u01, u02, u03, u04, u05));

        System.out.println(notOrtalamasi74NuyukUnv(unv));
        System.out.println(matBolumVarMi(unv));
        System.out.println(ogrSayiBuyuktenKucuge(unv));
        System.out.println(matBolumSayisi(unv));//2
        System.out.println(ogrncSay500DenFazlaEnBuyukNotOrt(unv));
        System.out.println(ogrsys1050DenAz(unv));
    }

    //task 01--> butun unversitelerin notOrt'larinin 74' den buyuk oldg kontrol eden pr create ediniz.

    public static boolean notOrtalamasi74NuyukUnv(List<Universite> unv) {

        return unv.stream().//akisi sagladik herbirini allmatche gonderiyor. universiteler u01,u02,u03,u04,u05
                allMatch(t -> t.getNotOrt() > 74);//allmatch hepsinde true alinca true verir,biri false olursa false verir


    }
    //task 02-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.

    public static boolean matBolumVarMi(List<Universite> unv) {
        return unv.
                stream().//akis saglandi
                        anyMatch(t -> t.getBolum(). //objlerin bolum isimleri alindi
                        toLowerCase().//bolum isimleri kucuk harfe cevrildi
                        contains("mat")); //mat kelimesi varmi kontrol
    }


    //task 03-->universite'leri ogr sayilarina gore b->k siralayiniz.
    public static List<Universite> ogrSayiBuyuktenKucuge(List<Universite> unv) {
        return unv.  //List<Integer>==>>(1,2,3)      ==>List<Universite> -->> (u01, u02, u03, u04, u05)
                stream().//akis saglandi
                sorted(Comparator.comparing(Universite::getOgrSayisi).reversed()).//benim istedigim sekilde sirala
                //universiteler ogrenci sayisina gore tersten siralandi
                        collect(Collectors.toList());//yukardan gelen stream yapiyi liste donusturur.
       //Comparator.comparing(Universite::getOgrSayisi) arguman ne gonderirsek ona gore siralar
    }

//task 04-->"matematik" bolumlerinin sayisini  print ediniz.

    public static int matBolumSayisi(List<Universite> unv){ // cast yaparken int yerine long yazsakta olur.o zaman returnun onundekini sileriz
      return (int) unv.
               stream().//akis saglandi
               filter(t->t.getBolum().contains("mat")).//matematik bolumu olan universiteleri sectim
               count();//secilen inu sayisini aldim count (long donduruyor)
    }

     //task 05-->Ogrenci sayilari 550'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz.
public static OptionalInt ogrncSay500DenFazlaEnBuyukNotOrt(List<Universite> unv){
  return  unv.stream().filter(t->t.getOgrSayisi()>550).//500 den fazla olan universiteler geldi
            mapToInt(t->t.getNotOrt()).//gelen unv dennot orlamalarini aldik int oldugundan farkli method kullandik
            max();//en buyugu aldik
       //null gelme igtimaline karsi return deyince methodun return type i Optional yapti
}

//task 06-->Ogrenci sayilari 1050'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.
    public static OptionalInt ogrsys1050DenAz(List<Universite> unv){
     return unv.
             stream().
             filter(t->t.getOgrSayisi()<1050).
             mapToInt(t->t.getNotOrt()).
             min();
    }


}
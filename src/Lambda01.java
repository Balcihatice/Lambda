import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01 {

    public static void main(String[] args) {
        /*
      1)  Lambda --> mathod create  etme değil mevcut method'ları(library)secip kullanmaktır...
          Lambda'lar sayesinde daha az kod ve hızlı geliştirme sağlanabilmektedir.
      2) "Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
          "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
      3)  "Functional Programming" hiz, code kisaligi, code okunabilirligi
          ve hatasiz code yazma acilarindan cok faydalidir.
      4)  Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak map'lerde kullanılmaz.

*/

        List<Integer> sayi = new ArrayList<>(Arrays.asList(34, 22, 16, 11, 35, 20, 63, 21, 65, 44, 66, 64, 81, 38, 15));


        printElStructured(sayi);
        System.out.println(" \n******* ");
        printElFunctional(sayi);
        System.out.println(" \n******* ");
        printElFunctional1(sayi);
        System.out.println(" \n******* ");
        printElFunctional2(sayi);
        System.out.println(" \n******* ");
        printCiftFunctional(sayi);
        System.out.println(" \n******* ");
        printCiftOtuzFunctional(sayi);
        System.out.println(" \n******* ");
        printCiftOtuzBykFunctional(sayi);
        System.out.println(" \n******* ");
        printElFunctional(sayi);
    }

    //TASK  : "Structured Programming" kullanarak list elemanlarını aynı satirda
    // aralarında bosluk olacak sekilde print ediniz.
    public static void printElStructured(List<Integer> sayi) {
        for (Integer w : sayi) {
            System.out.print(w + " ");
        }

    }

    //TASK  : "functional Programming" kullanarak list elemanlarını aynı satirda
    // aralarında bosluk olacak sekilde print ediniz.
    public static void printElFunctional(List<Integer> sayi) {
        //Elimizde collections yapi olmali
        sayi.stream().   //Lambda expression lambda ile kullanacagim demis oluyoruz
                forEach((t) -> System.out.print(t + " "));//lambda exprssion ile lambda nin nasil calisacagini soyledik,bu lambdanin tabiatina aykiri

    }

    public static void printElFunctional1(List<Integer> sayi) {
        //Elimizde collections yapi olmali
        sayi.stream().
                forEach(System.out::print); //method referance ,Mumkun oldugu kadar method referance kullanin.

    }
//Kendimiz bir method olusturalim ve bunu cagiralim,Yukaridaki isimizi istedigimiz gibi yapmadi,hepsini bitisik verdi

    public static void yazdir(int a) {

        System.out.print(a + " ");
    }

    public static void printElFunctional2(List<Integer> sayi) {
        sayi.stream().
                forEach(Lambda01::yazdir); //method referance

    }
//TASK  : functional Programming ile list elemanlarinin  cift olanlarini
// ayni satirda aralarina bosluk birakarak print ediniz.


    //yukaridaki Task`i filter() kismini method referance ile yapalim
    public static boolean ciftBul(int a) {
        return a % 2 == 0;
    }

    public static void printElFunctional3(List<Integer> sayi) {
        sayi.stream().
                filter(Lambda01::ciftBul).//methodu refrance
                forEach(Lambda01::yazdir);

    }

    public static void printCiftFunctional(List<Integer> sayi) {
        sayi.
                stream().
                filter(t -> t % 2 == 0).  //Lambda expression  ara method
                forEach(Lambda01::yazdir); //terminal methodu
    }
    //if yerine filter() kullandik


//TASK  : structural Programming ile list elemanlarinin  cift olanlarini
// ayni satirda aralarina bosluk birakarak print ediniz.

    public static void printCiftElStructured(List<Integer> sayi) {
        for (Integer w : sayi) {
            if (w % 2 == 0) {
                System.out.println(w + " ");
            }
        }
    }

////TASK :functional Programming ile list elemanlarinin 34 den kucuk
// cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.

    public static void printCiftOtuzFunctional(List<Integer> sayi) {
        sayi.
                stream().
                filter(t -> t % 2 == 0 && t < 34).
                forEach(Lambda01::yazdir);
    }
    // Odev: bunun structural yaz


    //Task : functional Programming ile list elemanlarinin 34 den buyk veya
    // cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void printCiftOtuzBykFunctional(List<Integer> sayi) {
        sayi.
                stream().
                filter(t -> t % 2 == 0 || t > 34).
                forEach(Lambda01::yazdir);
    }


}

import java.util.stream.IntStream;

public class Lambda05 {

    public static void main(String[] args) {
//TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar
// (x dahil) tamsayilari toplayan bir program create ediniz.

        System.out.println(topla(5));
        System.out.println(toplaCincix(5));
        System.out.println(toplaCift(10));
        System.out.println(pozitifCiftTopla(10));
        System.out.println(toplaIlkXCift(10));

    }
//Structured
    public static int topla(int a){

        int toplam= 0;
        for (int i = 0; i <= a; i++) {
            toplam = toplam +i;

        }
        return toplam;
    }
//Functional
    public static int toplaCincix(int x){
      return  IntStream.//akis alindi
              range(1,x+1).//range(a,b)-->>adan b ye kadar (b dahil degil) int degerler akisa alindi
              sum();//toplama yapildi
    }
//TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.

    public static int toplaCift(int x) {
        return IntStream.//akis alindi
               rangeClosed(1,x+1).//range de 2.parametre dahil degil, rangeclosed da 2. parametre dahildir.
                filter(t -> t % 2 == 0).
                sum();
    }

    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.

    public static int pozitifCiftTopla(int x) {
        return IntStream.rangeClosed(1,x*2).
                filter(Lambda01::ciftBul).sum();


    }

//2.Yol
    public static int toplaIlkXCift(int x){
       return IntStream.iterate(2,t->t+2). //2 den baslar ikiser artirarak sonsuza kadar gider
                limit(x).//sonsuz donguyu engeller (x ile sinirladik)
                sum();

    }


}

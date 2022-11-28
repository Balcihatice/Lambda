import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda04 {

    /*
TASK :
fields --> Universite (String)
           bolum (String)
           ogrcSayisi (int)
           notOrt (int)
           olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
 */


    public static void main(String[] args) {

        Universite u01 = new Universite("bogazici","matematik",571,93);
        Universite u02 = new Universite("istanbul tk","matematik",600,81);
        Universite u03 = new Universite("istanbul","hukuk",1400,71);
        Universite u04 = new Universite("marmara","bilg muh",1080,77);
        Universite u05 = new Universite("odtu","gemi mh",333,74);

       List<Universite> unv = new ArrayList<>(Arrays.asList(u01,u02,u03,u04,u05));

        System.out.println(notOrtalamasi74NuyukUnv(unv));


    }

     //task 01--> butun unversitelerin notOrt'larinin 74' den buyuk oldg kontrol eden pr create ediniz.

   public static boolean notOrtalamasi74NuyukUnv(List<Universite> unv){

      return  unv.stream().allMatch(t->t.getNotOrt()>74);


   }






}

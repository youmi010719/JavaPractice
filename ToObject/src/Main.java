import com.jichu.fanfa.Person;
import com.jichu.fanfa.Student;

public class Main {
    public  static void main(String[] args){
    /*   Person l = new Student();向上转型是允许的，但是向下转型是不允许的
       Student l2 = new Person();error
       */

        Person hong = new Person();
        hong.setName("hong");
        hong.run();
        Student ming = new Student("diphthong",13,99);
        System.out.println((ming.getName()));
        System.out.println((ming.gteScore()));
        ming.run();
        ming.setName("miaowing") ;
        ming.setAge(12);
        ming.setScore(95);
        System.out.println(ming.gteScore());
        System.out.println(ming.getAge());
        System.out.println((ming.getName()));
        ming.hello();
        ming.hello("diphthong",25);
        /*Person b = new Person();
        String bob = "bod";
        b.setName("bob");
        System.out.println(b.getName());
        bob = "alice";
        System.out.println(b.getName());*/
    }
}
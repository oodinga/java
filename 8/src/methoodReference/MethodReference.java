package methoodReference;

import java.util.function.BiFunction;

/**
 * @author : Odinga David
 * @since : 12/27/21, Mon
 */

class Saying{
    Saying(String say){
        System.out.println(say);
    }
}

public class MethodReference {

    interface Sayable{
       void say();
    }

    interface Sayable2{
        void say(String say);
    }


    public static int add(int a, int b){
        return a+b;
    }

    public static float add(int a, float b){
        return a+b;
    }
    public static float add(float a, float b){
        return a+b;
    }

    public static int subtract(int a, int b){
        return a-b;
    }

    public static void talk() {
        System.out.println("Java is the best language");
    }

    public void talk2() {
        System.out.println("Java is the best language");
    }
    public static void main(String[] args) throws InterruptedException {

        // Static method reference
        Sayable say = MethodReference::talk;
        say.say();

        Thread t2=new Thread(MethodReference::talk);
        t2.start();

        Thread.sleep(500);

        //Using predefined functional interfaces
        BiFunction<Integer, Integer, Integer> add = MethodReference::add;
        System.out.println("sum: "+add.apply(80,70));

        BiFunction<Integer, Integer, Integer> subtract = MethodReference::subtract;
        System.out.println("sum: "+subtract.apply(80,70));


        //Overloading method reference
        BiFunction<Integer, Float, Float> add2 = MethodReference::add;
        BiFunction<Float, Float, Float> add3 = MethodReference::add;

        System.out.println(add2.apply(100,  45.90006F));
        System.out.println(add3.apply(12.567F,  67.894F));

        //Instance reference
        Sayable sayable = new MethodReference()::talk2;
        sayable.say();


        //Constructor reference
        Sayable2 sayable2 = Saying::new;
        sayable2.say("Constructor reference");
    }
}

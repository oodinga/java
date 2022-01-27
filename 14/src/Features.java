import java.util.List;

/**
 * @author : Odinga David
 * @since : 1/27/22, Thu
 */
public class Features {

    record Student(String name, String gender, int age){}
    record Lecturer(String name, String title){}
    record Class(List<Student> students, Lecturer lecturer, String name){}

    public static void instanceOfMethod(Object o){
        if (o instanceof String s)
            System.out.println(s.length());

        else
            System.out.println("Not a String");
    }

    public static void main(String[] args) {
        //Instance of method
        instanceOfMethod("David Karanja");
        instanceOfMethod(45);

        Student student= new Student("David", "M", 21);
        List<Student> students= List.of(
                new Student("David", "M", 21),
                new Student("Faith", "F", 24));

        Lecturer lecturer = new Lecturer("Odiyo", "Mr.");
        Class programming = new Class(students, lecturer,  "Object Oriented Programming");

        System.out.println(programming.lecturer.name);

    }
}

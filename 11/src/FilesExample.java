import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author : Odinga David
 * @since : 1/20/22, Thu
 */
public class FilesExample {

    record User(String name, int age, String gender) {}


    static void readStringFromFile(String uri) {
        try {
            String data = Files.readString(Path.of(uri));
            System.out.println(data);

            Predicate<String> ageIsInt =  d -> {
                try {
                    Integer.parseInt(d.split(",")[1].strip());
                    return true;
                } catch (Exception e) {
                    return false;
                }
            };
            Predicate<String> hasAllData = d -> d.split(",").length >= 3;

            List<User> users = data.lines()
                    .filter(hasAllData.and(ageIsInt))
                    .map(line -> {
                        String[] userData = line.split(",");
                        return new User(userData[0], Integer.parseInt(userData[1].strip()), userData[2]);
                    }).collect(Collectors.toList());

            System.out.println(users.size());
            users.forEach(user -> System.out.println("name:"+user.name+" age: "+user.age+" gender: "+(user.gender.equalsIgnoreCase("M")? "MALE": "FEMALE")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void writeStringToFile(String uri, String data){
        try {
            String toWrite= data.startsWith("\n") ? data : "\n"+data;
            Files.writeString(Path.of(uri), toWrite, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        String uri = "11/example.txt";

        readStringFromFile(uri);

        writeStringToFile(uri, "Jane, 30, F");
        writeStringToFile(uri, "Jeff, 10, F");
        writeStringToFile(uri, "Meshack, 15, F");

    }
}

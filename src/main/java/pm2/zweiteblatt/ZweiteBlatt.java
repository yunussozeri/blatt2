package pm2.zweiteblatt;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;

/**
 *
 * @author yunussozeri
 */
public class ZweiteBlatt {

      String[] FIRST_NAMES = {"Yunus", "Fatma", "Suat", "Zeynep", "Nihal", "Talha", "Halit", "Tarik", "Bahadir", "Ahmet"};
      String[] LAST_NAMES = {"Demir", "Sozeri", "Yildirim", "Tasoglu", "Atmaca", "Akcay", "Yazan", "Suata", "Ozen", "Zortingen"};

    public List<Person> listOfRandomPeople() {
        Random random = new Random();
        List <Person> list = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
            String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
            int birthYear = 1950 + random.nextInt(55);
            int birthMonth = 1 + random.nextInt(12);
            int birthDay = 1 + random.nextInt(28);
            int numChildren = random.nextInt(5);
            Person person = new Person(firstName, lastName, birthYear, birthMonth, birthDay, numChildren);
            //System.out.println(person.toString());
            list.add(person);
        }
        return list;
    }

    public static void main(String[] args) {
        PM2Map<Integer, Person> personmap = new PM2Map<>();

        ZweiteBlatt z = new ZweiteBlatt();
        
        List<Person> l = z.listOfRandomPeople();
        l.forEach((p) -> personmap.put(p.hashCode(), p));
        personmap.forEach((hash,person)-> System.out.println(person.toString()));
        
        System.out.println("\nSorting in Process....");
        
          List<Map.Entry<String, Person>> sort = personmap.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .filter(p -> p.getGeburtsdatum().isBefore(LocalDate.of(1984, 1, 1)))
                .sorted((p1, p2) -> p1.compareTo(p2))
                .map(p -> Map.entry(p.getVorname(), p))
                .toList();
          
                sort.forEach(System.out::println);

    }

}

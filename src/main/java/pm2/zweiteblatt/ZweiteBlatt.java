package pm2.zweiteblatt;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author yunussozeri
 */
public class ZweiteBlatt {

      String[] FIRST_NAMES = {"Yunus", "Fatma", "Suat", "Zeynep", "Nihal", "Talha", "Halit", "Tarik", "Bahadir", "Ahmet"};
      String[] LAST_NAMES = {"Demir", "Sozeri", "Yildirim", "Tasoglu", "Atmaca", "Akcay", "Yazan", "Suata", "Ozen", "Zortingen"};

    public Map<String,Person> zort() {
        Random random = new Random();
        Map <String,Person> map = new HashMap<>();
        for (int i = 0; i < 15; i++) {
            String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
            String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
            int birthYear = 1950 + random.nextInt(55);
            int birthMonth = 1 + random.nextInt(12);
            int birthDay = 1 + random.nextInt(28);
            int numChildren = random.nextInt(5);
            Person person = new Person(firstName, lastName, birthYear, birthMonth, birthDay, numChildren);
            //System.out.println(person.toString());
            map.put(firstName,person);
        }
        
        return map;
    }

    public static void main(String[] args) {
        PM2Map<String, Person> personmap = new PM2Map<>();

        ZweiteBlatt z = new ZweiteBlatt();
        
        personmap.putAll(z.zort());
        System.out.println("PRINTING PEOPLE");
        personmap.forEach((name,person) -> System.out.println(person));
       

    }

}

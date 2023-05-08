
package pm2.zweiteblatt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author yunussozeri und oskar
 */

public class PersonTest {

    @Test
    public void testFilterAndSortPersons() {
        PM2Map<String, Person> map = new PM2Map<>();
        map.put("Nachname0", new Person("Vorname0", "Nachname0", LocalDate.of(1970, 1, 1), 2));
        map.put("Nachname1", new Person("Vorname1", "Nachname1", LocalDate.of(1965, 1, 1), 1));
        map.put("Nachname2", new Person("Vorname2", "Nachname2", LocalDate.of(1980, 1, 1), 4));
        map.put("Nachname3", new Person("Vorname3", "Nachname3", LocalDate.of(1990, 1, 1), 0));
        map.put("Nachname4", new Person("Vorname4", "Nachname4", LocalDate.of(1975, 1, 1), 7));
        map.put("Nachname5", new Person("Vorname5", "Nachname5", LocalDate.of(1985, 1, 1), 3));
        map.put("Nachname6", new Person("Vorname6", "Nachname6", LocalDate.of(1960, 1, 1), 2));
        map.put("Nachname7", new Person("Vorname7", "Nachname7", LocalDate.of(1983, 1, 1), 1));
        map.put("Nachname8", new Person("Vorname8", "Nachname8", LocalDate.of(1995, 1, 1), 2));
        map.put("Nachname9", new Person("Vorname9", "Nachname9", LocalDate.of(1978, 1, 1), 5));

        Map.Entry<String, Person>[] filteredAndSorted = map.entrySet().stream()
                .map(Map.Entry::getValue)
                .filter(p -> p.getGeburtsdatum().isBefore(LocalDate.of(1984, 1, 1)))
                .sorted((p1, p2) -> Integer.compare(p2.getAnzahlKinder(), p1.getAnzahlKinder()))
                .map(p -> Map.entry(p.getVorname(), p))
                .toArray(Map.Entry[]::new);

        
        Assertions.assertEquals(filteredAndSorted[0].getValue().getAnzahlKinder(), 7);
        Assertions.assertEquals(filteredAndSorted[1].getValue().getAnzahlKinder(), 5);
        Assertions.assertEquals(filteredAndSorted[2].getValue().getAnzahlKinder(), 4);
        Assertions.assertEquals(filteredAndSorted[3].getValue().getAnzahlKinder(), 2);
        Assertions.assertEquals(filteredAndSorted[4].getValue().getAnzahlKinder(), 2);
        Assertions.assertEquals(filteredAndSorted[5].getValue().getAnzahlKinder(), 1);
        Assertions.assertEquals(filteredAndSorted[6].getValue().getAnzahlKinder(), 1);
        
        Map.Entry<String, Person>[] sort = map.entrySet().stream()
                .map(Map.Entry::getValue)
                .filter(p -> p.getGeburtsdatum().isBefore(LocalDate.of(1984, 1, 1)))
                .sorted((p1, p2) -> p1.compareTo(p2))
                .map(p -> Map.entry(p.getVorname(), p))
                .toArray(Map.Entry[]::new);
       
        List a = Arrays.asList(sort);
      
        a.forEach(person-> System.out.println(person.toString()));
        

    }
}

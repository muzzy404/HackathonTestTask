import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Main {

  static Person egor;
  static LinkedList<Person> egorFriends = new LinkedList<>();
  static Set<Integer> people = new HashSet<>();

  public static void readInput() {
    try {
      BufferedReader reader = new BufferedReader(new FileReader("input"));

      String line = reader.readLine();
      egor = new Person(Integer.valueOf(line));

      while(true) {
        line = reader.readLine();
        if (line == null)
          break;

        String parts[] = line.split("\\s+");

        int id = Integer.valueOf(parts[0]);
        egor.addFriend(id);
        people.add(id);

        List<Integer> friendList = new LinkedList<>();
        for(int i = 2; i < parts.length; ++i) {
          Integer p = Integer.valueOf(parts[i]);
          friendList.add(p);
          people.add(p);
        }
        egorFriends.add(new Person(id, friendList));
      }
      reader.close();
    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }

  public static void main(String[] args) {
    readInput();
    Set<Integer> friendsOfFriends = new HashSet<>();

    for (Person friend : egorFriends) {
      for (Integer person : people) {
        if (friend.friend(person) && !egor.friend(person))
          friendsOfFriends.add(person);
      }
    }
    System.out.println(friendsOfFriends.size());
  }
}

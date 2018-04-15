import java.util.*;

public class Main {

  static Person egor;
  static LinkedList<Person> egorFriends = new LinkedList<>();
  static Set<Integer> people = new HashSet<>();

  public static void readInput() {
    Scanner input = new Scanner(System.in);

    try {
      String line = input.nextLine();
      egor = new Person(Integer.valueOf(line));

      while(input.hasNextLine()) {
        line = input.nextLine();
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
    } catch (Exception e) { }
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

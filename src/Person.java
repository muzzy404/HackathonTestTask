import java.util.LinkedList;
import java.util.List;

public class Person {

  public final int id;
  public final int friends;
  private List<Integer> friendList;

  public Person(int friends) {
    this.id = 0;
    this.friends = friends;
    this.friendList = new LinkedList<>();
  }

  public Person(int id, List<Integer> friendList) {
    this.id = id;
    this.friendList = friendList;
    this.friends = friendList.size();
  }

  public void addFriend(int friend) {
    friendList.add(friend);
  }

  public boolean friend(Integer person) {
    for (Integer friend : friendList) {
      if (friend.equals(person)) {
        return true;
      }
    }
    return false;
  }
}

package classwork.theme_1.ex5;

import java.io.Serializable;
import java.util.List;

public class Memento implements Serializable {
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}

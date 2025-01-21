package lt.vtmc.praktiniai.users;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Praktiniai {

    public static Integer countUsersOlderThen25(List<User> users) {
        int count = 0;
        for (User user : users) {
            if (user.getAge() > 25) {
                count++;
            }
        }
        return count;
//        throw new UnsupportedOperationException("Not implemented");
    }

    public static double getAverageAge(List<User> users) {
        double avg = 0;
        int sum = 0;
        for (User user : users) {
            sum = sum + user.getAge();
        }
        avg = (double) sum / users.size();
        return avg;
//        throw new UnsupportedOperationException("Not implemented");
    }

    // TODO: Naudokite klase Collections.min(). Paduokite Comparator
    public static Integer getMinAge(List<User> users) {

        return Collections.min(users, new Comparator<User>() {
            @Override
            public int compare(User user, User t1) {
                if (user.getAge() > t1.getAge()) {
                    return 1;
                } else if (user.getAge() < t1.getAge()) {
                    return -1;
                }
                return 0;
            }
        }).getAge();
    }

    public static User findByName(List<User> users, String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }


        throw new UnsupportedOperationException("Not implemented");
    }

    // TODO: Naudokite klase Collections.sort(). Paduokite Comparator
    public static List<User> sortByAge(List<User> users) {
//        throw new UnsupportedOperationException("Not implemented");
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User user, User t1) {
                if (user.getAge() > t1.getAge()) {
                    return 1;
                } else if (user.getAge() < t1.getAge()) {
                    return -1;
                }
                return 0;
            }
        });
        return users;
    }

    // TODO: Naudokite klase Collections.max(). Paduokite Comparator
    public static User findOldest(List<User> users) {

        return Collections.max(users, new Comparator<User>() {
            @Override
            public int compare(User user, User t1) {
                if (user.getAge() > t1.getAge()) {
                    return 1;
                } else if (user.getAge() < t1.getAge()) {
                    return -1;
                }
                return 0;
            }
        });

        //throw new UnsupportedOperationException("Not implemented");

    }

    public static int sumAge(List<User> users) {
        int sum = 0;
        for (User user : users) {
            sum = sum + user.getAge();
        }

        //throw new UnsupportedOperationException("Not implemented");
        return sum;
    }

}

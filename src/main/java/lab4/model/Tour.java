package lab4.model;

import java.util.List;

public class Tour {
    private final City city;
    private final List<User> users;
    private final int price;

    public Tour(City city, List<User> users, int price) {
        this.city = city;
        this.users = users;
        this.price = price;
    }

    public City getCity() {
        return city;
    }

    public List<User> getUsers() {
        return users;
    }

    public int getPrice() {
        return price;
    }
}

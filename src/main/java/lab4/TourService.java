package lab4;

import lab4.error.TourException;
import lab4.model.City;
import lab4.model.Tour;
import lab4.model.User;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class TourService {

    private Map<City, Integer> cities;
    private List<Tour> tours;

    public TourService() {
        tours = new ArrayList<>();
        cities = new HashMap<>();
        cities.put(new City("Lviv"), 10);
        cities.put(new City("Kyiv"), 12);
        cities.put(new City("Kharkiv"), 8);
        cities.put(new City("Odesa"), 8);
    }

    public int cityPrice(City city) {
        Integer price = cities.get(city);
        if (price == null) {
            throw new TourException("Unknown city " + city.getName());
        }

        return price;
    }

    public List<User> listUsers() {
        return tours.stream()
                .map(Tour::getUsers)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public List<Tour> listTours() {
        return tours;
    }

    public List<City> listCities() {
        return new ArrayList<>(cities.keySet());
    }

    public Tour createTour(List<User> users, City city) {
        Integer priceForCity = cities.get(city);
        if (priceForCity == null) {
            throw new TourException("Unknown city " + city.getName());
        }

        int price = priceForCity * users.size();

        Tour tour = new Tour(city, users, price);
        tours.add(tour);

        return tour;
    }
}

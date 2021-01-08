package lab4;

import lab4.model.City;
import lab4.model.Tour;
import lab4.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TourController {
    private final TourService tourService;

    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @RequestMapping("/get-all-cities")
    public List<City> getAllCities() {
        return tourService.listCities();
    }

    @RequestMapping("/get-all-users")
    public List<User> getAllUsers() {
        return tourService.listUsers();
    }

    @RequestMapping("/get-all-tours")
    public List<Tour> getAllTours() {
        return tourService.listTours();
    }

    @RequestMapping("/get-city-price")
    public int getCityPrice(@RequestParam("city") String city) {
        return tourService.cityPrice(new City(city));
    }

    @RequestMapping("/create-tour")
    public Tour createTour(@RequestParam("users") List<String> users,
                           @RequestParam("city") String city) {

        List<User> userList = users
                .stream()
                .map(User::new)
                .collect(Collectors.toList());

        return tourService.createTour(userList, new City(city));
    }
}

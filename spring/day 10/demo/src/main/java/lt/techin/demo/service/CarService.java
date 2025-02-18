package lt.techin.demo.service;

import lt.techin.demo.model.Car;
import lt.techin.demo.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> findAllCars() {
        return carRepository.findAll();
    }

    public Optional<Car> findCarBYID(long id) {
        return carRepository.findById(id);
    }

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    public boolean existsCarById(long id) {
        return carRepository.existsById(id);
    }

    public void deleteCarById(long id) {
        carRepository.deleteById(id);
    }

    public List<Car> findAllCarsByStatus() {
        return carRepository.findAll().stream().filter(car -> car.getStatus().contains("AVAILABLE")).toList();
    }

    
}

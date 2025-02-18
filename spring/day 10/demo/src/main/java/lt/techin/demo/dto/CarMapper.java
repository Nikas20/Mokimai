package lt.techin.demo.dto;

import lt.techin.demo.model.Car;

import java.util.List;

public class CarMapper {
    public static List<CarResponseDTO> toCarDTOList(List<Car> cars) {
        List<CarResponseDTO> result = cars.stream()
                .map(car -> new CarResponseDTO(car.getId(), car.getRentals(), car.getBrand(), car.getModel(), car.getYear(), car.getStatus()))
                .toList();
        return result;
    }

    public static CarResponseDTO toCarDTO(Car car) {
        return new CarResponseDTO(car.getId(), car.getRentals(), car.getBrand(), car.getModel(), car.getYear(), car.getStatus());
    }

    public static Car toCar(CarResponseDTO carResponseDTO) {
        Car car = new Car();
        car.setBrand(carResponseDTO.brand());
        car.setModel(carResponseDTO.model());
        car.setRentals(carResponseDTO.rentals());
        car.setYear(carResponseDTO.year());
        car.setStatus(carResponseDTO.status());
        return car;
    }

    public static void updateCarFromDTO(Car car, CarResponseDTO carResponseDTO) {
        car.setBrand(carResponseDTO.brand());
        car.setModel(carResponseDTO.model());
        car.setRentals(carResponseDTO.rentals());
        car.setYear(carResponseDTO.year());
        car.setStatus(carResponseDTO.status());
    }
}

package lt.techin.demo.controler;


import jakarta.validation.Valid;
import lt.techin.demo.dto.CarMapper;
import lt.techin.demo.dto.CarResponseDTO;
import lt.techin.demo.model.Car;
import lt.techin.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;


@RestController
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public ResponseEntity<List<CarResponseDTO>> getCars() {
        return ResponseEntity.ok(CarMapper.toCarDTOList(carService.findAllCars()));
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<CarResponseDTO> getCar(@PathVariable long id) {
        Optional<Car> carFind = carService.findCarBYID(id);

        if (carFind.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(CarMapper.toCarDTO(carFind.get()));
    }

    @PostMapping("/cars")
    public ResponseEntity<?> saveCar(@Valid @RequestBody CarResponseDTO carResponseDTO) {
        Car car = carService.saveCar(CarMapper.toCar(carResponseDTO));

        return ResponseEntity.created(
                        ServletUriComponentsBuilder.fromCurrentRequest()
                                .path("/{id}")
                                .buildAndExpand(car.getId())
                                .toUri())
                .body(CarMapper.toCarDTO(car));
    }

    @PutMapping("/cars/{id}")
    public ResponseEntity<?> updateCar(@PathVariable long id, @Valid @RequestBody CarResponseDTO carResponseDTO) {

        if (carService.existsCarById(id)) {
            Car carFind = carService.findCarBYID(id).get();

            CarMapper.updateCarFromDTO(carFind, carResponseDTO);

            carService.saveCar(carFind);

            return ResponseEntity.ok((carService.saveCar(carFind)));
        }
        Car savedCar = carService.saveCar(CarMapper.toCar(carResponseDTO));

        return ResponseEntity.created(
                        ServletUriComponentsBuilder.fromCurrentRequest()
                                .replacePath("/cars/{id}")
                                .buildAndExpand(savedCar.getId())
                                .toUri())
                .body(carResponseDTO);
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable long id) {

        if (!carService.existsCarById(id)) {
            return ResponseEntity.notFound().build();
        }
        if (carService.findCarBYID(id).stream().map(car -> car.getStatus().equals("AVAILABLE")).isParallel()) {
            return ResponseEntity.badRequest().build();
        }
        carService.deleteCarById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/cars/available")
    public ResponseEntity<List<CarResponseDTO>> getCarsByStatus() {
        return ResponseEntity.ok(CarMapper.toCarDTOList(carService.findAllCarsByStatus()));
    }
}

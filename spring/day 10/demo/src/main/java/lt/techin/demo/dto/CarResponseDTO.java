package lt.techin.demo.dto;

import org.springframework.boot.context.properties.bind.Name;

public record CarResponseDTO(long id, java.util.List<lt.techin.demo.model.Rental> rentals, String brand, String model,
                             int year,
                             String status) {
}

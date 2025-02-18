package lt.techin.demo.dto;

public record RentalDTO(long carId, long id, long userId, java.time.LocalDate rentalStart,
                        java.time.LocalDate rentalEnd, java.math.BigDecimal price) {
}

package lt.techin.demo.dto;

import lt.techin.demo.model.Rental;

import java.util.List;

public class RentalMapper {
    public static List<RentalDTO> toRentalDTOList(List<Rental> rentals) {
        List<RentalDTO> result = rentals.stream()
                .map(rental -> new RentalDTO(rental.getCar_Id(), rental.getId(), rental.getUser_Id(), rental.getRentalStart(), rental.getRentalEnd(), rental.getPrice()))
                .toList();
        return result;
    }

    public static RentalDTO toRentalDTO(Rental rental) {
        return new RentalDTO(rental.getCar_Id(), rental.getId(), rental.getUser_Id(), rental.getRentalStart(), rental.getRentalEnd(), rental.getPrice());
    }

    public static Rental toRental(RentalDTO rentalDTO) {
        Rental rental = new Rental();
        rental.setUser_Id(rentalDTO.userId());
        rental.setCar_Id(rentalDTO.carId());
        rental.setRentalStart(rentalDTO.rentalStart());
        rental.setRentalEnd(rentalDTO.rentalEnd());
        rental.setPrice(rentalDTO.price());
        return rental;
    }

    public static void updateRentalFromDTO(Rental rental, RentalDTO rentalDTO) {
        rental.setUser_Id(rentalDTO.userId());
        rental.setCar_Id(rentalDTO.carId());
        rental.setRentalStart(rentalDTO.rentalStart());
        rental.setRentalEnd(rentalDTO.rentalEnd());
        rental.setPrice(rentalDTO.price());
    }
}

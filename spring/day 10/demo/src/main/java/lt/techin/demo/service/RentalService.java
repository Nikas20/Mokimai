package lt.techin.demo.service;

import lt.techin.demo.model.Rental;
import lt.techin.demo.repository.RentalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RentalService {
    private final RentalRepository rentalRepository;

    public RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    public List<Rental> findAllRental() {
        return rentalRepository.findAll();
    }

    public Optional<Rental> findRentalBYID(long id) {
        return rentalRepository.findById(id);
    }

    public Rental saveRental(Rental rental) {
        return rentalRepository.save(rental);
    }

    public boolean existsRentalById(long id) {
        return rentalRepository.existsById(id);
    }

    public void deleteRentalById(long id) {
        rentalRepository.deleteById(id);
    }
}

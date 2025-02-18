package lt.techin.demo.controler;

import jakarta.validation.Valid;
import lt.techin.demo.dto.RentalDTO;
import lt.techin.demo.dto.RentalMapper;
import lt.techin.demo.model.Rental;
import lt.techin.demo.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
public class RentalControler {

    private final RentalService rentalService;

    @Autowired
    public RentalControler(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/rentals")
    public ResponseEntity<List<RentalDTO>> getRentals() {
        return ResponseEntity.ok(RentalMapper.toRentalDTOList(rentalService.findAllRental()));
    }

    @GetMapping("/rentals{id}")
    public ResponseEntity<RentalDTO> getRental(@PathVariable long id) {
        Optional<Rental> rentalFind = rentalService.findRentalBYID(id);

        if (rentalFind.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(RentalMapper.toRentalDTO(rentalFind.get()));
    }

    @PostMapping("/rentals")
    public ResponseEntity<?> saveRental(@Valid @RequestBody RentalDTO rentalDTO) {
        Rental rental = rentalService.saveRental(RentalMapper.toRental(rentalDTO));

        return ResponseEntity.created(
                        ServletUriComponentsBuilder.fromCurrentRequest()
                                .path("/{id}")
                                .buildAndExpand(rental.getId())
                                .toUri())
                .body(RentalMapper.toRentalDTO(rental));
    }

    @PutMapping("/rentals/{id}")
    public ResponseEntity<?> updateRental(@PathVariable long id, @Valid @RequestBody RentalDTO rentalDTO) {

        if (rentalService.existsRentalById(id)) {
            Rental rentalFind = rentalService.findRentalBYID(id).get();

            RentalMapper.updateRentalFromDTO(rentalFind, rentalDTO);

            rentalService.saveRental(rentalFind);

            return ResponseEntity.ok((rentalService.saveRental(rentalFind)));
        }
        Rental savedRental = rentalService.saveRental(RentalMapper.toRental(rentalDTO));

        return ResponseEntity.created(
                        ServletUriComponentsBuilder.fromCurrentRequest()
                                .replacePath("/rentals/{id}")
                                .buildAndExpand(savedRental.getId())
                                .toUri())
                .body(rentalDTO);
    }

    @DeleteMapping("/rentals/{id}")
    public ResponseEntity<?> deleteRental(@PathVariable long id) {

        if (!rentalService.existsRentalById(id)) {
            return ResponseEntity.notFound().build();
        }
        rentalService.deleteRentalById(id);
        return ResponseEntity.noContent().build();
    }

}

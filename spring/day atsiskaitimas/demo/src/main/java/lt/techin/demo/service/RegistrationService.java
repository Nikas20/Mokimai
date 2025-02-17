package lt.techin.demo.service;

import lt.techin.demo.model.Registration;
import lt.techin.demo.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

  private final RegistrationRepository registrationRepository;


  public RegistrationService(RegistrationRepository registrationRepository) {
    this.registrationRepository = registrationRepository;
  }

  public Registration saveRegistration(Registration registration) {
    return registrationRepository.save(registration);
  }
}

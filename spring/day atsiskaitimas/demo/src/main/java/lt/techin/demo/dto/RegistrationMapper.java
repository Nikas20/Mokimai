package lt.techin.demo.dto;

import lt.techin.demo.model.Registration;

import java.util.List;

public class RegistrationMapper {

  public static List<RegistrationRequestDTO> toRegistrationRequestDTOList(List<Registration> registrations) {
    List<RegistrationRequestDTO> result = registrations.stream()
            .map(registration -> new RegistrationRequestDTO(registration.getUser()))
            .toList();
    return result;
  }

  public static RegistrationRequestDTO toRegistrationRequestDTO(Registration registration) {
    return new RegistrationRequestDTO(registration.getUser());
  }

  public static Registration toRegistration(RegistrationRequestDTO registrationRequestDTO) {
    Registration registration = new Registration();
    registration.setUser(registrationRequestDTO.user());
    return registration;
  }

  public static List<RegistrationResponseDTO> toRegistrationResponseDTOList(List<Registration> registrations) {
    List<RegistrationResponseDTO> result = registrations.stream()
            .map(registration -> new RegistrationResponseDTO(registration.getId(), registration.getUser().getId(), registration.getRunningEvent().getName(), registration.getRegistrationDate()))
            .toList();
    return result;
  }

  public static RegistrationResponseDTO toRegistrationResponseDTO(Registration registration) {
    return new RegistrationResponseDTO(registration.getId(), registration.getUser().getId(), registration.getRunningEvent().getName(), registration.getRegistrationDate());
  }
}

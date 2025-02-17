package lt.techin.demo.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lt.techin.demo.dto.*;
import lt.techin.demo.model.Registration;
import lt.techin.demo.model.RunningEvent;
import lt.techin.demo.repository.RunningEventRepository;
import lt.techin.demo.service.RegistrationService;
import lt.techin.demo.service.RunningEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RuninigEventController {

  private final RunningEventService runningEventService;
  private final RegistrationService registrationService;

  public RuninigEventController(RunningEventService runningEventService, RegistrationService registrationService) {
    this.runningEventService = runningEventService;
    this.registrationService = registrationService;
  }


  @PostMapping("/events")
  public ResponseEntity<RunningEventResponseDTO> addEvent(@Valid @RequestBody RunningEventRequestDTO runningEventRequestDTO) {

    RunningEvent savedEvent = runningEventService.saveRunningEvent(RunningEventMapper.toRunningEvent(runningEventRequestDTO));

    return ResponseEntity.created(
                    ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(savedEvent.getId())
                            .toUri())
            .body(RunningEventMapper.toRunningEventResponseDTO(savedEvent));
  }

  @DeleteMapping("/events/{eventId}")
  public ResponseEntity<Void> deleteEvent(@PathVariable long eventId) {
    if (!runningEventService.existsRunningEventById(eventId)) {
      return ResponseEntity.notFound().build();
    }

    runningEventService.deleteRunningEventById(eventId);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/events")
  public ResponseEntity<List<RunningEventResponseDTO>> getEvents() {
    return ResponseEntity.ok(RunningEventMapper.toRunningEventResponseDTOList(runningEventService.findAllRunningEvent()));
  }

  @PostMapping("/events/{eventId}/register")
  public ResponseEntity<RegistrationResponseDTO> addEvent(@Valid @RequestBody RegistrationRequestDTO registrationRequestDTO) {

    Registration savedEvent = registrationService.saveRegistration(RegistrationMapper.toRegistration(registrationRequestDTO));

    return ResponseEntity.created(
                    ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(savedEvent.getId())
                            .toUri())
            .body(RegistrationMapper.toRegistrationResponseDTO(savedEvent));
  }
}

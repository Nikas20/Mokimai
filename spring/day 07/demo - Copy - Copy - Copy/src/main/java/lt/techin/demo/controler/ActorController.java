package lt.techin.demo.controler;

import jakarta.validation.Valid;
import lt.techin.demo.dto.ActorDTO;
import lt.techin.demo.dto.ActorMapper;
import lt.techin.demo.model.Actor;
import lt.techin.demo.service.ActorSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ActorController {

  private final ActorSevice actorSevice;

  @Autowired
  public ActorController(ActorSevice actorSevice) {
    this.actorSevice = actorSevice;
  }

  @PostMapping("/actors")
  public ResponseEntity<?> addActor(@Valid @RequestBody ActorDTO actorDTO) {

    Actor savedActor = actorSevice.saveActor(ActorMapper.toActor(actorDTO));

    return ResponseEntity.created(
                    ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(savedActor.getId())
                            .toUri())
            .body(ActorMapper.toActorDTO(savedActor));
  }
}

package lt.techin.demo.controler;

import lt.techin.demo.model.Actor;
import lt.techin.demo.service.ActorSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ActorController {

  private ActorSevice actorSevice;
  @Autowired
  public ActorController(ActorSevice actorSevice){
    this.actorSevice = actorSevice;
  }

  @PostMapping("/categories")
  public ResponseEntity<?> addActor(@RequestBody Actor actor) {

    Actor savedActor = actorSevice.saveActor(actor);

    return ResponseEntity.created(
                    ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(savedActor.getId())
                            .toUri())
            .body(savedActor);
  }
}

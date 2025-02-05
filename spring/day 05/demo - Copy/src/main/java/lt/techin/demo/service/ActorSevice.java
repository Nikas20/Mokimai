package lt.techin.demo.service;

import lt.techin.demo.model.Actor;
import lt.techin.demo.repository.ActorRepository;
import org.springframework.stereotype.Service;

@Service
public class ActorSevice {

private final ActorRepository actorRepository;

  public ActorSevice(ActorRepository actorRepository) {
    this.actorRepository = actorRepository;
  }

  public Actor saveActor(Actor actor){
    return actorRepository.save(actor);
  }
}

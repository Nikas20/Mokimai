package lt.techin.demo.dto;

import lt.techin.demo.model.Actor;

public class ActorMapper {

  public static ActorDTO toActorDTO(Actor actor) {
    return new ActorDTO(actor.getId(), actor.getFirstName(), actor.getLastName());
  }

  public static Actor toActor(ActorDTO actorDTO) {
    Actor actor = new Actor();
    actor.setFirstName(actorDTO.firstName());
    actor.setLastName(actorDTO.lastName());
    return actor;
  }
}
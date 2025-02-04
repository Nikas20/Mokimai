package lt.techin.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "actors")
public class Actor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Size(min = 1)
  private long id;

  private String firstName;
  private String lastName;

  public Actor() {
  }

  public long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}


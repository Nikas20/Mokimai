package lt.techin.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "actors")
public class Actor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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

  @Size(min = 2, max = 50)
  @Pattern(regexp = "^[A-z][a-z]+$")
  public String getLastName() {
    return lastName;
  }

  @Size(min = 2, max = 50)
  @Pattern(regexp = "^[A-z][a-z]+$")
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}


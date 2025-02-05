package lt.techin.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Table(name = "screenings")
public class Screening {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  
  private long id;

  @Size(min = 2, max = 100)
  private String kinotiatroPavadinimas;
  private LocalDateTime dataIrLaikas;

  public long getId() {
    return id;
  }

  public String getKinotiatroPavadinimas() {
    return kinotiatroPavadinimas;
  }

  public void setKinotiatroPavadinimas(String kinotiatroPavadinimas) {
    this.kinotiatroPavadinimas = kinotiatroPavadinimas;
  }

  public LocalDateTime getDataIrLaikas() {
    return dataIrLaikas;
  }

  public void setDataIrLaikas(LocalDateTime dataIrLaikas) {
    this.dataIrLaikas = dataIrLaikas;
  }
}

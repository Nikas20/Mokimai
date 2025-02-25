package lt.techin.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Table(name = "screenings")
public class Screening {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Size(min = 1)
  private long id;

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

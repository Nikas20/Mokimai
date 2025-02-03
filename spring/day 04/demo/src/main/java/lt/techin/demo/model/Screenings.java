package lt.techin.demo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "screenings")
public class Screenings {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String kinotiatro_pavadinimas;
  private LocalDateTime data_ir_laikas;

  public long getId() {
    return id;
  }

  public String getKinotiatro_pavadinimas() {
    return kinotiatro_pavadinimas;
  }

  public void setKinotiatro_pavadinimas(String kinotiatro_pavadinimas) {
    this.kinotiatro_pavadinimas = kinotiatro_pavadinimas;
  }

  public LocalDateTime getData_ir_laikas() {
    return data_ir_laikas;
  }

  public void setData_ir_laikas(LocalDateTime data_ir_laikas) {
    this.data_ir_laikas = data_ir_laikas;
  }
}

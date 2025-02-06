package lt.techin.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User implements UserDetails {


}

package lt.techin.demo.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String username;
  private String password;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
          name = "users_roles",
          joinColumns = @JoinColumn(name = "user_id"),
          inverseJoinColumns = @JoinColumn(name = "role_id")
  )
  private List<Role> roles;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id")
  private List<Registration> registrations;

  public User() {
  }

  public long getId() {
    return id;
  }


  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return roles;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String getPassword() {
    return password;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @Override
  public String getUsername() {
    return username;
  }

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }

  public List<Registration> getRegistrations() {
    return registrations;
  }

  public void setRegistrations(List<Registration> registrations) {
    this.registrations = registrations;
  }
}

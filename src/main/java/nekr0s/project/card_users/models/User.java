package nekr0s.project.card_users.models;

import javax.persistence.*;

// Small changes

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private int userId;

    @Column(name = "Email")
    private String email;

    @Column(name = "Password")
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User() {
        // keep empty
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

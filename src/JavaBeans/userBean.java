package JavaBeans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by JordanHope on 2/20/2016.
 */
@Entity
@Table(name="user")
public class userBean {
    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String password;

    public userBean(String username, String password) {
        this.username = username;
        this.password = password;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uname='" + username + '\'' +
                ", pword='" + password + '\''
                ;
    }

    public int getId() { return id; }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

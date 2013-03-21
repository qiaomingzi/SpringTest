package spring.jpa;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="T_USER")
@PrimaryKeyJoinColumn(name = "id")
public class User  implements Serializable { //
    private static final long serialVersionUID = 0L;

    @Column
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO IDENTITY SEQUENCE TABLE
    private long id;

    public User() {}

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

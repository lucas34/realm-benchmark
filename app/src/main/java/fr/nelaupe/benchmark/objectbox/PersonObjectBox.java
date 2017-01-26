package fr.nelaupe.benchmark.objectbox;


import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.Generated;

/**
 * Created with IntelliJ
 * Created by lucas
 * Date 26/03/15
 */
@Entity
public class PersonObjectBox {

    @Id
    private Long id;
    private String email;
    @Generated(hash = 814094080)
    public PersonObjectBox(Long id, String email) {
        this.id = id;
        this.email = email;
    }
    @Generated(hash = 2116492317)
    public PersonObjectBox() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}

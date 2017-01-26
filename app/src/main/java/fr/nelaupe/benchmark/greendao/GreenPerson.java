package fr.nelaupe.benchmark.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class GreenPerson {

    @Id
    private Long id;
    private String email;
    @Generated(hash = 741964502)
    public GreenPerson(Long id, String email) {
        this.id = id;
        this.email = email;
    }
    @Generated(hash = 532814550)
    public GreenPerson() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}

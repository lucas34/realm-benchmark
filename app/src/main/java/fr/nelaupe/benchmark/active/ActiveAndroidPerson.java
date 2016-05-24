package fr.nelaupe.benchmark.active;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created with IntelliJ
 * Created by lucas
 * Date 26/03/15
 */
@Table(name = "Person")
public class ActiveAndroidPerson extends Model {

    @Column(name = "email")
    private String email;

    public void setEmail(String email) {
        this.email = email;
    }

}

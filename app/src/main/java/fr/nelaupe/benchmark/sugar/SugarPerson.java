package fr.nelaupe.benchmark.sugar;

import com.orm.SugarRecord;

/**
 * Created with IntelliJ
 * Created by lucas
 * Date 26/03/15
 */

public class SugarPerson extends SugarRecord {

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

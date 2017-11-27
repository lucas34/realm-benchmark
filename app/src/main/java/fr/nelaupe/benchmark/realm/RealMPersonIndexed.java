package fr.nelaupe.benchmark.realm;

import io.realm.RealmObject;
import io.realm.annotations.Index;

/**
 * Created by lucas34990 on 27/11/17.
 */
public class RealMPersonIndexed extends RealmObject {

    private long id;
    @Index
    private String email;

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
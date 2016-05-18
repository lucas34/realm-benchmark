/**
 * Copyright
 */
package fr.nelaupe.benchmark.realm;

import android.content.Context;

import org.fluttercode.datafactory.impl.DataFactory;

import fr.nelaupe.benchmark.BenchmarkExecutor;
import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created with IntelliJ
 * Created by lucas
 * Date 26/03/15
 */
public class RealMBenchmark implements BenchmarkExecutor {

    private Realm realm;

    @Override
    public void setup(Context context) {
        RealmConfiguration realmConfig = new RealmConfiguration.Builder(context).build();
        realm = Realm.getInstance(realmConfig);

        realm.beginTransaction();
        realm.delete(RealMPerson.class);
        realm.commitTransaction();
    }

    @Override
    public long runInsertion(int iteration) {
        DataFactory dataFactory = new DataFactory();

        long start = System.currentTimeMillis();

        realm.beginTransaction();
        for (int i = 0; i < iteration; i++) {
            RealMPerson person = realm.createObject(RealMPerson.class);
            person.setId(i);
            person.setEmail(dataFactory.getEmailAddress());
        }
        realm.commitTransaction();

        return System.currentTimeMillis() - start;
    }

    @Override
    public long runQuery(String query) {
        long start = System.currentTimeMillis();
        realm.where(RealMPerson.class).contains("email", query, Case.SENSITIVE).findAll().size();
        return System.currentTimeMillis() - start;
    }

    @Override
    public void tearDown() {
        realm.close();
    }
}

package fr.nelaupe.benchmark.active;

import android.content.Context;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Select;

import org.fluttercode.datafactory.impl.DataFactory;

import fr.nelaupe.benchmark.BenchmarkExecutor;

/**
 * Created with IntelliJ
 * Created by lucas
 * Date 26/03/15
 */

public class ActiveAndroidBenchmark implements BenchmarkExecutor {

    @Override
    public void setup(Context context) {
        for(String db : context.databaseList()) {
            context.getDatabasePath(db).delete();
        }
//        new Delete().from(ActiveAndroidPerson.class).executeSingle(); ??
    }

    @Override
    public long runInsertion(int iteration) {
        DataFactory dataFactory = new DataFactory();

        ActiveAndroidPerson[] persons = new ActiveAndroidPerson[iteration];
        for (int i = 0; i < iteration; i++) {
            ActiveAndroidPerson person = new ActiveAndroidPerson();
            person.setEmail(dataFactory.getEmailAddress());
            persons[i] = person;
        }

        long start = System.currentTimeMillis();

        ActiveAndroid.beginTransaction();
        for (int i = 0, personsLength = persons.length; i < personsLength; i++) {
            persons[i].save();
        }
        ActiveAndroid.setTransactionSuccessful();
        ActiveAndroid.endTransaction();

        return System.currentTimeMillis() - start;
    }

    @Override
    public long runQuery(String query) {
        long start = System.currentTimeMillis();

        new Select().from(ActiveAndroidPerson.class).where("email = ?", query).execute().size();

        return System.currentTimeMillis() - start;
    }

    @Override
    public void tearDown() {
        ActiveAndroid.dispose();
    }

}

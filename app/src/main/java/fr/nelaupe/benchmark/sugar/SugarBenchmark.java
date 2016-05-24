package fr.nelaupe.benchmark.sugar;

import android.content.Context;

import org.fluttercode.datafactory.impl.DataFactory;

import fr.nelaupe.benchmark.BenchmarkExecutor;

/**
 * Created with IntelliJ
 * Created by lucas
 * Date 26/03/15
 */

public class SugarBenchmark implements BenchmarkExecutor {

    @Override
    public void setup(Context context) {
//        SugarRecord.deleteAll(SugarPerson.class);
    }

    @Override
    public long runInsertion(int iteration) {
        DataFactory dataFactory = new DataFactory();

        SugarPerson[] persons = new SugarPerson[iteration];
        for (int i = 0; i < iteration; i++) {
            SugarPerson person = new SugarPerson();
            person.setEmail(dataFactory.getEmailAddress());
            persons[i] = person;
        }

        long start = System.currentTimeMillis();
        SugarPerson.saveInTx(persons);
        return System.currentTimeMillis() - start;
    }

    @Override
    public long runQuery(String query) {
        long start = System.currentTimeMillis();

        SugarPerson.find(SugarPerson.class, "email = ?", query).size();

        return System.currentTimeMillis() - start;
    }

    @Override
    public void tearDown() {}

}

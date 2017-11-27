/**
 * Copyright
 */
package fr.nelaupe.benchmark.loop;

import android.content.Context;

import org.fluttercode.datafactory.impl.DataFactory;

import java.util.ArrayList;
import java.util.List;

import fr.nelaupe.benchmark.BenchmarkExecutor;
import fr.nelaupe.benchmark.greendao.GreenPerson;

/**
 * Created with IntelliJ
 * Created by lucas
 * Date 26/03/15
 */
public class LoopBenchmark implements BenchmarkExecutor {

    protected List<GreenPerson> database;

    @Override
    public void setup(Context context) {
    }

    @Override
    public long runInsertion(int iteration) {
        database = new ArrayList<>(iteration);

        final DataFactory dataFactory = new DataFactory();

        long start = System.currentTimeMillis();

        for (int i = 0; i < iteration; i++) {
            GreenPerson person = new GreenPerson();
            person.setEmail(dataFactory.getEmailAddress());
            database.add(person);
        }

        return System.currentTimeMillis() - start;
    }

    @Override
    public long runQuery(String query) {
        long start = System.nanoTime();

        for (GreenPerson person : database) {
            person.getEmail().contains(query);
        }

        return System.nanoTime() - start;
    }

    @Override
    public void tearDown() {
        database.clear();
    }
}

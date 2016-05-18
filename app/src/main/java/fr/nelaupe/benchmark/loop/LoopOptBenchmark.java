/**
 * Copyright
 */
package fr.nelaupe.benchmark.loop;

import fr.nelaupe.benchmark.greendao.GreenPerson;

/**
 * Created with IntelliJ
 * Created by lucas
 * Date 26/03/15
 */
public class LoopOptBenchmark extends LoopBenchmark {

    @Override
    public long runQuery(String query) {
        long start = System.currentTimeMillis();

        for (int i = 0, databaseSize = database.size(); i < databaseSize; i++) {
            GreenPerson person = database.get(i);
            person.getEmail().contains(query);
        }

        return System.currentTimeMillis() - start;
    }

}

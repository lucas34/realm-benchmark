/**
 * Copyright
 */
package fr.nelaupe.benchmark;

import android.content.Context;

/**
 * Created with IntelliJ
 * Created by lucas
 * Date 26/03/15
 */
public interface BenchmarkExecutor {

    void setup(Context context);
    long runInsertion(int iteration);
    long runQuery(String query);
    void tearDown();

}

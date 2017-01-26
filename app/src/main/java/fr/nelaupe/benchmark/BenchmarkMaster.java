/**
 * Copyright
 */
package fr.nelaupe.benchmark;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import fr.nelaupe.benchmark.objectbox.ObjectBoxBenchmark;
import fr.nelaupe.benchmark.realm.RealMBenchmark;

/**
 * Created with IntelliJ
 * Created by lucas
 * Date 26/03/15
 */
public class BenchmarkMaster {

    private static final int ITERATIONS = 50;
    private static final int NUMBER_ENTITIES = 20000;
    private Context context;

    public BenchmarkMaster(Context context) {
        this.context = context;
    }

    public void run() {
//        runBenchmark(new GreenDaoBenchmark());
//        runBenchmark(new LoopBenchmark());
//        runBenchmark(new LoopOptBenchmark());
        runBenchmark(new ObjectBoxBenchmark());
        runBenchmark(new RealMBenchmark());
    }

    public void runBenchmark(BenchmarkExecutor benchmark) {
        List<Long> resultsInsertion = new ArrayList<>();

        for (int i=0; i < ITERATIONS; i++) {
            benchmark.setup(context);
            resultsInsertion.add(benchmark.runInsertion(NUMBER_ENTITIES));
            benchmark.tearDown();
        }

        List<Long> resultsSearch = new ArrayList<>();

        benchmark.setup(context);
        benchmark.runInsertion(NUMBER_ENTITIES);
        for (int i=0; i < ITERATIONS; i++) {
            resultsSearch.add(benchmark.runQuery("u"));
        }
        benchmark.tearDown();

        Log.d("Benchmark", "" + benchmark.getClass() + " : insert=" + average(resultsInsertion));
        Log.d("Benchmark", "" + benchmark.getClass() + " : search=" + average(resultsSearch));
    }

    private long average(List<Long> data) {
        long sum = 0;
        long average;

        for(int i=0; i < data.size(); i++){
            sum = sum + data.get(i);
        }
        average = sum/data.size();
        return average;
    }

}

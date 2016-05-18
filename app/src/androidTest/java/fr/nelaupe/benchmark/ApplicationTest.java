package fr.nelaupe.benchmark;

import android.test.InstrumentationTestCase;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends InstrumentationTestCase {

    public void test() {
        BenchmarkMaster benchmarkMaster = new BenchmarkMaster(getInstrumentation().getTargetContext());
        benchmarkMaster.run();
    }

}
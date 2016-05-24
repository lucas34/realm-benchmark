package fr.nelaupe.benchmark;

import android.app.Application;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;
import com.orm.SugarContext;

import fr.nelaupe.benchmark.active.ActiveAndroidPerson;

/**
 * Created with IntelliJ
 * Created by lucas
 * Date 26/03/15
 */

public class BenchmarkApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        SugarContext.init(this);

        Configuration dbConfiguration = new Configuration.Builder(this).setModelClasses(ActiveAndroidPerson.class).setDatabaseName("active.db").setDatabaseVersion(1).create();
        ActiveAndroid.initialize(dbConfiguration);
    }

    @Override
    public void onTerminate() {
        SugarContext.terminate();
        super.onTerminate();
    }
}

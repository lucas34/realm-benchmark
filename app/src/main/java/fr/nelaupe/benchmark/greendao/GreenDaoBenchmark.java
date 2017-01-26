///**
// * Copyright
// */
//package fr.nelaupe.benchmark.greendao;
//
//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//
//import org.fluttercode.datafactory.impl.DataFactory;
//
//import fr.nelaupe.benchmark.BenchmarkExecutor;
//
///**
// * Created with IntelliJ
// * Created by lucas
// * Date 26/03/15
// */
//public class GreenDaoBenchmark implements BenchmarkExecutor {
//
//    private DaoSession session;
//    private DaoMaster master;
//
//    @Override
//    public void setup(Context context) {
//        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "whatever", null);
//        SQLiteDatabase db = helper.getWritableDatabase();
//
//        master = new DaoMaster(db);
//        session = master.newSession();
//        session.getGreenPersonDao().deleteAll();
//    }
//
//    @Override
//    public long runInsertion(final int iteration) {
//        final DataFactory dataFactory = new DataFactory();
//
//        final GreenPersonDao greenPersonDao = session.getGreenPersonDao();
//
//        long start = System.currentTimeMillis();
//        session.runInTx(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < iteration; i++) {
//                    GreenPerson person = new GreenPerson();
//                    person.setEmail(dataFactory.getEmailAddress());
//                    greenPersonDao.insert(person);
//                }
//            }
//        });
//        return System.currentTimeMillis() - start;
//    }
//
//    @Override
//    public long runQuery(String query) {
//        long start = System.currentTimeMillis();
//        session.getGreenPersonDao().queryBuilder().where(GreenPersonDao.Properties.Email.like("%"+query+"%")).buildCursor().forCurrentThread().query().getCount();
//        return System.currentTimeMillis() - start;
//    }
//
//    @Override
//    public void tearDown() {
//        master.getDatabase().close();
//    }
//
//}

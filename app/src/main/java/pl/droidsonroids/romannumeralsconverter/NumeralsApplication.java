package pl.droidsonroids.romannumeralsconverter;

import android.app.Application;
import android.content.Context;

import dagger.ObjectGraph;

public class NumeralsApplication extends Application {

    private ObjectGraph objectGraph;

    public static NumeralsApplication get(final Context context) {
        return (NumeralsApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        objectGraph = ObjectGraph.create(new NumeralsModule(this));
    }

    public ObjectGraph createScopedGraph(final Object... modules) {
        return objectGraph.plus(modules);
    }
}

package pl.droidsonroids.romannumeralsconverter.view;

import android.support.annotation.NonNull;

public class TestMainActivity extends MainActivity {

    @NonNull
    @Override
    protected Object[] getModules() {
        return new Object[] {new TestMainModule()};
    }
}

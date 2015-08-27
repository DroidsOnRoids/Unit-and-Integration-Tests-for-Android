package pl.droidsonroids.romannumeralsconverter.view;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.droidsonroids.romannumeralsconverter.NumeralsModule;
import pl.droidsonroids.romannumeralsconverter.presenter.MainPresenter;

import static org.mockito.Mockito.mock;

@Module(injects = {TestMainActivity.class, MainActivityTest.class}, addsTo = NumeralsModule.class, overrides = true)
public class TestMainModule {

    @Provides
    @Singleton
    MainPresenter provideMainPresenter() {
        return mock(MainPresenter.class);
    }
}

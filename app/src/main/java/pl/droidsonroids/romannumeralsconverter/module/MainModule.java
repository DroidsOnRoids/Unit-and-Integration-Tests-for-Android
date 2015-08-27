package pl.droidsonroids.romannumeralsconverter.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.droidsonroids.romannumeralsconverter.NumeralsModule;
import pl.droidsonroids.romannumeralsconverter.model.RomanNumeralConverter;
import pl.droidsonroids.romannumeralsconverter.presenter.MainPresenter;
import pl.droidsonroids.romannumeralsconverter.presenter.MainPresenterImpl;
import pl.droidsonroids.romannumeralsconverter.view.MainActivity;
import pl.droidsonroids.romannumeralsconverter.view.MainView;

@Module(injects = MainActivity.class, addsTo = NumeralsModule.class)
public class MainModule {

    private final MainView mainView;

    public MainModule(final MainView mainView) {
        this.mainView = mainView;
    }

    @Provides
    MainView provideMainView() {
        return mainView;
    }

    @Provides
    @Singleton
    MainPresenter provideMainPresenter(final MainView mainView, final RomanNumeralConverter romanNumeralConverter) {
        return new MainPresenterImpl(mainView, romanNumeralConverter);
    }
}

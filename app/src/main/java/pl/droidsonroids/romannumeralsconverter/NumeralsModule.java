package pl.droidsonroids.romannumeralsconverter;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.droidsonroids.romannumeralsconverter.model.RomanNumeralConverter;

@Module(library = true)
public class NumeralsModule {

    private final Context context;

    public NumeralsModule(final Context context) {
        this.context = context;
    }

    @Provides
    Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    RomanNumeralConverter provideRomanNumeralModel() {
        return new RomanNumeralConverter();
    }
}

package pl.droidsonroids.romannumeralsconverter.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.ObjectGraph;
import pl.droidsonroids.romannumeralsconverter.NumeralsApplication;
import pl.droidsonroids.romannumeralsconverter.R;
import pl.droidsonroids.romannumeralsconverter.module.MainModule;
import pl.droidsonroids.romannumeralsconverter.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainView {

    @Inject MainPresenter mainPresenter;

    @Bind(R.id.convert) Button convertButton;
    @Bind(R.id.number) EditText numberEdit;
    @Bind(R.id.result) TextView resultText;

    private ObjectGraph objectGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objectGraph = NumeralsApplication.get(this).createScopedGraph(getModules());
        objectGraph.inject(this);

        ButterKnife.bind(this);
    }

    @NonNull
    protected Object[] getModules() {
        return new Object[] {new MainModule(this)};
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        objectGraph = null;
    }

    @Override
    public void displayResult(final int arabicNumber, final String romanResult) {
        resultText.setText(getString(R.string.result, arabicNumber, romanResult));
    }

    @Override
    public void displayInvalidNumberError() {
        resultText.setText(R.string.error_invalid_number);
    }

    @Override
    public void displayNonPositiveNumberError() {
        resultText.setText(R.string.error_non_positive_number);
    }

    @OnClick(R.id.convert)
    public void onConvertClick() {
        mainPresenter.onConvertClick(numberEdit.getText().toString());
    }

    void inject(final Object target) {
        objectGraph.inject(target);
    }
}

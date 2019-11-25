package com.example.localizationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button btnEnglish, btnFrench;
    String mLanguageCode="fr";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.app_name);
        btnEnglish = findViewById(R.id.btnEnglish);
        btnFrench = findViewById(R.id.btnFrench);
        btnFrench.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View view) {
                mLanguageCode="fr";
                updateLanguage(mLanguageCode);

                //LocaleHelper.setLocale(MainActivity.this, mLanguageCode);
                recreate();
            }
        });
        btnEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLanguageCode="en";
                updateLanguage(mLanguageCode);

              //  LocaleHelper.setLocale(MainActivity.this, mLanguageCode);
                recreate();
            }
        });
    }

    @SuppressWarnings("deprecation")
    private void updateLanguage(String code) {
        Locale locale = new Locale(code);
        Locale.setDefault(locale);

        Resources res = this.getResources();
        Configuration config = new Configuration(res.getConfiguration());
        config.locale = locale;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            config.setLayoutDirection(locale);
        }

        res.updateConfiguration(config, res.getDisplayMetrics());
        recreate();

    }
}

package project.cst131.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import project.cst131.R;

public class ViewCharactersActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainapp);

        Toolbar appToolBar = findViewById(R.id.appToolBar);
        setSupportActionBar(appToolBar);

    }
}

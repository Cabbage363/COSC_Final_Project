package project.cst131.activities;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import project.cst131.R;
import project.cst131.controllers.IntentController;

public class MainActivity extends AppCompatActivity
{
    private Button btnCreateCharacter;
    private Button btnRandomlyCreate;
    private Button btnViewCharacters;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainapp);

        Toolbar appToolBar = findViewById(R.id.appToolBar);
        setSupportActionBar(appToolBar);

        btnCreateCharacter = findViewById(R.id.btnCreateCharacter);
        btnRandomlyCreate  = findViewById(R.id.btnRandomCreate);
        btnViewCharacters  = findViewById(R.id.btnViewCharacters);

        onClickSetup();

    }

    private void onClickSetup()
    {
        btnCreateCharacter.setOnClickListener(e -> {
            IntentController.swapIntent(e.getId());
        });

        btnRandomlyCreate.setOnClickListener(e -> {

        });

        btnViewCharacters.setOnClickListener(e -> {

        });
    }

}
package project.cst131.activities;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import project.cst131.R;
import project.cst131.controllers.IntentController;
import project.cst131.fragments.RacesFragment;
import project.cst131.information.Races;

public class MainActivity extends AppCompatActivity
{
    private Button btnCreateCharacter, btnRandomlyCreate, btnViewCharacters, btnScratch, btnParams;
    private ArrayList<Button> lstButtons;
    public static File file;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainapp);

        Toolbar appToolBar = findViewById(R.id.appToolBar);
        setSupportActionBar(appToolBar);

        btnCreateCharacter    =     findViewById(R.id.btnCreateCharacter);
        btnRandomlyCreate     =     findViewById(R.id.btnRandomCreate);
        btnViewCharacters     =     findViewById(R.id.btnViewCharacters);

        lstButtons = new ArrayList<>(Arrays.asList(btnCreateCharacter, btnRandomlyCreate, btnViewCharacters));

        onClickSetup();
        file =  getApplicationContext().getFilesDir();

    }

    private void onClickSetup()
    {
        lstButtons.forEach(x -> {
            x.setOnClickListener(e -> {
                IntentController.swapIntent(e.getId(), this);
            });
        });
    }

}
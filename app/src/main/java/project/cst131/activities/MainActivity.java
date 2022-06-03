package project.cst131.activities;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import project.cst131.R;
import project.cst131.controllers.IntentController;
import project.cst131.storageUtils.RandomCharacter;

public class MainActivity extends AppCompatActivity
{
    public static Activity activity;
    private Button btnCreateCharacter, btnRandomlyCreate, btnViewCharacters;
    private ArrayList<Button> lstButtons;
    public static File file;
    private final int STORAGE_PERMISSION_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        activity = this;
        if(ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) 
        {
//            Toast.makeText(this, "You already granted this permission!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            requestStoragePermission();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainapp);

//        Toolbar appToolBar = findViewById(R.id.appToolBar);
//        setSupportActionBar(appToolBar);

        btnCreateCharacter    =     findViewById(R.id.btnCreateCharacter);
        btnRandomlyCreate     =     findViewById(R.id.btnRandomCreate);
        btnViewCharacters     =     findViewById(R.id.btnViewCharacters);

        lstButtons = new ArrayList<>(Arrays.asList(btnCreateCharacter, btnViewCharacters));

        onClickSetup();
        file =  getApplicationContext().getFilesDir();

        btnRandomlyCreate.setOnClickListener(e -> RandomCharacter.createRandomCharacter());

    }

    private void onClickSetup()
    {
        lstButtons.forEach(x -> x.setOnClickListener(e -> IntentController.swapIntent(e.getId(), this)));
    }

    private void requestStoragePermission()
    {
        if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE))
        {
            new AlertDialog.Builder(this)
                    .setTitle("Permission needed")
                    .setMessage("Approval is required to save PDFs of Characters created!")
                    .setPositiveButton("Ok", (dialog, which) -> ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE))
                    .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                    .create()
                    .show();
        }
        else
        {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission GRANTED", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Permission NOT GRANTED", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
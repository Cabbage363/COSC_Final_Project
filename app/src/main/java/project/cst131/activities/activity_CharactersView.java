package project.cst131.activities;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import project.cst131.R;
import project.cst131.adapters.CharacterAdapter;
import project.cst131.controllers.dndCharacter;
import project.cst131.storageUtils.Character_File_Saver;

public class activity_CharactersView extends AppCompatActivity
{
    private Character_File_Saver character_file_saver;
    private ArrayList<dndCharacter> characterList;
    private RecyclerView characters;
    private RecyclerView.Adapter adapter;
    public static Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_characters);
        activity = this;

        Toolbar appToolBar = findViewById(R.id._tbViewCharacters);
        setSupportActionBar(appToolBar);

        character_file_saver = new Character_File_Saver();
        characterList = character_file_saver.getLstCharacters();

        this.characters = findViewById(R.id._rv_Characters);
        RecyclerView.LayoutManager mrg = new LinearLayoutManager(this);
        this.characters.setLayoutManager(mrg);

        adapter = new CharacterAdapter(characterList);
        this.characters.setAdapter(adapter);

    }
}

package project.cst131.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import project.cst131.R;

public class PersonalityBackgroundFragment extends Fragment
{
    private View view;
    private Spinner genderOptions,  alignments;
    private TextView tvTitle, tvFirstName, tvLastName, tvFeet, tvInch, tvBackground;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.frag_character_personality_and_background, container, false);
        genderOptions   =   view.findViewById(R.id.spGender);
        alignments      =   view.findViewById(R.id.spAlignment);
        tvTitle         =   view.findViewById(R.id.ettTitle);
        tvFirstName     =   view.findViewById(R.id.ettFirstName);
        tvLastName      =   view.findViewById(R.id.ettLastName);
        tvFeet          =   view.findViewById(R.id.ettFeet);
        tvInch          =   view.findViewById(R.id.ettInch);
        tvBackground    =   view.findViewById(R.id.etmBackground);


        ArrayAdapter<CharSequence> adapterG = ArrayAdapter.createFromResource(view.getContext(),
                R.array.genderOptions, android.R.layout.simple_spinner_item);
        adapterG.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderOptions.setAdapter(adapterG);

        ArrayAdapter<CharSequence> adapterA = ArrayAdapter.createFromResource(view.getContext(),
                R.array.alignment, android.R.layout.simple_spinner_item);
        adapterA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        alignments.setAdapter(adapterA);

        return view;
    }
}

package project.cst131.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import project.cst131.R;
import project.cst131.information.Choices;
import project.cst131.information.Races;

public class RacesFragment extends Fragment
{
    private ImageView ivRaceImage, ivButtonLeft, ivButtonRight;
    private TextView  tvRaceTitle, tvRacialDescription, tvRacialTraits;
    private static RadioGroup rgRaceSubs;
    private int index = 0;
    private static View view;
    private static String sChoice = "";
    private Spinner spinner;
    public List<String> spinnerArray = new ArrayList<>(Arrays.asList(
       "Black", "Blue", "Brass", "Bronze", "Copper", "Gold", "Green", "Red", "Silver", "White"
    ));


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.frag_character_races, container, false);

        ivRaceImage = view.findViewById(R.id.ivRaceImage);
        tvRaceTitle = view.findViewById(R.id.tvRaceTitle);
        rgRaceSubs = view.findViewById(R.id.rgRaceSubs);
        ivButtonLeft = view.findViewById(R.id.ivButtonLeft);
        ivButtonRight = view.findViewById(R.id.ivButtonRight);
        tvRacialDescription = view.findViewById(R.id.tvDescription);
        tvRacialTraits = view.findViewById(R.id.tvRadicalTraits);
        spinner = view.findViewById(R.id.spDragonType);

        updateRace();

        ivButtonLeft.setOnClickListener(e -> {
            decreaseIndex();
            updateRace();
        });

        ivButtonRight.setOnClickListener(e -> {
            increaseIndex();
            updateRace();
        });

        return view;
    }

    private void updateRace()
    {
        if(index == 0)
        {
            ivButtonLeft.setVisibility(View.GONE);
        }

        ivRaceImage.setImageResource(Races.lstPH_Races_Images.get(index));
        rgRaceSubs.removeAllViews();

        if(Races.lstPH_Races_Sub.get(index).size() > 1)
        {
            Races.lstPH_Races_Sub.get(index).forEach(x -> {
                RadioButton subRace = new RadioButton(view.getContext());
                subRace.setText(x);
                if(Races.lstPH_Races_Sub.get(index).get(0).equals(x))
                {
                    rgRaceSubs.addView(subRace);
                    TextView subRaceSection = new TextView(view.getContext());
                    subRaceSection.setText(R.string.subRaces);
                    rgRaceSubs.addView(subRaceSection);
                }
                else
                {
                    rgRaceSubs.addView(subRace);
                }

            });
        }
        else
        {
            RadioButton subRace = new RadioButton(view.getContext());
            subRace.setText(Races.lstPH_Races_Sub.get(index).get(0));
            rgRaceSubs.addView(subRace);
        }

        /**
         * Below is to help and maintaining previous choice.
         */
        int numChildren = rgRaceSubs.getChildCount();
        for(int i = 0; i < numChildren; i++)
        {
            RadioButton rb = (RadioButton) view.findViewById(rgRaceSubs.getChildAt(i).getId());
            rgRaceSubs.getChildAt(i).setOnClickListener(e ->{
                Choices.setRace((String) rb.getText());
            });
            try {
                if(rb.getText().equals(Choices.getRace()))
                {
                    ((RadioButton) view.findViewById(rgRaceSubs.getChildAt(i).getId())).setChecked(true);
                }
            }
            catch (Exception ignored)
            {

            }
        }

        /**
         * Updating Racial Description and traits below.
         */

        tvRacialDescription.setText(Races.lstPH_Races_Info.get(index).get(0));
        tvRacialTraits.setText(Races.lstPH_Races_Info.get(index).get(1));

        /**
         * Handles Spinner.
         */

        if(Races.lstPH_Races_Sub.get(index).get(0).equals("Dragonborn"))
        {
            spinner.setVisibility(View.VISIBLE);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                    view.getContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, spinnerArray);

            adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        }
        else
        {
            spinner.setVisibility(View.GONE);
        }

    }

    private void increaseIndex()
    {
        if(index == Races.lstPH_Races_Images.size() -1)
        {
            ivButtonRight.setVisibility(View.GONE);
        }
        else
        {
            ivButtonLeft.setVisibility(View.VISIBLE);
        }
        if(index != Races.lstPH_Races_Images.size() -1)
        {
            index++;
        }
    }

    private void decreaseIndex()
    {
        if(index == 0)
        {
            ivButtonLeft.setVisibility(View.GONE);
        }
        else
        {
            ivButtonRight.setVisibility(View.VISIBLE);
        }
        if(index != 0)
        {
            index--;
        }
    }

    public void saveRace()
    {

    }






}

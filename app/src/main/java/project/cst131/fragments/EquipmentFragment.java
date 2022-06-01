package project.cst131.fragments;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import project.cst131.R;
import project.cst131.information.Points;

public class EquipmentFragment extends Fragment
{
    private View view;
    private TextView tvWealth;
    private int wealth;
    private Points.ClassAbilityIncrease choice;
    private LinearLayout main;
    protected static ArrayList<RadioGroup> lstRadioGroups = new ArrayList<>();
    protected static String extraStuff;
    private Typeface font;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.frag_character_equipment, container, false);
        tvWealth = view.findViewById(R.id.tvWealth);
        main = view.findViewById(R.id.layoutMain);
        font = getResources().getFont(R.font.dnd_font);

        String sDie, sMulti, sAmount;

        choice = Points.ClassAbilityIncrease.valueOf(ClassesFragment.lstClasses.get(ClassesFragment.index).name());

        String money = (String) Points.ClassAbilityIncrease.valueOf(choice.getDeclaringClass(), choice.name()).getsMoney();

        if(money.contains("x"))
        {
            sDie = money.substring(money.indexOf("d")+1,money.indexOf("d") + 2);
            sMulti = money.substring(0, 1);
            sAmount = money.substring(money.length()-2);

            ArrayList<Integer> rolls = new ArrayList<>();
            for(int i=0; i< Integer.parseInt(sMulti); i++)
            {
                rolls.add(rollDie(sDie));
            }

            rolls.forEach(x -> rolls.set(rolls.indexOf(x), x * Integer.parseInt(sAmount)));
            
            wealth = rolls.stream().mapToInt(x-> x).sum();
    
        }
        tvWealth.setText(String.valueOf(wealth));
        generateEquipChoices();
        return view;
    }


    private int rollDie(String sVal)
    {
        return (int) Math.floor((Math.random() * Integer.parseInt(sVal)) + 1);
    }

    @SuppressLint("SetTextI18n")
    private void generateEquipChoices()
    {
        ArrayList<String> lstChoice = choice.getsStartWeapons();

        for (String choicesString : lstChoice)
        {
            String[] choices = choicesString.split(",");
            TextView choicesLabel = new TextView(view.getContext());
            choicesLabel.setTypeface(font, Typeface.BOLD);
            choicesLabel.setTextSize(20);

            if(choices.length == 1)
            {
                TextView extra = new TextView(view.getContext());
                extra.setText(R.string.included);
                extra.setTypeface(font, Typeface.BOLD);
                extra.setTextSize(20);
                main.addView(extra);
                choicesLabel.setText(choices[choices.length-1]);
                main.addView(choicesLabel);
                extraStuff = String.valueOf(R.string.included);
            }
            else
            {
                choicesLabel.setText(R.string.select, TextView.BufferType.NORMAL);
                choicesLabel.layout(0,0,0,0);
                RadioGroup radioGroup = new RadioGroup(view.getContext());
                main.addView(choicesLabel);
                for (String choice : choices)
                {
                    RadioButton radioButton = new RadioButton(view.getContext());
                    radioButton.setText(choice);
                    radioButton.setTypeface(font, Typeface.BOLD);
                    radioButton.setTextSize(20);
                    radioGroup.addView(radioButton);
                }
                lstRadioGroups.add(radioGroup);
                main.addView(radioGroup);
            }

        }

    }
}

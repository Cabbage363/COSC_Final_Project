package project.cst131.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;

import project.cst131.R;
import project.cst131.information.Points;
import project.cst131.information.Races;

public class ClassesFragment extends Fragment
{
    private View view;
    protected static ArrayList<Points.ClassAbilityIncrease> lstClasses;
    private TextView tvClassName, tvHitDieVal, tvProfPlusVal, tvProf_AW_Val, tvProf_ST_Val, tvToolsVal, tvSkillNum, tvSkills;
    private ImageView ivRight, ivLeft;
    protected static int index = 0;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.frag_character_classes, container, false);

        tvClassName    =    view.findViewById(R.id.tvClassHeader);
        tvHitDieVal    =    view.findViewById(R.id.tvHitDie_Val);
        tvProfPlusVal  =    view.findViewById(R.id.tvProfPlus_Val);
        tvProf_AW_Val  =    view.findViewById(R.id.tvProf_AW_Val);
        tvProf_ST_Val  =    view.findViewById(R.id.tvSavThr_Val);
        tvToolsVal     =    view.findViewById(R.id.tvTools_Val);
        tvSkillNum     =    view.findViewById(R.id.tvSkill_Num_Val);
        tvSkills       =    view.findViewById(R.id.tvSkills_Val);
        ivLeft       =    view.findViewById(R.id.ivButtonLeft2);
        ivRight       =    view.findViewById(R.id.ivButtonRight2);
        lstClasses = new ArrayList<>(Arrays.asList(Points.ClassAbilityIncrease.values()));

        updateView();

        ivRight.setOnClickListener(e -> {
            increaseIndex();
            updateView();
        });

        ivLeft.setOnClickListener(e -> {
            decreaseIndex();
            updateView();
        });

        return view;
    }

    private void updateView()
    {
        if(index == 0)
        {
            ivLeft.setVisibility(View.GONE);
        }

        Points.ClassAbilityIncrease current = lstClasses.get(index);

        tvClassName.setText(String.valueOf(current.name()));
        tvHitDieVal.setText(String.valueOf(current.getHitDie()));
        tvProfPlusVal.setText(String.valueOf(current.getProf()));
        tvProf_AW_Val.setText(String.valueOf(current.getsProf_AW()));
        tvProf_ST_Val.setText(String.valueOf(current.getsProf_ST()));
        tvToolsVal.setText(String.valueOf(current.getsTools()));
        tvSkillNum.setText(String.valueOf(current.getSkillNum()));
        tvSkills.setText(String.valueOf(current.getsSkills()));
    }

    private void increaseIndex()
    {
        if(index == lstClasses.size() -2)
        {
            ivRight.setVisibility(View.GONE);
        }
        else
        {
            ivLeft.setVisibility(View.VISIBLE);
        }
        if(index != lstClasses.size() -1)
        {
            index++;
        }
    }

    private void decreaseIndex()
    {
        if(index == 0)
        {
            ivLeft.setVisibility(View.GONE);
        }
        else
        {
            ivRight.setVisibility(View.VISIBLE);
        }
        if(index != 0)
        {
            index--;
        }
    }
}

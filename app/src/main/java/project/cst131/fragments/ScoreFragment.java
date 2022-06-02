package project.cst131.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import project.cst131.R;
import project.cst131.information.Points;

public class ScoreFragment extends Fragment
{

    private View view;
    private Button btnStr, btnDex, btnCon, btnInt, btnWis, btnChar, btnRollAll;
    private TextView tvStr, tvDex, tvCon, tvInt, tvWis, tvChar;
    private ArrayList<Button> lstButtons = new ArrayList<>();
    private static ArrayList<TextView> lstTextVals = new ArrayList<>();


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.frag_ability, container, false);

        btnRollAll  =   view.findViewById(R.id.btnRollAll   );
        btnStr      =   view.findViewById(R.id.btnRollStr   );
        btnDex      =   view.findViewById(R.id.btnRollDex   );
        btnCon      =   view.findViewById(R.id.btnRollCon   );
        btnInt      =   view.findViewById(R.id.btnRollIntel );
        btnWis      =   view.findViewById(R.id.btnRollWis   );
        btnChar     =   view.findViewById(R.id.btnRollChari );

        lstButtons.addAll(Arrays.asList(btnStr, btnDex, btnCon, btnInt, btnWis, btnChar));

        tvStr       =   view.findViewById(R.id.tvStrVal   );
        tvDex       =   view.findViewById(R.id.tvDexVal   );
        tvCon       =   view.findViewById(R.id.tvConStr   );
        tvInt       =   view.findViewById(R.id.tvIntVal   );
        tvWis       =   view.findViewById(R.id.tvWisVal   );
        tvChar      =   view.findViewById(R.id.tvCharVal  );

        lstTextVals.addAll(Arrays.asList(tvStr, tvDex, tvCon, tvInt, tvWis, tvChar));

        btnRollAll.setOnClickListener(e->rollAll());

        lstButtons.forEach(x -> rollAndSet(x, lstTextVals.get(lstButtons.indexOf(x))));

        return view;
    }

    private void rollAll()
    {
        lstTextVals.forEach(x -> {
            x.setText(String.valueOf(rollD20()));
        });
    }

    private void rollAndSet(Button btn, TextView tv)
    {
        btn.setOnClickListener(e -> tv.setText(String.valueOf(rollD20())));
    }

    public int rollD20()
    {
        return (int) Math.floor((Math.random() * 20) + 1);
    }

    public static ArrayList<Integer> getRolls()
    {
        ArrayList<Integer> lstRolls = new ArrayList<>();
        lstTextVals.forEach(x-> lstRolls.add(Integer.parseInt((String) x.getText())));

        return lstRolls;
    }
}

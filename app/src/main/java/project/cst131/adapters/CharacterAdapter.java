package project.cst131.adapters;

import static project.cst131.information.Races.lstPH_Races_Images;
import static project.cst131.information.Races.lstPH_Races_Sub;
import static project.cst131.storageUtils.pdf_generation.createPDF;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import project.cst131.R;
import project.cst131.controllers.dndCharacter;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ViewHolder>
{
    private static ArrayList<dndCharacter> characters;

    public CharacterAdapter(ArrayList<dndCharacter> characters)
    {
        this.characters = characters;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_character, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {

        dndCharacter character = characters.get(position);

        holder.raceImage.setImageResource(lstPH_Races_Images.get(character.getIndexOfRace()));
        holder.title .setText(new StringBuilder().append(character.getsTitle()));
        holder.name.setText(character.getsFirstName() + character.getsLastName());
        holder.race.setText(new StringBuilder().append(character.getsRace()));
        holder.chosenClass.setText(new StringBuilder().append(character.getsClass()));

        holder.str.setText(new StringBuilder().append(character.getLstAbilityScores().get(0)).append(character.getStr() == 0 ? "" : " +" + character.getStr()));
        holder.dex.setText(new StringBuilder().append(character.getLstAbilityScores().get(1)).append(character.getDex() == 0 ? "" : " +" + character.getDex()));
        holder.con.setText(new StringBuilder().append(character.getLstAbilityScores().get(2)).append(character.getCon() == 0 ? "" : " +" + character.getCon()));
        holder.intel.setText(new StringBuilder().append(character.getLstAbilityScores().get(3)).append(character.getIntel() == 0 ? "" : " +" + character.getIntel()));
        holder.wis.setText(new StringBuilder().append(character.getLstAbilityScores().get(4)).append(character.getWis() == 0 ? "" : " +" + character.getWis()));
        holder.cha.setText(new StringBuilder().append(character.getLstAbilityScores().get(5)).append(character.getCharis() == 0 ? "" : " +" + character.getCharis()));
        holder.btn.setOnClickListener(e -> {
            Toast.makeText(e.getContext(), "View Downloads for PDF", Toast.LENGTH_SHORT).show();
            createPDF(character);
        });

    }

    @Override
    public int getItemCount()
    {
        if(characters != null)
        {
            return characters.size();
        }
        else
        {
            return 0;
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public final View view;
        public final ImageView raceImage;
        public final TextView title, name, race, chosenClass, str, dex, con, intel, wis, cha;
        public final Button btn;

        public ViewHolder(View view)
        {
            super(view);
            this.view           =   view;
            this.raceImage      =   view.findViewById(R.id.ivRace);
            this.title          =   view.findViewById(R.id.tvTitleVal);
            this.name           =   view.findViewById(R.id.tvNameVal);
            this.race           =   view.findViewById(R.id.tvRaceVal);
            this.chosenClass    =   view.findViewById(R.id.tvClassVal);
            this.str            =   view.findViewById(R.id.tvStrenghtVal);
            this.dex            =   view.findViewById(R.id.tvDextVal);
            this.con            =   view.findViewById(R.id.tvConstVal);
            this.intel          =   view.findViewById(R.id.tvIntelVal);
            this.wis            =   view.findViewById(R.id.tvWisdomVal);
            this.cha            =   view.findViewById(R.id.tvCharismaVal);
            this.btn            =   view.findViewById(R.id.btnPDF_View);
        }

    }

}

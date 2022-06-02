package project.cst131.adapters;

import static project.cst131.information.Races.lstPH_Races_Images;
import static project.cst131.information.Races.lstPH_Races_Sub;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
        View v = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_character, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {

        dndCharacter character = characters.get(position);

        lstPH_Races_Sub.forEach(x-> x.contains(character.getsRace()));

        holder.raceImage.setImageResource(lstPH_Races_Images.get(0));
        holder.title .setText(new StringBuilder().append(character.getsTitle()));
        holder.name.setText(new StringBuilder().append(character.getsFirstName()).append(character.getsLastName()).toString());
        holder.race.setText(new StringBuilder().append(character.getsRace()));
        holder.chosenClass.setText(new StringBuilder().append(character.getsClass()));

        holder.str.setText(new StringBuilder().append(    character.getLstAbilityScores().get(0) +  (character.getStr()      == 0 ? "" : " +" + character.getStr())));
        holder.dex.setText(new StringBuilder().append(    character.getLstAbilityScores().get(1) +  (character.getDex()      == 0 ? "" : " +" + character.getDex())));
        holder.con.setText(new StringBuilder().append(    character.getLstAbilityScores().get(2) +  (character.getCon()      == 0 ? "" : " +" + character.getCon())));
        holder.intel.setText(new StringBuilder().append(  character.getLstAbilityScores().get(3) +  (character.getIntel()    == 0 ? "" : " +" + character.getIntel())));
        holder.wis.setText(new StringBuilder().append(    character.getLstAbilityScores().get(4) +  (character.getWis()      == 0 ? "" : " +" + character.getWis())));
        holder.cha.setText(new StringBuilder().append(    character.getLstAbilityScores().get(5) +  (character.getCharis()   == 0 ? "" : " +" + character.getCharis())));
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

        }

    }

}

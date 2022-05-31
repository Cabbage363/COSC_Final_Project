package project.cst131.information;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import project.cst131.R;

public class Races
{

    public static ArrayList<ArrayList<String>> lstPH_Races_Sub = new ArrayList<>(
            Arrays.asList(
                    new ArrayList<>(Arrays.asList("Elf", "High Elf", "Wood Elf", "Dark Elf")),
                    new ArrayList<>(Arrays.asList("Dwarf", "Hill Dwarf", "Mountain Dwarf")),
                    new ArrayList<>(Arrays.asList("Halfling", "Lightfoot", "Stout")),
                    new ArrayList<>(Collections.singletonList("Human")),
                    new ArrayList<>(Collections.singletonList("Dragonborn")),
                    new ArrayList<>(Arrays.asList("Gnome", "Forest Gnome", "Rock Gnome")),
                    new ArrayList<>(Collections.singletonList("Half-Elf")),
                    new ArrayList<>(Collections.singletonList("Half-Orc")),
                    new ArrayList<>(Collections.singletonList("Tiefling"))
            ));

    public static ArrayList<Integer> lstPH_Races_Images = new ArrayList<>(Arrays.asList(
            R.drawable.elf,
            R.drawable.dwarf,
            R.drawable.halfling,
            R.drawable.human,
            R.drawable.dragonborn,
            R.drawable.gnome,
            R.drawable.half_elf,
            R.drawable.half_orc,
            R.drawable.tiefling
    ));

    public static ArrayList<ArrayList<String>> lstPH_Races_Info = new ArrayList<>(
            Arrays.asList(
                    new ArrayList<>(Arrays.asList("Elves are a magical people of otherworldly grace, living in the world but not entirely part of it.", "+2 Dexterity, Darkvision, Keen Senses, Fey Ancestry, Trance")),
                    new ArrayList<>(Arrays.asList("Bold and hardy, dwarves are known as skilled warriors, miners, and workers of stone and metal.", "+2 Constitution, Darkvision, Dwarven Resilience, Dwarven Combat Training, Stonecunning")),
                    new ArrayList<>(Arrays.asList("The diminutive halflings survive in a world full of larger creatures by avoiding notice or, barring that, avoiding offense.","+2 Dexterity, Lucky, Brave, Halfling Nimbleness")),
                    new ArrayList<>(Arrays.asList("Humans are the most adaptable and ambitious people among the common races. Whatever drives them, humans are the innovators, the achievers, and the pioneers of the worlds.", "+1 to All Ability Scores, Extra Language")),
                    new ArrayList<>(Arrays.asList("Dragonborn look very much like dragons standing erect in humanoid form, though they lack wings or a tail.","+2 Strength, +1 Charisma, Draconic Ancestry, Breath Weapon, Damage Resistance")),
                    new ArrayList<>(Arrays.asList("A gnome’s energy and enthusiasm for living shines through every inch of his or her tiny body.", "+2 Intelligence, Darkvision, Gnome Cunning")),
                    new ArrayList<>(Arrays.asList("Half-elves combine what some say are the best qualities of their elf and human parents.","+2 Charisma, +1 to Two Other Ability Scores, Darkvision, Fey Ancestry, Skill Versatility")),
                    new ArrayList<>(Arrays.asList("Some half-orcs rise to become proud leaders of orc communities. Some venture into the world to prove their worth. Many of these become adventurers, achieving greatness for their mighty deeds.","+2 Strength, +1 Constitution, Darkvision, Menacing, Relentless Endurance, Savage Attacks")),
                    new ArrayList<>(Arrays.asList("To be greeted with stares and whispers, to suffer violence and insult on the street, to see mistrust and fear in every eye: this is the lot of the tiefling.","+2 Charisma, +1 Intelligence, Darkvision, Hellish Resistance, Infernal Legacy"))
            ));

    /**









     */

}

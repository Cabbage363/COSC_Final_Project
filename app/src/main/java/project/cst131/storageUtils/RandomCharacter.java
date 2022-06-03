package project.cst131.storageUtils;

import static project.cst131.information.Races.lstPH_Races_Info;
import static project.cst131.information.Races.lstPH_Races_Sub;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import project.cst131.activities.MainActivity;
import project.cst131.controllers.dndCharacter;
import project.cst131.information.Points;

public class RandomCharacter
{
    private static String sRace, sRaceTraits;
    private static String sClass;
    private static String sClassHitDie;
    private static String sClassProfSaveThrow;
    private static String sClassProfPlus;
    private static ArrayList<String> sClassWeaponsArmour;
    private static String sClassTools;
    private static String sClassNumSkills;
    private static String sClassSkills;
    private static String sGender, sAlignment, sTitle, sFirstName, sLastName, sHeightFeet, getsHeightInch, sBackground;
    private static int str, dex, con, intel, wis, charis;
    private ArrayList<String> lstEquipment = new ArrayList<>();
    private static int indexOfRace;

    private static dndCharacter character;

    public static void createRandomCharacter()
    {
        character = new dndCharacter();
        randomRaceInfo();
    }

    private static void randomRaceInfo()
    {
        // Race Info
        indexOfRace = (int) Math.floor(Math.random() * lstPH_Races_Sub.size());
        character.setIndexOfRace(indexOfRace);
        ArrayList<String> raceList = lstPH_Races_Sub.get(indexOfRace);
        sRace = raceList.get((int) Math.floor(Math.random() * raceList.size())).replace("-", "").replace(" ", "");
        sRaceTraits = lstPH_Races_Info.get(indexOfRace).get(1);
        character.setRaceInfo(sRace, sRaceTraits, indexOfRace);

        // Class Info

        int cls = (int) Math.floor(Math.random() * Points.ClassAbilityIncrease.values().length);
        Points.ClassAbilityIncrease clss;

        switch (cls)
        {
            case 0:
                clss = Points.ClassAbilityIncrease.Barbarian;
                break;
            case 1:
                clss = Points.ClassAbilityIncrease.Bard;
                break;
            case 2:
                clss = Points.ClassAbilityIncrease.Cleric;
                break;
            case 3:
                clss = Points.ClassAbilityIncrease.Druid;
                break;
            case 4:
                clss = Points.ClassAbilityIncrease.Fighter;
                break;
            case 5:
                clss = Points.ClassAbilityIncrease.Monk;
                break;
            case 6:
                clss = Points.ClassAbilityIncrease.Paladin;
                break;
            case 7:
                clss = Points.ClassAbilityIncrease.Ranger;
                break;
            case 8:
                clss = Points.ClassAbilityIncrease.Rogue;
                break;
            case 9:
                clss = Points.ClassAbilityIncrease.Sorcerer;
                break;
            case 10:
                clss = Points.ClassAbilityIncrease.Warlock;
                break;
            case 11:
                clss = Points.ClassAbilityIncrease.Wizard;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + cls);
        }

        character.setClassInfo(clss);

        // Race Modifiers
        character.setRaceModifiers(Points.AbilityRaceIncrease.valueOf(sRace).getAllMods());

        String g = (Math.random() > 0.5 ? "Male" : "Female");
        ArrayList<String> al = new ArrayList<>(Arrays.asList(
                "Lawful Good (LG)",
                "Neutral Good (NG)",
                "Chaotic Good (CG)",
                "Lawful Neutral (LN)",
                "Neutral (N)",
                "Chaotic Neutral (CN)",
                "Lawful Evil (LE)",
                "Neutral Evil (NE)",
                "Chaotic Evil (CE)"
        ));

        int ft = (int) Math.floor(Math.random() * 6);
        int in = (int) Math.floor(Math.random() * 12);

        ArrayList<String> bp = new ArrayList<>(Arrays.asList(
                g,
                al.get((int) Math.floor(Math.random() * al.size())),
                (g.equals("Male") ? "Mr" : "Mrs"),
                "X", "X", String.valueOf(ft), String.valueOf(in),
                "Dealers Choice"
        ));

        character.setBackgroundPersonality(bp);

        character.setEquipment(clss.getsStartWeapons());

        ArrayList<Integer> lstRolls = new ArrayList<>();

        for(int i = 0; i<=5;i++)
        {
            lstRolls.add((int) Math.floor((Math.random() * 20) + 1));
        }

        character.setAbilityScores(lstRolls);

        Character_File_Saver save = new Character_File_Saver();
        save.writeCharacterToFile(character);
        Toast.makeText(MainActivity.activity, "Character has been create \n Click View Characters to see.", Toast.LENGTH_SHORT).show();

    }

}

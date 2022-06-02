package project.cst131.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import project.cst131.information.Points;

public class dndCharacter implements Serializable
{
    private static final long serialVersionUID = 1L;

    public dndCharacter()
    {
    }

    private String sRace, sRaceTraits;
    private String sClass;
    private String sClassHitDie;
    private String sClassProfSaveThrow;
    private String sClassProfPlus;
    private ArrayList<String> sClassWeaponsArmour;
    private String sClassTools;
    private String sClassNumSkills;
    private String sClassSkills;
    private String sGender, sAlignment, sTitle, sFirstName, sLastName, sHeightFeet, getsHeightInch, sBackground;
    private int str, dex, con, intel, wis, charis;
    private ArrayList<String> lstEqipment = new ArrayList<>();
    /**
     * Str, Dex, Con, Intel, Wis, Char
     */
    private ArrayList<Integer> lstAbilityScores = new ArrayList<>();


    /**
     * Method to set raceInfo.
     * @param sVals sRace, sRaceTraits.
     */
    public void setRaceInfo(String... sVals)
    {
        this.sRace = sVals[0];
        this.sRaceTraits = sVals[1];
    }

    /**
     * Method to set classInfo.
     * @param character sClass, sClassHitDie, sClassProfSaveThrow, sClassProfPlus, sClassWeaponsArmour, sClassTools, sClassNumSkills, sClassSkills.
     */
    public void setClassInfo(Points.ClassAbilityIncrease character)
    {
        this.sClass                 =   character.name();
        this.sClassHitDie           =   String.valueOf(character.getHitDie());
        this.sClassProfSaveThrow    =   character.getsProf_ST();
        this.sClassProfPlus         =   String.valueOf(character.getProf());
        this.sClassWeaponsArmour    =   character.getsStartWeapons();
        this.sClassTools            =   character.getsTools();
        this.sClassNumSkills        =   String.valueOf(character.getSkillNum());
        this.sClassSkills           =   character.getsSkills();
    }

    /**
     * Method to set RaceModifiers.
     * @param lstVals Arraylist, str, dex, con, intel, wis, charis.
     */
    public void setRaceModifiers(ArrayList<Integer> lstVals)
    {
        this.str        =   lstVals.get(0);
        this.dex        =   lstVals.get(1);
        this.con        =   lstVals.get(2);
        this.intel      =   lstVals.get(3);
        this.wis        =   lstVals.get(4);
        this.charis     =   lstVals.get(5);
    }

    /**
     * Method to set backgroundPersonality.
     * @param sVals sGender, sAlignment, sTitle, sFirstName, sLastName, sHeightFeet, getsHeightInch, sBackground.
     */
    public void setBackgroundPersonality(ArrayList<String> sVals)
    {
        this.sGender            = sVals.get(0);
        this.sAlignment         = sVals.get(1);
        this.sTitle             = sVals.get(2);
        this.sFirstName         = sVals.get(3);
        this.sLastName          = sVals.get(4);
        this.sHeightFeet        = sVals.get(5);
        this.getsHeightInch     = sVals.get(6);
        this.sBackground        = sVals.get(7);
    }

    /**
     * Method to set Equipment.
     * @param lstEquipment Arraylist lstEquipment.
     */
    public void setEquipment(ArrayList<String> lstEquipment)
    {
        this.lstEqipment = lstEquipment;
    }

    /**
     * Method to set AbilityScores.
     * @param lstAbilityScores Arraylist lstAbilityScores
     */
    public void setAbilityScores(ArrayList<Integer> lstAbilityScores)
    {
        this.lstAbilityScores = lstAbilityScores;
    }

    public boolean isValid() throws Exception
    {
        ArrayList<String> lstFields = new ArrayList<>(Arrays.asList(
           sRace, sRaceTraits, sClass, sClassHitDie, sClassProfSaveThrow, sClassProfPlus,
           sClassTools, sClassNumSkills, sClassSkills, sGender, sAlignment, sTitle, sFirstName,
                sLastName, sHeightFeet, getsHeightInch, sBackground,
                String.valueOf(str), String.valueOf(dex), String.valueOf(con), String.valueOf(intel),
                String.valueOf(wis), String.valueOf(charis)
        ));
        lstFields.addAll(sClassWeaponsArmour);
        lstFields.addAll(lstEqipment);
        lstFields.addAll(lstAbilityScores.stream().map(String::valueOf).collect(Collectors.toCollection(ArrayList::new)));

        for (String lstField : lstFields)
        {
            if(lstField.isEmpty())
            {
                return false;
            }
        }
        return true;
    }

}

package project.cst131.controllers;

import java.util.ArrayList;

public class dndCharacter
{
    public dndCharacter()
    {
    }

    private String sRace, sRaceTraits;
    private String sClass, sClassHitDie, sClassProfSaveThrow, sClassProfPlus, sClassWeaponsArmour, sClassTools, sClassNumSkills, sClassSkills;
    private String sGender, sAlignment, sTitle, sFirstName, sLastName, sHeightFeet, getsHeightInch, sBackground;
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
     * @param sVals sClass, sClassHitDie, sClassProfSaveThrow, sClassProfPlus, sClassWeaponsArmour, sClassTools, sClassNumSkills, sClassSkills.
     */
    public void setClassInfo(String... sVals)
    {
        this.sClass                 = sVals[0];
        this.sClassHitDie           = sVals[2];
        this.sClassProfSaveThrow    = sVals[3];
        this.sClassProfPlus         = sVals[4];
        this.sClassWeaponsArmour    = sVals[5];
        this.sClassTools            = sVals[6];
        this.sClassNumSkills        = sVals[7];
        this.sClassSkills           = sVals[8];
    }

    /**
     * Method to set backgroundPersonality.
     * @param sVals sGender, sAlignment, sTitle, sFirstName, sLastName, sHeightFeet, getsHeightInch, sBackground.
     */
    public void setBackgroundPersonality(String... sVals)
    {
        sGender            = sVals[0];
        sAlignment         = sVals[1];
        sTitle             = sVals[2];
        sFirstName         = sVals[3];
        sLastName          = sVals[4];
        sHeightFeet        = sVals[5];
        getsHeightInch     = sVals[6];
        sBackground        = sVals[7];
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

}

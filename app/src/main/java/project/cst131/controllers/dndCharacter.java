package project.cst131.controllers;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import project.cst131.information.Points;

public class dndCharacter implements Serializable
{

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
    private ArrayList<String> lstEquipment = new ArrayList<>();
    private int indexOfRace;

    /**
     * Str, Dex, Con, Intel, Wis, Char
     */
    private ArrayList<Integer> lstAbilityScores = new ArrayList<>();


    /**
     * Method to set raceInfo.
     */
    public void setRaceInfo(String race, String raceTraits, int indexOfRace)
    {
        this.sRace = race;
        this.sRaceTraits = raceTraits;
        this.indexOfRace = indexOfRace;
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
        this.lstEquipment = lstEquipment;
    }

    /**
     * Method to set AbilityScores.
     * @param lstAbilityScores Arraylist lstAbilityScores
     */
    public void setAbilityScores(ArrayList<Integer> lstAbilityScores)
    {
        this.lstAbilityScores = lstAbilityScores;
    }

    public boolean isValid()
    {
        boolean answer = false;
        try
        {
            ArrayList<String> lstFields = new ArrayList<>(Arrays.asList(
                    sRace, sRaceTraits, sClass, sClassHitDie, sClassProfSaveThrow, sClassProfPlus,
                    sClassNumSkills, sClassSkills, sGender, sAlignment, sTitle, sFirstName,
                    sLastName, sHeightFeet, getsHeightInch, sBackground,
                    String.valueOf(str), String.valueOf(dex), String.valueOf(con), String.valueOf(intel),
                    String.valueOf(wis), String.valueOf(charis), String.valueOf(indexOfRace)
            ));
            lstFields.add(sClassTools.isEmpty() ? sClassTools : "none");
            lstFields.addAll(sClassWeaponsArmour);
            lstFields.addAll(lstEquipment);
            lstFields.addAll(lstAbilityScores.stream().map(String::valueOf).collect(Collectors.toCollection(ArrayList::new)));

            for (String lstField : lstFields)
            {
                answer = !lstField.isEmpty();
            }

        }
        catch (Exception ignored)
        {

        }

        return answer;
    }

    @NonNull
    @Override
    public String toString() {
        return "dndCharacter{" +
                "sRace='" + sRace + '\'' +
                ", sRaceTraits='" + sRaceTraits + '\'' +
                ", sClass='" + sClass + '\'' +
                ", sClassHitDie='" + sClassHitDie + '\'' +
                ", sClassProfSaveThrow='" + sClassProfSaveThrow + '\'' +
                ", sClassProfPlus='" + sClassProfPlus + '\'' +
                ", sClassWeaponsArmour=" + sClassWeaponsArmour +
                ", sClassTools='" + sClassTools + '\'' +
                ", sClassNumSkills='" + sClassNumSkills + '\'' +
                ", sClassSkills='" + sClassSkills + '\'' +
                ", sGender='" + sGender + '\'' +
                ", sAlignment='" + sAlignment + '\'' +
                ", sTitle='" + sTitle + '\'' +
                ", sFirstName='" + sFirstName + '\'' +
                ", sLastName='" + sLastName + '\'' +
                ", sHeightFeet='" + sHeightFeet + '\'' +
                ", getsHeightInch='" + getsHeightInch + '\'' +
                ", sBackground='" + sBackground + '\'' +
                ", str=" + str +
                ", dex=" + dex +
                ", con=" + con +
                ", intel=" + intel +
                ", wis=" + wis +
                ", charis=" + charis +
                ", lstEquipment=" + lstEquipment +
                ", indexOfRace=" + indexOfRace +
                ", lstAbilityScores=" + lstAbilityScores +
                '}';
    }

    public String getsRace()
    {

        return sRace;
    }

    public String getsRaceTraits()
    {

        return sRaceTraits;
    }

    public String getsClass()
    {

        return sClass;
    }

    public String getsClassHitDie()
    {

        return sClassHitDie;
    }

    public String getsClassProfSaveThrow()
    {

        return sClassProfSaveThrow;
    }

    public String getsClassProfPlus()
    {

        return sClassProfPlus;
    }

    public ArrayList<String> getsClassWeaponsArmour()
    {

        return sClassWeaponsArmour;
    }

    public String getsClassTools()
    {

        return sClassTools;
    }

    public String getsClassNumSkills()
    {

        return sClassNumSkills;
    }

    public String getsClassSkills()
    {

        return sClassSkills;
    }

    public String getsGender()
    {

        return sGender;
    }

    public String getsAlignment()
    {

        return sAlignment;
    }

    public String getsTitle()
    {

        return sTitle;
    }

    public String getsFirstName()
    {

        return sFirstName;
    }

    public String getsLastName()
    {

        return sLastName;
    }

    public String getsHeightFeet()
    {

        return sHeightFeet;
    }

    public String getGetsHeightInch()
    {

        return getsHeightInch;
    }

    public String getsBackground()
    {

        return sBackground;
    }

    public int getStr()
    {

        return str;
    }

    public int getDex()
    {

        return dex;
    }

    public int getCon()
    {

        return con;
    }

    public int getIntel()
    {

        return intel;
    }

    public int getWis()
    {

        return wis;
    }

    public int getCharis()
    {

        return charis;
    }

    public ArrayList<String> getLstEquipment()
    {

        return lstEquipment;
    }

    public ArrayList<Integer> getLstAbilityScores()
    {

        return lstAbilityScores;
    }

    public void setIndexOfRace(int nVal) { this.indexOfRace = nVal ;}

    public int getIndexOfRace()
    {
        return indexOfRace;
    }

}

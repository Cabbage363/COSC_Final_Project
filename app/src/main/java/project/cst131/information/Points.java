package project.cst131.information;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Points
{
    public enum AbilityRaceIncrease
    {

        Elf             (0,2,0,0,0,0),
        HighElf         (0,2,0,0,0,0),
        WoodElf         (0,2,0,0,1,0),
        DarkElf         (0,2,0,0,0,1),
        Dwarf           (0,0,2,0,0,0),
        HillDwarf       (0,0,2,0,1,0),
        MountianDwarf   (2,0,2,0,0,0),
        Halfling        (0,2,0,0,0,0),
        Lightfoot       (0,2,0,0,0,1),
        Stout           (0,2,1,0,0,0),
        Human           (1,1,1,1,1,1),
        Dragonborn      (2,0,0,0,0,1),
        Gnome           (0,0,0,2,0,0),
        ForestGnome     (0,1,0,2,0,0),
        RockGnome       (0,0,1,2,0,0),
        HalfElf         (0,0,0,1,0,2),
        HalfOrc         (2,0,1,0,0,0),
        Tiefling        (0,0,0,1,0,1);
        private int str, dex, con, intel, wis, charis;
        AbilityRaceIncrease(int str, int dex, int con, int intel, int wis, int charis)
        {
            this.str = str;
            this.dex = dex;
            this.con = con;
            this.intel = intel;
            this.wis = wis;
            this.charis = charis;
        }

        public int getStr() {
            return str;
        }

        public int getDex() {
            return dex;
        }

        public int getCon() {
            return con;
        }

        public int getIntel() {
            return intel;
        }

        public int getWis() {
            return wis;
        }

        public int getCharis() {
            return charis;
        }
    }

    public enum ClassAbilityIncrease
    {
        Barbarian   ( new ArrayList<>(Arrays.asList("Great-Axe, Martial melee weapon", "two Hand-Axes, any Simple weapon", "explorers pack and four javelins")) ,"2d4x10",12, 2, "Light Armour, Medium Armour, Shields, Simple Weapons, Martial Weapons", "","Strength, Constitution", 2, "Animal Herding, Athletics, Intimidation, Nature, Perception, Survival"),
        Bard        ( new ArrayList<>(Arrays.asList("Rapier, Long-sword, any Simple weapon", "Diplomat's Pack, Entertainer's Pack", "Lute, any Musical Instrument", "Leather armour and a dagger")) ,"5d4x10",8 , 2, "Light Armour, Simple Weapons, hand crossbows, longswords, rapiers, shortswords","Three musical instruments of choice", "Dexterity, Charisma",3, "Any"),
        Cleric      ( new ArrayList<>(Arrays.asList("Mace, Warhammer","Scale Mail, Leather Armour, Chain Mail","Light Crossbow and 20 bolts, Simple weapon","Priest's Pack , Explorer's Pack","A shield and a Holy Symbol")) ,"5d4x10",8 , 2, "Light Armour, Medium Armour, Shields, All simple weapons", "","Wisdom, Charisma",2, "History Insight, Medicine, Persuasion, Religion"),
        Druid       ( new ArrayList<>(Arrays.asList("Wooden Shield, any Simple Weapon", "Scimitar, any Simple Melee Weapon", "Leather Armour an Explorer's Pack and a Druidic Focus")) ,"2d4x10",8 , 2, "Light Armour, Medium Armour, Shields, Druids will not wear armour or use shields that are made of metal, Clubs, Daggers, Darts, Javelins, Maces, Quarterstaffs, Scimitars, Sickles, Slings, Spears", "Herbalism kit","Intelligence, Wisdom",2, "Arcana, Animal Handling, Insight, Medicine, Nature, Perception, Religion, Survival"),
        Fighter     ( new ArrayList<>(Arrays.asList("Chain Mail, Leather and Longbow with 20 Arrows","Martial Weapon and shield, two Martial Weapons","Light Crossbow and 20 bolts, two Hand-Axes","Dungeoneer's Pack, Explorer's Pack")) ,"5d4x10",10, 2, "All armour, shields, Simple Weapons, Martial Weapons", "","Strength, Constitution",2, "Acrobatics, Animal Handling, Athletics, History, Insight, Intimidation, Perception, Survival"),
        Monk        ( new ArrayList<>(Arrays.asList("Shortsward, any Simple Weapon", "Dungeoneer's Pack, Explorer's Pack", "10 Darts")) ,"5d4",8 , 2, "Simple Weapons, shortswords", "One of artisan's tools or one musical instrument","Strength, Dexterity",2, "Acrobatics, Athletics, History, Insight, Religion, Stealth"),
        Paladin     ( new ArrayList<>(Arrays.asList("Martial Weapon and Shield, two Martial Weapons", "five Javelins, any Simple Melee Weapon", "Priest's Pack , Explorer's Pack", "Chain Mail and a Holy Symbol")) ,"5d4x10",10, 2, "All armour, shields, Simple Weapons, Martial Weapons", "","Wisdom, Charisma",2, "Athletics, Insight, Insight, Intimidation, Medicine, Perception, Religion"),
        Ranger      ( new ArrayList<>(Arrays.asList("Scale Mail, Leather Armour", "two Shortswords, two Simple Melee Weapons", "Dungeoneer's Pack, Explorer's Pack", "Longbow and a quiver of 20 arrows")) ,"5d4x10",10, 2, "Light Armour, Medium Armour, Shields, Simple Weapons, Martial Weapons", "","Strength, Dexterity",3, "Animal Handling, Athletics, Insight, Investigation, Nature, Perception, Stealth, Survival"),
        Rogue       ( new ArrayList<>(Arrays.asList("Rapier, Shortsword", "Shortbow and wuiver of 20 arrows, Shortsword", "Burglar's Pack, Dungeoneer's Oack, Explorer's Pack", "Leather Armour plus two Daggers and thieves' tools")) ,"4d4x10",8 , 2, "Simple Weapons, hand crossbows, longswords, rapiers, shortswords", "Thieves' tools","Dexterity, Intelligence",4, "Acrobatics, Athletics, Deception, Insight, Intimidation, Investigation, Perception, Performance, Persuasion, Slight of Hand, Stealth"),
        Sorcerer    ( new ArrayList<>(Arrays.asList("Light Crossbow and 20 bolts, any Simple Weapon", "Component pouch, Arcane Focus", "Dungeoneer's Pack, Explorer's Pack", "two Daggers")) ,"3d4x10",6 , 2, "Darts, Daggers, Slings, Quarterstaffs, light crossbows", "","Constitution, Charisma",2, "Arcana, Deception, Insight, Intimidation, Persuasion, Religion"),
        Warlock     ( new ArrayList<>(Arrays.asList("Light Crossbow and 20 bolts, any Simple Weapon", "Component pouch, Arcane Focus", "Scholar's Pack, Dungeoneer's Pack", "Leather Armour plus any Simple Weapon and two Daggers")) ,"4d4x10",8 , 2, "Light Armour, Simple Weapons", "","Wisdom, Charisma",2, "Arcana, Deception, History, Intimidation, Investigation, Nature, Religion"),
        Wizard      ( new ArrayList<>(Arrays.asList("Quaterstaff, Dagger", "Component pouch, Arcane Focus", "Scholar's Pack, Explorer's Pack", "A Spellbook")) ,"4d4x10",6 , 2, "Daggers, Darts, Slings, Quarterstaffs, Light Crossbows", "","Intelligence, Wisdom",2, "Arcana, History, Investigation, Medicine, Religion");


        private String sProf_AW, sProf_ST, sTools, sSkills, sMoney;
        private int hitDie, prof, skillNum;
        private ArrayList<String> sStartWeapons;

        ClassAbilityIncrease(ArrayList<String> sStartWeapons, String sMoney, int hitDie, int prof, String sProf_AWP, String sTools, String sProf_ST, int skillNum, String sSkills)
        {
            this.sMoney = sMoney;
            this.hitDie = hitDie;
            this.prof = prof;
            this.skillNum = skillNum;
            this.sProf_AW = sProf_AWP;
            this.sProf_ST = sProf_ST;
            this.sTools = sTools;
            this.sSkills = sSkills;
            this.sStartWeapons = sStartWeapons;
        }

        public String getsProf_AW() {
            return sProf_AW;
        }

        public String getsProf_ST() {
            return sProf_ST;
        }

        public String getsTools() {
            return sTools;
        }

        public String getsSkills() {
            return sSkills;
        }

        public int getHitDie() {
            return hitDie;
        }

        public int getProf() {
            return prof;
        }

        public int getSkillNum() {
            return skillNum;
        }

        public String getsMoney() {return sMoney; }

        public ArrayList<String> getsStartWeapons() { return sStartWeapons; }


    }

}

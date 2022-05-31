package project.cst131.information;

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
        Barbarian   (12, 2, "Light Armour, Medium Armour, Shields, Simple Weapons, Martial Weapons", "","Strength, Constitution", 2, "Animal Herding, Athletics, Intimidation, Nature, Perception, Survival"),
        Bard        (8 , 2, "Light Armour, Simple Weapons, hand crossbows, longswords, rapiers, shortswords","Three musical instruments of choice", "Dexterity, Charisma",3, "Any"),
        Cleric      (8 , 2, "Light Armour, Medium Armour, Shields, All simple weapons", "","Wisdom, Charisma",2, "History Insight, Medicine, Persuasion, Religion"),
        Druid       (8 , 2, "Light Armour, Medium Armour, Shields, Druids will not wear armour or use shields that are made of metal, Clubs, Daggers, Darts, Javelins, Maces, Quarterstaffs, Scimitars, Sickles, Slings, Spears", "Herbalism kit","Intelligence, Wisdom",2, "Arcana, Animal Handling, Insight, Medicine, Nature, Perception, Religion, Survival"),
        Fighter     (10, 2, "All armour, shields, Simple Weapons, Martial Weapons", "","Strength, Constitution",2, "Acrobatics, Animal Handling, Athletics, History, Insight, Intimidation, Perception, Survival"),
        Monk        (8 , 2, "Simple Weapons, shortswords", "One of artisan's tools or one musical instrument","Strength, Dexterity",2, "Acrobatics, Athletics, History, Insight, Religion, Stealth"),
        Paladin     (10, 2, "All armour, shields, Simple Weapons, Martial Weapons", "","Wisdom, Charisma",2, "Athletics, Insight, Insight, Intimidation, Medicine, Perception, Religion"),
        Ranger      (10, 2, "Light Armour, Medium Armour, Shields, Simple Weapons, Martial Weapons", "","Strength, Dexterity",3, "Animal Handling, Athletics, Insight, Investigation, Nature, Perception, Stealth, Survival"),
        Rogue       (8 , 2, "Simple Weapons, hand crossbows, longswords, rapiers, shortswords", "Thieves' tools","Dexterity, Intelligence",4, "Acrobatics, Athletics, Deception, Insight, Intimidation, Investigation, Perception, Performance, Persuasion, Slight of Hand, Stealth"),
        Sorcerer    (6 , 2, "Darts, Daggers, Slings, Quarterstaffs, light crossbows", "","Constitution, Charisma",2, "Arcana, Deception, Insight, Intimidation, Persuasion, Religion"),
        Warlock     (8 , 2, "Light Armour, Simple Weapons", "","Wisdom, Charisma",2, "Arcana, Deception, History, Intimidation, Investigation, Nature, Religion"),
        Wizard      (6 , 2, "Daggers, Darts, Slings, Quarterstaffs, Light Crossbows", "","Intelligence, Wisdom",2, "Arcana, History, Investigation, Medicine, Religion");

        private String sProf_AW, sProf_ST, sTools, sSkills;
        private int hitDie, prof, skillNum;

        ClassAbilityIncrease(int hitDie, int prof, String sProf_AWP, String sTools, String sProf_ST, int skillNum, String sSkills)
        {
            this.hitDie = hitDie;
            this.prof = prof;
            this.skillNum = skillNum;
            this.sProf_AW = sProf_AWP;
            this.sProf_ST = sProf_ST;
            this.sTools = sTools;
            this.sSkills = sSkills;
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
    }
}

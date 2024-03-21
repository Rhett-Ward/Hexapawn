public class character {
    //the class that will host all the properties of a dnd character and will be able to import them from a character sheet or be made from scratch
    //will follow the WotC 5E standard character sheet
    //this will only look for stats and proficiencies or skills etc, will not pull personality or anything like that aka only relevant combat data

    public character() {
        //Main stats
        int Strength;
        int Dexterity;
        int Constitution;
        int Intelligence;
        int Wisdom;
        int Charisma;

        //Skills
        int Acrobatics;
        int Animal_Handling;
        int Arcana;
        int Athletics;
        int Deception;
        int History;
        int Intimidation;
        int Investigation;
        int Medicine;
        int Nature;
        int Perception;
        int Performance;
        int Persuasion;
        int Religion;
        int Sleight_of_Hand;
        int Stealth;
        int Survival;
    }

    public character(int i, int i19, int i18, int i17, int i16, int i15, int i14, int i13, int i12, int i11, int i10, int i9, int i8, int i7, int i6, int i5, int i4, int i3, int i2, int i20, int i21, int i22, int i23) {
        //Main stats
        int Strength = i;
        int Dexterity = i19;
        int Constitution = i18;
        int Intelligence = i17;
        int Wisdom = i16;
        int Charisma = i15;

        //Skills
        int Acrobatics = i14;
        int Animal_Handling = i13;
        int Arcana = i12;
        int Athletics = i11;
        int Deception = i10;
        int History = i9;
        int Intimidation = i8;
        int Investigation = i7;
        int Medicine = i6;
        int Nature = i5;
        int Perception = i4;
        int Performance = i3;
        int Persuasion = i2;
        int Religion = i20;
        int Sleight_of_Hand = i21;
        int Stealth = i22;
        int Survival = i23;
    }
}

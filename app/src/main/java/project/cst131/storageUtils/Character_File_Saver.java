package project.cst131.storageUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import project.cst131.activities.MainActivity;
import project.cst131.controllers.dndCharacter;

public class Character_File_Saver
{
    private final File path = MainActivity.file;
    private final String name = "characters.dndCharc";
    private File file;

    private ArrayList<dndCharacter> lstCharacters = new ArrayList<>();

    public Character_File_Saver()
    {
        createFile();
    }

    private void createFile()
    {
        file = new File(path, name);
        if(file.exists())
        {
            readFromFile();
        }
        else
        {
            try
            {
                FileOutputStream outputStream = new FileOutputStream(file);
                outputStream.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void writeCharacterToFile(dndCharacter character)
    {
        readFromFile();
        lstCharacters.add(character);
        try
        {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(lstCharacters);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public void readFromFile()
    {
        try
        {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            lstCharacters = (ArrayList<dndCharacter>) objectInputStream.readObject();

        }
        catch (Exception ex)
        {

        }

    }

    public ArrayList<dndCharacter> getLstCharacters()
    {
        return this.lstCharacters;
    }


}

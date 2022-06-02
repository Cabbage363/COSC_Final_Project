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
    private final String name = "characters.txt";
    private File file;

    private ArrayList<dndCharacter> lstCharacters = new ArrayList<>();

    public Character_File_Saver()
    {
        createFile();
        System.out.println(file.getAbsolutePath());
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
                outputStream.write(new String("sadasd").getBytes());
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
        try
        {

            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(character);
            objectOutputStream.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public boolean readFromFile()
    {
        try
        {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object obj = objectInputStream.readObject();
            objectInputStream.close();
            lstCharacters.add((dndCharacter) obj);
            return true;
        }
        catch (Exception ex)
        {
            return false;
        }
    }
}

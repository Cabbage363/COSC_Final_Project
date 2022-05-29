package project.cst131.controllers;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import project.cst131.R;
import project.cst131.activities.*;

public class IntentController
{

    public static void swapIntent(int buttonID, Activity activity)
    {
        Intent intent = null;
        switch(buttonID)
        {
            case R.id.btnCreateCharacter:
                if(activity.findViewById(R.id.layout_characterOptions).getVisibility() == View.VISIBLE)
                {
                    activity.findViewById(R.id.layout_characterOptions).setVisibility(View.GONE);
                } else {
                    activity.findViewById(R.id.layout_characterOptions).setVisibility(View.VISIBLE);
                }
                break;
            case R.id.btnRandomCreate:
//                intent = new Intent(activity, CreateCharacterMenu.class);
                break;
            case R.id.btnViewCharacters:
//                intent = new Intent(activity, CreateCharacterMenu.class);
                break;
            case R.id.btnScratch:
                intent = new Intent(activity, activity_CharacterScratch.class);
                break;
            case R.id.btnParams:
//                intent = new Intent(activity, CreateCharacterMenu.class);
                break;
            default:
                break;
        }
        System.out.println(buttonID);
        System.out.println(R.id.btnCreateCharacter);

        if(!(buttonID == R.id.btnCreateCharacter))
        {
            activity.startActivity(intent);
        }

    }

}

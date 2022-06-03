package project.cst131.storageUtils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.pdf.PdfDocument;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import project.cst131.R;
import project.cst131.activities.MainActivity;
import project.cst131.controllers.dndCharacter;

public class pdf_generation
{
    private static Bitmap dndPage, scaleDndPage;
    private static int textSize = 10;

    public static void createPDF(dndCharacter character)
    {
        PdfDocument currentPDF = new PdfDocument();
        Paint imagePaint = new Paint();
        Paint paint = new Paint();

        dndPage = BitmapFactory.decodeResource(MainActivity.activity.getResources(),R.drawable.charactersheet);
        scaleDndPage = Bitmap.createScaledBitmap(dndPage, 541, 700, false);

        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(541,700,1).create();
        PdfDocument.Page page = currentPDF.startPage(pageInfo);

        Canvas canvas = page.getCanvas();

        canvas.drawBitmap(scaleDndPage, 0, 0, imagePaint);

        // Name.
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
        paint.setTextSize(textSize);
        canvas.drawText(character.getsFirstName() + character.getsLastName(), 46,65, paint);
        // Class, Level
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
        paint.setTextSize(textSize);
        canvas.drawText(character.getsClass() + ", 1 ", 244,54, paint);
        // Race
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
        paint.setTextSize(textSize);
        canvas.drawText(character.getsRace(), 244,78, paint);
        // Alignment
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
        paint.setTextSize(textSize);
        canvas.drawText(character.getsAlignment(), 342,76, paint);
        // Prof.
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
        paint.setTextSize(textSize);
        canvas.drawText(character.getsClassProfPlus(), 89, 161, paint);
        // Str.
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
        paint.setTextSize((float) (textSize * 1.25));
        canvas.drawText(String.valueOf(character.getLstAbilityScores().get(0)), 44, 148, paint);
        // Dex.
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
        paint.setTextSize((float) (textSize * 1.25));
        canvas.drawText(String.valueOf(character.getLstAbilityScores().get(1)), 44, 213, paint);
        // Con.
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
        paint.setTextSize((float) (textSize * 1.25));
        canvas.drawText(String.valueOf(character.getLstAbilityScores().get(2)), 44, 275, paint);
        // Int.
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
        paint.setTextSize((float) (textSize * 1.25));
        canvas.drawText(String.valueOf(character.getLstAbilityScores().get(3)), 44, 341, paint);
        // Wis.
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
        paint.setTextSize((float) (textSize * 1.25));
        canvas.drawText(String.valueOf(character.getLstAbilityScores().get(4)), 44, 402, paint);
        // Char.
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
        paint.setTextSize((float) (textSize * 1.25));
        canvas.drawText(String.valueOf(character.getLstAbilityScores().get(5)), 44, 465, paint);

        String sf1 = character.getsClassProfSaveThrow().substring(character.getsClassProfSaveThrow().indexOf(",") + 1).trim();
        String sf2 = character.getsClassProfSaveThrow().substring(character.getsClassProfSaveThrow().indexOf(",") + 1).trim();
        ArrayList<String> lstSF = new ArrayList<>(Arrays.asList(
                sf1, sf2
        ));

        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
        paint.setTextSize(textSize);

        lstSF.forEach(x->{
            int SF = 92;
            switch (x)
            {
                case "Strength":
                    canvas.drawText("x", SF,88, paint);
                    paint.setTextAlign(Paint.Align.LEFT);
                    paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                    paint.setTextSize(textSize);
                    canvas.drawText("+2", SF + 13,88, paint);
                    break;
                case "Dexterity":
                    canvas.drawText("x", SF,200, paint);
                    paint.setTextAlign(Paint.Align.LEFT);
                    paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                    paint.setTextSize(textSize);
                    canvas.drawText("+2", SF + 13,88, paint);
                    break;
                case "Constitution":
                    canvas.drawText("x", SF,213, paint);
                    paint.setTextAlign(Paint.Align.LEFT);
                    paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                    paint.setTextSize(textSize);
                    canvas.drawText("+2", SF + 13,88, paint);
                    break;
                case "Intelligence":
                    canvas.drawText("x", SF,224, paint);
                    paint.setTextAlign(Paint.Align.LEFT);
                    paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                    paint.setTextSize(textSize);
                    canvas.drawText("+2", SF + 13,88, paint);
                    break;
                case "Wisdom":
                    canvas.drawText("x", SF,236, paint);
                    paint.setTextAlign(Paint.Align.LEFT);
                    paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                    paint.setTextSize(textSize);
                    canvas.drawText("+2", SF + 13,88, paint);
                    break;
                case "Charisma":
                    canvas.drawText("x", SF,248, paint);
                    paint.setTextAlign(Paint.Align.LEFT);
                    paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                    paint.setTextSize(textSize);
                    canvas.drawText("+2", SF + 13,88, paint);
                    break;
            }
        });




        currentPDF.finishPage(page);

        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), character.getsFirstName() + ".pdf");
        if(file.exists())
        {
            file.delete();
        }

        try
        {
            currentPDF.writeTo(new FileOutputStream(file, true));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        currentPDF.close();


    }
}

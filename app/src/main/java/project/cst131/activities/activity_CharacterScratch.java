package project.cst131.activities;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import project.cst131.R;
import project.cst131.adapters.ScreenSlidePagerAdapter;
import project.cst131.controllers.dndCharacter;
import project.cst131.fragments.ClassesFragment;
import project.cst131.fragments.EquipmentFragment;
import project.cst131.fragments.PersonalityBackgroundFragment;
import project.cst131.fragments.RacesFragment;
import project.cst131.information.Choices;

public class activity_CharacterScratch extends AppCompatActivity
{
    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    public static dndCharacter character = new dndCharacter();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_create_scratch);

        Toolbar appToolBar = findViewById(R.id._tbScratchCharacter);
        setSupportActionBar(appToolBar);

        tabLayout = findViewById(R.id._tlScratchCharactersTabs);
        viewPager =  findViewById(R.id._vpScratchCharacter);


        tabLayout.addTab(tabLayout.newTab().setText(R.string.tabRace), 0);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tabClass), 1);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tabBackground), 2);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tabEquipment), 3);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tabAbilityRolls), 4);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabMode(TabLayout.MODE_AUTO);

        FragmentStateAdapter adapter = new ScreenSlidePagerAdapter(activity_CharacterScratch.this);
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position)
            {
                case 0:
                    tab.setText(R.string.tabRace);
                    break;
                case 1:
                    tab.setText(R.string.tabClass);
                    break;
                case 2:
                    tab.setText(R.string.tabBackground);
                    break;
                case 3:
                    tab.setText(R.string.tabEquipment);
                    break;
                case 4:
                    tab.setText(R.string.tabAbilityRolls);
                    break;
                default:

            }
        }).attach();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener()
        {
            @Override
            public void onTabSelected(TabLayout.Tab tab)
            {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab)
            {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab)
            {

            }
        });

        viewPager.setCurrentItem(0);

    }

}



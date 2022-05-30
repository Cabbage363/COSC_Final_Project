package project.cst131.adapters;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import project.cst131.fragments.ClassesFragment;
import project.cst131.fragments.EquipmentFragment;
import project.cst131.fragments.PersonalityBackgroundFragment;
import project.cst131.fragments.RacesFragment;

public class ScreenSlidePagerAdapter extends FragmentStateAdapter
{
    private final int numTabs = 4;

    public ScreenSlidePagerAdapter(AppCompatActivity activity)
    {
        super(activity);
    }

    @Override
    public int getItemCount()
    {
        return numTabs;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position)
    {
        Fragment fragment = null;
        switch (position)
        {
            case 0:
                fragment = new RacesFragment();
                break;
            case 1:
                fragment = new ClassesFragment();
                break;
            case 2:
                fragment = new PersonalityBackgroundFragment();
                break;
            case 3:
                fragment = new EquipmentFragment();
                break;
            default:

        }
        return fragment;
    }
}

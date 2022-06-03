package project.cst131.adapters;

import static project.cst131.activities.activity_CharacterScratch.updateStuffAndCheck;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import project.cst131.fragments.ClassesFragment;
import project.cst131.fragments.EquipmentFragment;
import project.cst131.fragments.PersonalityBackgroundFragment;
import project.cst131.fragments.RacesFragment;
import project.cst131.fragments.ScoreFragment;

public class ScreenSlidePagerAdapter extends FragmentStateAdapter
{
    private final int numTabs = 5;

    public ScreenSlidePagerAdapter(AppCompatActivity activity)
    {
        super(activity);
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView)
    {
        super.onAttachedToRecyclerView(recyclerView);
        updateStuffAndCheck();
    }

    @Override
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView)
    {
        super.onDetachedFromRecyclerView(recyclerView);
        updateStuffAndCheck();
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
            case 4:
                fragment = new ScoreFragment();
                break;
            default:

        }

        assert fragment != null;
        return fragment;
    }

}

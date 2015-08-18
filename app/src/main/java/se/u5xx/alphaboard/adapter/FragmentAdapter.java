package se.u5xx.alphaboard.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import se.u5xx.alphaboard.fragment.CategoryFragment;
import se.u5xx.alphaboard.fragment.SoundFragment;
import se.u5xx.alphaboard.fragment.StartFragment;
import timber.log.Timber;

/**
 * Created by Simon Cedergren <simon@tuxflux.se>
 * 2015-08-17
 */
public class FragmentAdapter extends FragmentStatePagerAdapter {

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 2; // Since we're using 2 fragments in the app.
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position) {
            case 0:
                Timber.d("Loading categories fragment");
                fragment = new StartFragment();
                break;
            case 1:
                Timber.d("Loading favorites fragment");
                fragment = new Fragment();
                break;
            default:
                fragment = null; // TODO: Maybe something more graceful.
                break;
        }
        return fragment;
    }
}
package se.u5xx.alphaboard.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
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
                break;
            case 1:
                Timber.d("Loading favorites fragment");
                break;
            default:
                fragment = null; // TODO: Maybe something more graceful.
                break;
        }
        return new Fragment(); // TODO: Change as soon as we got a "real" fragment to test with.
    }

}
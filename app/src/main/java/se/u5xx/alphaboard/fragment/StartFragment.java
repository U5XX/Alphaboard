package se.u5xx.alphaboard.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import se.u5xx.alphaboard.R;
import se.u5xx.alphaboard.fragment.base.BaseFragment;
import se.u5xx.alphaboard.interfaces.SelectionListener;

/**
 * Created by Fredrik Andersson <cfredrikandersson@gmail.com>
 * 2015-08-18.
 */
public class StartFragment extends BaseFragment implements SelectionListener {

    private View view;


    private BoardFragment boardFragment;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_start, container, false);

        setNestedFragment(CollectionFragment.newInstance(this));

        boardFragment = new BoardFragment();

        return view;
    }

    /**
     * Sets the fragment to be nested within this instance of StartFragment.
     *
     * @param fragment The fragment to be nested.
     */
    private void setNestedFragment(Fragment fragment) {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.frag_start_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void categoryCallback(int categoryId) {
        // TODO: Use the category ID to show a BoardFragment with the corresponding sound squares.
        setNestedFragment(boardFragment);
    }

    @Override
    public boolean onBackButtonPressed() {
        return null != boardFragment && boardFragment.onBackButtonPressed();
    }
}

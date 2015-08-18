package se.u5xx.alphaboard.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import se.u5xx.alphaboard.R;
import se.u5xx.alphaboard.interfaces.SelectionListener;

/**
 * Created by Fredrik Andersson <cfredrikandersson@gmail.com>
 * 2015-08-18.
 */
public class CategoryFragment extends Fragment {

    private View view;
    private Button button;

    private SelectionListener listener;

    public static CategoryFragment newInstance(SelectionListener listener){
        CategoryFragment frag = new CategoryFragment();
        frag.setListener(listener);

        // TODO: Implement factory class/es for constructing the lists of SoundSquares and categories.

        return frag;
    }

    private void setListener(SelectionListener listener){
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_category, container, false);
        button = (Button)view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.categoryCallback(0);// TODO: Change to pass along actual category ID.
            }
        });

        return view;
    }


}

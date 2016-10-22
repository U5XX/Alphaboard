package se.u5xx.alphaboard.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import se.u5xx.alphaboard.R;
import se.u5xx.alphaboard.interfaces.SelectionListener;

/**
 * Created by Fredrik Andersson <cfredrikandersson@gmail.com>
 * 2015-08-18.
 */
public class CollectionFragment extends Fragment {

    @BindView(R.id.button)
    Button button;

    private SelectionListener listener;

    public static CollectionFragment newInstance(SelectionListener listener) {
        CollectionFragment frag = new CollectionFragment();
        frag.setListener(listener);

        // TODO: Implement factory class/es for constructing the lists of SoundSquares and categories.

        return frag;
    }

    private void setListener(SelectionListener listener) {
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_collection, container, false);
        ButterKnife.bind(this, view);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != listener) listener.categoryCallback(0);// TODO: Change to pass along actual category ID.
            }
        });

        return view;
    }
}
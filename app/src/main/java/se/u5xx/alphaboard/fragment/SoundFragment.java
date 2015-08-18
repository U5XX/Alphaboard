package se.u5xx.alphaboard.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import se.u5xx.alphaboard.R;
import se.u5xx.alphaboard.adapter.SoundGridAdapter;
import se.u5xx.alphaboard.entity.SoundSquare;
import timber.log.Timber;

/**
 * Created by Fredrik Andersson <cfredrikandersson@gmail.com>
 * 2015-08-17.
 */
public class SoundFragment extends Fragment {

    private RecyclerView grid;
    private View view;

    private final int COLUMNS = 3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_sound, container, false);

        grid = (RecyclerView)view.findViewById(R.id.recycler);
        grid.setLayoutManager(new GridLayoutManager(getActivity(), COLUMNS));

        // TODO: Implement factory class/es for constructing the lists of SoundSquares and categories.
        grid.setAdapter(new SoundGridAdapter(getActivity(), buildGrid()));
        return view;
    }

    /**
     * Temp. method used for development. Creates a list populated with placeholder SoundSquares.
     * @return
     */
    public List<SoundSquare> buildGrid(){
        List<SoundSquare> list = new ArrayList<>();

        for(int i = 0; i < 20; i++){
            list.add(new SoundSquare(i, i % 2, R.drawable.abc_btn_switch_to_on_mtrl_00001, String.format("Name: %s", i), ""));
        }

        return list;
    }

    @Override
    public void onDestroy() {
        Timber.d("onDestroy called.");
        super.onDestroy();
    }
}

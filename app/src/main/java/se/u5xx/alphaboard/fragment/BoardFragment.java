package se.u5xx.alphaboard.fragment;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import se.u5xx.alphaboard.R;
import se.u5xx.alphaboard.adapter.GridAdapter;
import se.u5xx.alphaboard.entity.CollectionSquare;
import se.u5xx.alphaboard.entity.SoundSquare;
import se.u5xx.alphaboard.entity.Square;
import se.u5xx.alphaboard.fragment.base.BaseFragment;
import se.u5xx.alphaboard.interfaces.LoadCollectionEvent;
import timber.log.Timber;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class BoardFragment extends BaseFragment implements LoadCollectionEvent {

    private Stack<CollectionSquare> collectionSquareStack;
    private RecyclerView grid;
    private View view;

    private final int COLUMNS = 3;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_sound, container, false);
        grid = (RecyclerView) view.findViewById(R.id.recycler);

        collectionSquareStack = new Stack<>();
        loadCollection(new CollectionSquare(1, 2, "3"));
        return view;
    }

    /**
     * Temp. method used for development. Creates a list populated with placeholder SoundSquares.
     *
     * @return
     */
    public List<Square> buildGrid(List<Square> list, int freq, int size) {
        for (int i = 0; i < size; i++) {
            list.add(new SoundSquare(i, i % 2, android.R.drawable.ic_media_play, String.format("Name: %s", i), ""));
            if (i % freq == 0) list.add(new CollectionSquare(i, android.R.drawable.arrow_down_float, "Collection " + i));
        }

        return list;
    }

    @Override
    public void onDestroy() {
        Timber.d("onDestroy called.");
        super.onDestroy();
    }

    @Override
    public void loadCollection(CollectionSquare collectionSquare) {
        new GridLoader(this).execute();
        collectionSquareStack.push(collectionSquare);
    }

    public void popBoardStack(){
        collectionSquareStack.pop();
        new GridLoader(this).execute();
//        collectionSquareStack.peek();
    }

    @Override
    public boolean onBackButtonPressed() {
        if (collectionSquareStack.size() == 1) return false;
        popBoardStack();
        return true;
    }

    class GridLoader extends AsyncTask<Void, List<SoundSquare>, List<Square>> {
        private BoardFragment boardFragment;

        GridLoader(BoardFragment boardFragment) {
            this.boardFragment = boardFragment;
        }

        @Override
        protected List<Square> doInBackground(Void... params) {
            Random random = new Random();
            return buildGrid(new ArrayList<Square>(), random.nextInt(5)+1, random.nextInt(40)+1);
        }

        @Override
        protected void onPostExecute(List<Square> content) {
            grid.setLayoutManager(new GridLayoutManager(getActivity(), COLUMNS));
            // TODO: Implement factory class/es for constructing the lists of SoundSquares and categories.
            grid.setAdapter(new GridAdapter(getActivity(), content, boardFragment));
            super.onPostExecute(content);
        }
    }
}

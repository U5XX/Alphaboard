package se.u5xx.alphaboard.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;
import se.u5xx.alphaboard.R;
import se.u5xx.alphaboard.entity.CollectionSquare;
import se.u5xx.alphaboard.entity.Square;
import se.u5xx.alphaboard.interfaces.LoadCollectionEvent;

import java.util.List;

/**
 * RecyclerView-adapter for the grid containing the instances of SoundSquare.
 * This class is responsible for binding the data from the POJO-class (SoundSquare) to the ViewHolder.
 * Created by Fredrik Andersson on 2015-08-17.
 */
public class GridAdapter extends RecyclerView.Adapter<GridAdapter.SquareViewHolder> {

    private LoadCollectionEvent collectionEvent;
    private List<Square> items;
    private Context context;

    /**
     * Default constructor.
     *
     * @param context Current context of the application.
     * @param items   An implementation of List containing the instances of SoundSquare to be displayed in the grid.
     */
    public GridAdapter(Context context, List<Square> items, LoadCollectionEvent collectionEvent) {
        this.items = items;
        this.context = context;
        this.collectionEvent = collectionEvent;
    }


    @Override
    public SquareViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        // Inflate the SoundSquare-xml and bind it to the instance of ViewHolder.
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sound_square, viewGroup, false);
        return new SquareViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final SquareViewHolder squareViewHolder, final int i) {
        // Bind the data from the POJO-class to the ViewHolder.
        Picasso.with(context).load(items.get(i).getImageResource()).into(squareViewHolder.getImage());
        squareViewHolder.getLabel().setText(items.get(i).getLabel());

        // Register listeners.
        squareViewHolder.getContainer().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Implement onClick-functionality. Play sound, change visuals, etc.
                Toast.makeText(context, items.get(i).getLabel(), Toast.LENGTH_SHORT).show();
                if (items.get(i) instanceof CollectionSquare) collectionEvent.loadCollection((CollectionSquare) items.get(i));
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class SquareViewHolder extends RecyclerView.ViewHolder {
        CardView container;
        ImageView image;
        TextView label;

        /**
         * Basic constructor.
         *
         * @param itemView The inflated xml/view which contains the views in this class.
         */
        public SquareViewHolder(View itemView) {
            super(itemView);
            container = (CardView) itemView.findViewById(R.id.squareContainer);
            image = (ImageView) itemView.findViewById(R.id.squareImage);
            label = (TextView) itemView.findViewById(R.id.squareLabel);
        }

        public ImageView getImage() {
            return this.image;
        }

        public TextView getLabel() {
            return this.label;
        }

        public CardView getContainer() {
            return this.container;
        }
    }
}

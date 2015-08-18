package se.u5xx.alphaboard.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import se.u5xx.alphaboard.R;
import se.u5xx.alphaboard.entity.SoundSquare;
import se.u5xx.alphaboard.entity.SoundSquareViewHolder;
import timber.log.Timber;

/**
 * RecyclerView-adapter for the grid containing the instances of SoundSquare.
 * This class is responsible for binding the data from the POJO-class (SoundSquare) to the ViewHolder.
 * Created by Fredrik Andersson on 2015-08-17.
 */
public class SoundGridAdapter extends RecyclerView.Adapter<SoundSquareViewHolder> {

    private List<SoundSquare> items;
    private Context context;

    /**
     * Default constructor.
     *
     * @param context Current context of the application.
     * @param items   An implementation of List containing the instances of SoundSquare to be displayed in the grid.
     */
    public SoundGridAdapter(Context context, List<SoundSquare> items) {
        this.items = items;
        this.context = context;
    }


    @Override
    public SoundSquareViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        // Inflate the SoundSquare-xml and bind it to the instance of ViewHolder.
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sound_square, viewGroup, false);
        SoundSquareViewHolder viewHolder = new SoundSquareViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(SoundSquareViewHolder soundSquareViewHolder, final int i) {
        // Bind the data from the POJO-class to the ViewHolder.
        Picasso.with(context).load(items.get(i).getImageResource()).into(soundSquareViewHolder.getImage());
        soundSquareViewHolder.getLabel().setText(items.get(i).getLabelText());

        // Register listeners.
        soundSquareViewHolder.getContainer().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Implement onClick-functionality. Play sound, change visuals, etc.
            }
        });
    }


    @Override
    public int getItemCount() {
        return items.size();
    }
}

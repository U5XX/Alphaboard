package se.u5xx.alphaboard.entity;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import se.u5xx.alphaboard.R;

/**
 * Implementation of RecyclerViews ViewHolder, which is responsible for handling the
 * views associated with the SoundSquares.
 *
 * Created by Fredrik Andersson <cfredrikandersson@gmail.com>
 * 2015-08-17.
 */
public class SoundSquareViewHolder extends RecyclerView.ViewHolder {
    public CardView container;
    public ImageView image;
    public TextView label;

    /**
     * Basic constructor.
     *
     * @param itemView The inflated xml/view which contains the views in this class.
     */
    public SoundSquareViewHolder(View itemView) {
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

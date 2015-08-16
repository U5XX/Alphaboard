package se.u5xx.alphaboard.entity;

/**
 * Entity class representing a "sound square" on the board.
 * The class is responsible for handling the paths to its associated image- and sound-resources.
 * Created by Fredrik Andersson on 2015-08-16.
 */

import android.content.Context;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class SoundSquare extends CardView {

    private static final String tag = "Alphaboard | SoundSquare";
    private Context context;
    private String title, soundFilePath;
    private int id;
    private int width = 1;
    private int height = 1;
    private TextView label;
    private ImageView image;

    /**
     * Minimal constructor for SoundSquares
     *
     * @param context The context of the application
     */
    public SoundSquare(Context context) {
        super(context);
        this.context = context;

        this.label = new TextView(context);
        this.image = new ImageView(context);

        this.addView(image);
        this.addView(label);

        setLabelDesign(Color.WHITE, Color.GRAY, 175);
        setLabelPosition(Gravity.BOTTOM);
    }

    /**
     * Sets the image of the SoundSquare using the provided resource.
     *
     * @param imageResource Image resource to be displayed
     */
    public void setImage(int imageResource) {
        Picasso.with(context).load(imageResource).into(image);
    }

    /**
     * Returns the title currently stored in the SoundSquare
     *
     * @return The title currently stored in the SoundSquare
     */
    public String getTitle() {
        return title;
    }

    /**
     * Stores the title of the SoundSquare. To set the text for the label; use
     * setLabelText.
     *
     * @param title The title to be saved.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets the label text of the SoundSquare
     *
     * @param title The label text to be set
     */
    public void setLabelText(String title) {
        label.setText(title);
    }

    /**
     * Returns the current label text.
     *
     * @return The current label text.
     */
    public String getLabelText() {
        return this.label.toString();
    }

    /**
     * Sets the sound file path of the SoundSquare.
     *
     * @param soundFilePath The file path of the sound.
     */
    public void setSoundFilePath(String soundFilePath) {
        this.soundFilePath = soundFilePath;
    }

    /**
     * Returns the file path to the associated sound.
     *
     * @return The file path to the associated sound.
     */
    public String getSoundFilePath() {
        return this.soundFilePath;
    }

    /**
     * Returns the database ID of the SoundSquare
     *
     * @return The database ID of the SoundSquare
     */
    public int getSquareId() {
        return id;
    }

    /**
     * Sets the database ID of the SoundSquare. Notice: This method should be
     * called by the controller ONLY.
     *
     * @param id The database ID of the SoundSquare.
     */
    public void setSquareId(int id) {
        this.id = id;
    }

    /**
     * Sets the width of the SoundSquare
     *
     * @param width The width to be set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Sets the height of the SoundSquare
     *
     * @param height The height to be set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Darkens the background of the square if pressed, and returns the background
     * to normal if not pressed.
     *
     * @param isPressed Whether the SoundSquare is being pressed or not.
     */
    public void setImageSquarePressed(boolean isPressed) {
        if (isPressed)
            this.image.getBackground().setColorFilter(
                    new LightingColorFilter(0xff888888, 0x000000));
        else
            this.image.getBackground().setColorFilter(null);

    }

    /**
     * Sets the position of the label inside the SoundSquare.
     *
     * @param gravity The gravity of the label (use Gravity.CENTER, etc.).
     */
    private void setLabelPosition(int gravity) {
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        lp.gravity = gravity;
        this.label.setLayoutParams(lp);
        label.setGravity(Gravity.CENTER);
    }

    /**
     * Sets the design/look of the label.
     *
     * @param textColor       The color of the text (use Color.WHITE, etc).
     * @param backgroundColor The color of the background (use Color.GRAY, etc).
     * @param alpha           The transparency of the background. 0 is fully transparent and
     *                        255 is fully opaque.
     */
    private void setLabelDesign(int textColor, int backgroundColor, int alpha) {
        this.label.setTextColor(textColor);
        this.label.setBackgroundColor(backgroundColor);
        this.label.getBackground().setAlpha(alpha);
    }

    public String toString() {
        return String.format("SoundSquare - ID: %s, Title: '%s', Sound path: %s", id, title, soundFilePath);
    }
}

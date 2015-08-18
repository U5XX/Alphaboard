
package se.u5xx.alphaboard.entity;


/**
 * POJO-class representing a "sound square" on the board.
 * The class is responsible for handling the paths to its associated image- and sound-resources.
 *
 * Created by Fredrik Andersson <cfredrikandersson@gmail.com>
 * 2015-08-16.
 */


public class SoundSquare {
    private String labelText, soundFilePath;
    private int id;
    private int category;
    private int imageResource;


    /**
     * Basic constructor.
     *
     * @param id            The unique ID of the SoundSquare.
     * @param category      The ID of the associated category.
     * @param imageResource The image resource to be displayed.
     * @param labelText     The text of the label.
     * @param soundFilePath The path to the associated sound file.
     */
    public SoundSquare(int id, int category, int imageResource, String labelText, String soundFilePath) {
        this.imageResource = imageResource;
        this.labelText = labelText;
        this.id = id;
        this.category = category;
        this.soundFilePath = soundFilePath;
    }


    /**
     * Sets the label text of the SoundSquare
     *
     * @param labelText The text to be set.
     */

    public void setLabelText(String labelText) {
        this.labelText = labelText;
    }


    /**
     * Returns the current label text.
     *
     * @return The current label text.
     */

    public String getLabelText() {
        return labelText;
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

    public int getImageResource() {
        return imageResource;
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
     * Sets the unique ID of the SoundSquare.
     *
     * @param id The ID of the SoundSquare.
     */

    public void setSquareId(int id) {
        this.id = id;
    }


    public String toString() {
        return String.format("SoundSquare - ID: %s, Label: %s, Sound path: %s", id, labelText, soundFilePath);
    }
}

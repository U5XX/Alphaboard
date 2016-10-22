
package se.u5xx.alphaboard.entity;


/**
 * POJO-class representing a "sound square" on the board.
 * The class is responsible for handling the paths to its associated image- and sound-resources.
 * 2015-08-16.
 */
public class SoundSquare extends Square {
    private String soundFilePath;
    private int category;


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
        super(id, imageResource, labelText);
        this.category = category;
        this.soundFilePath = soundFilePath;
    }

    public String getSoundFilePath() {
        return soundFilePath;
    }

    public void setSoundFilePath(String soundFilePath) {
        this.soundFilePath = soundFilePath;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}


package se.u5xx.alphaboard.entity;


import java.util.List;

/**
 * POJO-class representing a "sound square" on the board.
 * The class is responsible for handling the paths to its associated image- and sound-resources.
 * 2015-08-16.
 */
public class CollectionSquare extends Square {
    private List<SoundSquare> soundSquares;

    /**
     * Basic constructor.
     *
     * @param id            The unique ID of the SoundSquare.
     * @param imageResource The image resource to be displayed.
     * @param labelText     The text of the label.
     */
    public CollectionSquare(int id, int imageResource, String labelText) {
        super(id, imageResource, labelText);
    }

    public List<SoundSquare> getSoundSquares() {
        return soundSquares;
    }

    public void setSoundSquares(List<SoundSquare> soundSquares) {
        this.soundSquares = soundSquares;
    }
}

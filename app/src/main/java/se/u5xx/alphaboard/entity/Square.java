
package se.u5xx.alphaboard.entity;


/**
 * POJO-class representing a square on the board.
 * 2016-10-22
 */
public abstract class Square {
    private String label;
    private int id;
    private int imageResource;

    /**
     * Basic constructor.
     *
     * @param id            The unique ID of the SoundSquare.
     * @param imageResource The image resource to be displayed.
     * @param label         The text of the label.
     */
    public Square(int id, int imageResource, String label) {
        this.imageResource = imageResource;
        this.label = label;
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}

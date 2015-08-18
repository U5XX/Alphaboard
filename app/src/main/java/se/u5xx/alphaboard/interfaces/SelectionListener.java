package se.u5xx.alphaboard.interfaces;

/**
 * Allows the CategoryFragment to notify the StartFragment that a category has been chosen.
 *
 * NOTE: This interface could (and should?) probably be replaced with communications using Otto.
 *
 * Created by Fredrik Andersson <cfredrikandersson@gmail.com>
 * 2015-08-18.
 */
public interface SelectionListener {

    void categoryCallback(int categoryId);
}

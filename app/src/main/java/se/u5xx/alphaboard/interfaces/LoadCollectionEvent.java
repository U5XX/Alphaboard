package se.u5xx.alphaboard.interfaces;


import se.u5xx.alphaboard.entity.CollectionSquare;

/**
 * Interface to notify that a CollectionSquare should open.
 */
public interface LoadCollectionEvent {
    void loadCollection(CollectionSquare collectionSquare);
}

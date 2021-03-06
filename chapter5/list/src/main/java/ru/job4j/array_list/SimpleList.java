package ru.job4j.array_list;

/**
 * @param <T> any type.
 * @author Alexey Voronin.
 * @since 13.03.2017.
 * Simple list.
 */
public interface SimpleList<T> {

    /**
     * Add item to list.
     *
     * @param t item.
     */
    void add(final T t);

    /**
     * Return item from list.
     *
     * @param index index to the item.
     * @return item.
     */
    T get(final int index);
}

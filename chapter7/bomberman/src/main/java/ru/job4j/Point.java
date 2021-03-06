package ru.job4j;

/**
 * Point.
 *
 * @author Alexey Voronin.
 * @since 09.05.2017.
 */
public class Point {

    /**
     * X coordinate.
     */
    private final int x;

    /**
     * Y coordinate.
     */
    private final int y;

    /**
     * Constructor.
     *
     * @param x x.
     * @param y y.
     */
    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get.
     *
     * @return x.
     */
    public int getX() {
        return x;
    }

    /**
     * Get.
     *
     * @return y.
     */
    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("%s.%s", this.getX(), this.getY());
    }
}

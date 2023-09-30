/**********************************************************
 * EECS2101A: Fundamentals of Data Structures,  Fall 2023
 * Assignment 1, Problem 1: A1.ArraySqueeze.java
 * Student Name:   Huanrui Cao
 * Student EECS account:  Saikoro
 * Student ID number:  219256809
 **********************************************************/

package A1;

/**
 * The purpose of this class is to  count how many overlapping
 * and how many enclosing pairs of windows there are (without double counting)
 * in a given array of windows in the plane.
 *
 * The main method runs some tests.
 *
 * @author Huanrui Cao
 *
 */

/**
 * Exception to handle invariant.
 */
class InvalidWindowException extends Exception {
    public InvalidWindowException(String message) {
        super(message);
    }
}

public class Window {
    protected double left;
    protected double right;
    protected double bottom;
    protected double top;

    /**
     * Creat a window instance with the values of left, right, bottom and top.
     * @param left
     * @param right
     * @param bottom
     * @param top
     * @throws InvalidWindowException if the left larger than right or bottom is larger than top
     */
    public Window(double left, double right, double bottom, double top) throws InvalidWindowException {
        if (left >= right || bottom >= top) {
            throw new InvalidWindowException("Invalid Window Exception");
        }

        this.left = left;
        this.right = right;
        this.bottom = bottom;
        this.top = top;
    }

    /**
     * Get the left value
     * @return left
     */
    public double getLeft() {
        return left;
    }

    /**
     * Get the right value
     * @return right
     */
    public double getRight() {
        return right;
    }

    /**
     * Get the bottom value
     * @return bottom
     */
    public double getBottom() {
        return bottom;
    }

    /**
     * Get the top value
     * @return top
     */
    public double getTop() {
        return top;
    }

    /**
     * Set the left value
     * @param left he left value
     * @throws InvalidWindowException if the left larger than right
     */
    public void setLeft(double left) throws InvalidWindowException {
        if (left >= this.right) {
            throw new InvalidWindowException("Invalid Left Value.");
        }
        this.left = left;
    }

    /**
     * Set the right value
     * @param right the right value
     * @throws InvalidWindowException if the left larger than right
     */
    public void setRight(double right) throws InvalidWindowException {
        if (right <= this.left) {
            throw new InvalidWindowException("Invalid Right Value.");
        }
        this.right = right;
    }

    /**
     * Set the bottom value
     * @param bottom the bottom value
     * @throws InvalidWindowException if the bottom larger than top
     */
    public void setBottom(double bottom) throws InvalidWindowException {
        if (bottom >= this.top) {
            throw new InvalidWindowException("Invalid Bottom Value.");
        }
        this.bottom = bottom;
    }

    /**
     * Set the top value
     * @param top the top value
     * @throws InvalidWindowException if the bottom larger than top
     */
    public void setTop(double top) throws InvalidWindowException {
        if (top <= this.bottom) {
            throw new InvalidWindowException("Invalid Top Value.");
        }
        this.top = top;
    }

    /**
     * Determine if this instance window encloses the object window
     * @param w an object window
     * @return true if enclose
     */
    public boolean encloses(Window w) {
        return this.left <= w.left && this.right >= w.right && this.bottom <= w.bottom && this.top >= w.top;
    }

    /**
     * Determine if this instance window overlaps an object window
     * @param w an object window
     * @return true if overlap
     */
    public boolean overlaps(Window w) {
        return this.left < w.right && this.right > w.left && this.bottom < w.top && this.top > w.bottom;
    }

    /**
     * Count the number of (unordered) overlapping pairs of windows in the input array windows.
     * @param windows
     * @return the number of (unordered) overlapping pairs of windows in the input array windows
     */
    public static int overlapCount(Window[] windows) {
        int result = 0;
        for (int i = 0; i < windows.length; i++) {
            for (int j = i + 1; j < windows.length; j++) {
                if (windows[i].overlaps(windows[j])) {
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * Count he number of (ordered) enclosing pairs of windows in the input array windows.
     * @param windows
     * @return he number of (ordered) enclosing pairs of windows in the input array windows
     */
    public static int enclosureCount(Window[] windows) {
        int result = 0;
        for (int i = 0; i < windows.length; i++) {
            for (int j = 0; j < windows.length; j++) {
                if (i != j && windows[i].encloses(windows[j])) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        try {
            Window w1 = new Window(0, 2, 0, 2);
            Window w2 = new Window(1, 3, 1, 3);
            Window w3 = new Window(2, 4, 2, 4);
            Window w4 = new Window(2, 3, 2, 3);

            System.out.println(w1.overlaps(w2)); // Output: true
            System.out.println(w1.overlaps(w3)); // Output: false
            System.out.println(w1.overlaps(w4)); // Output: false
            System.out.println(w2.overlaps(w3)); // Output: true
            System.out.println(w2.overlaps(w4)); // Output: true
            System.out.println(w3.overlaps(w4)); // Output: true

            System.out.println(w1.encloses(w2)); // Output: false
            System.out.println(w1.encloses(w3)); // Output: false
            System.out.println(w1.encloses(w4)); // Output: false
            System.out.println(w2.encloses(w4)); // Output: true
            System.out.println(w3.encloses(w4)); // Output: true
            System.out.println(w4.encloses(w4)); // Output: true

            Window[] windows = {w1, w2, w3, w4};
            System.out.println(Window.overlapCount(windows)); // Output: 4
            System.out.println(Window.enclosureCount(windows)); // Output: 2
        } catch (InvalidWindowException e) {
            System.out.println(e.getMessage());
        }
    }
}

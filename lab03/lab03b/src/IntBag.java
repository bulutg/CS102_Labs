import java.util.Arrays;
import java.util.Iterator;

/**
 * IntBag Class
 *
 * @author Bulut Gozubuyuk
 * @version 10.10.2019
 */
public class IntBag {

    // Single property
    int bag[];

    // Constructor
    public IntBag() {
        this.bag = new int[4];
        this.bag[0] = -1;
    }

    /**
     * Adds a value to bag
     *
     * @param value to be added to bag
     * @return added value
     */
    public int add(int value) {
        int index = findIndex();

        if (index + 1 == bag.length) {
            // Create new array if size is not enough
            int extendedArr[] = new int[bag.length * 2];

            for (int i = 0; i < bag.length; i++) {
                extendedArr[i] = bag[i];
            }
            bag = extendedArr;
        }

        bag[index + 1] = -1;
        bag[index] = value;
        return value;
    }

    /**
     * @param value added to bag
     * @param index of bag to be added
     */
    public void add(int value, int index) {
        int size = findIndex();

        if (size + 1 == bag.length) {
            // Create new array if size is not enough
            int extendedArr[] = new int[bag.length * 2];

            for (int i = 0; i < bag.length; i++) {
                extendedArr[i] = bag[i];
            }
            bag = extendedArr;
        }

        if (index < size) {
            for (int i = size; i >= index; i--) {
                bag[i + 1] = bag[i];
            }
            bag[index] = value;
        } else {
            System.out.println("Out of bounds!");
        }
    }

    /**
     * Remove all values that matches the input from bag
     *
     * @param value to be removed from bag
     */
    public void removeAll(int value) {
        int size = findIndex();

        for (int i = 0; i < size; i++) {
            if (bag[i] == value) {
                remove(i);
                i--;
            }
        }
    }

    /**
     * Get size of the bag or find index of the -1 value
     *
     * @return index and size
     */
    public int findIndex() {

        for (int i = 0; i < bag.length; i++) {
            if (bag[i] == -1) return i;
        }
        return -1;
    }

    /**
     * Remove value from bag
     *
     * @param index to be removed from bag
     */
    public void remove(int index) {
        int size = findIndex();

        for (int i = index; i <= size; i++) {
            bag[i] = bag[i + 1];
        }

    }

    /**
     * A method that checks a value is in the bag or not
     *
     * @param value to be checked
     * @return contains or not
     */
    public boolean contains(int value) {
        boolean found;
        found = false;
        for (int element : bag) {
            if (element == value) {
                found = true;
            }
        }
        return found;
    }

    /**
     * A method that provides value at specified location
     *
     * @param location index to get value from
     * @return value
     */
    public int getValue(int location) {
        return bag[location];
    }

    /**
     * To string method
     *
     * @return string to show info about bag
     */
    @Override
    public String toString() {
        String repr = "";

        if (findIndex() == 0) {
            repr += "Collection is empty";
        } else {
            for (int i = 0; i < findIndex(); i++) {
                repr += bag[i] + ", ";
            }
        }
        return repr;
    }

    /**
     * A method that gets item at index
     *
     * @param index index
     * @return item
     */
    public int get(int index) {
        return bag[index];
    }

    /**
     * A method that returns size
     *
     * @return size
     */
    public int size() {
        return findIndex();
    }

    /**
     * A method that creates and returns iterator
     *
     * @return iterator
     */
    public Iterator iterator() {
        return new IntBagIterator(this);
    }

    public class IntBagIterator implements IntIterator {

        IntBag aBag;
        int index;

        // Constructor
        public IntBagIterator(IntBag bag) {
            this.aBag = bag;
            this.index = 0;
        }

        /**
         * A method that checks whether next object exists
         *
         * @return has next
         */
        @Override
        public boolean hasNext() {
            if (index < aBag.size()) return true;
            return false;
        }

        /**
         * A method that gets the next object
         *
         * @return next
         */
        @Override
        public Object next() {
            Integer i;
            if (hasNext()) i = new Integer(aBag.get(index));
            else i = new Integer(-1);

            index++;
            return i;
        }

        /**
         * A method that returns next int
         *
         * @return next int
         */
        @Override
        public int nextInt() {
            int i;
            if (hasNext()) i = aBag.get(index);
            else i = -1;

            index++;
            return i;
        }
    }
}

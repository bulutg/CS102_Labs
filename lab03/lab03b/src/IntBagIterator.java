import java.util.Iterator;

/**
 * @author Bulut Gozubuyuk
 * @version 31.10.2019
 */
public class IntBagIterator implements IntIterator {

    // Variables
    IntBag aBag;
    int index;

    // Constructor
    public IntBagIterator(IntBag bag) {
        this.aBag = bag;
        this.index = 0;
    }

    /**
     * A method that check whether next object exists or not
     * @return has next
     */
    @Override
    public boolean hasNext() {
        if (index < aBag.size())  return true;
        return false;
    }

    /**
     * A method that returns next object
     * @return next Object
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
     * A method that gets the next int
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

import java.util.Iterator;

/**
 * @author Bulut Gozubuyuk
 * @version 31.10.2019
 */
public class TestIterators {
    public static void main(String[] args){

        //Initialization
        IntBag bag;

        bag = new IntBag();

        // fill bag
        bag.add(1);
        bag.add(3);
        bag.add(5);
        bag.add(7);

        Iterator i, j;
        i = new IntBagIterator( bag );
        while ( i.hasNext() ) {
            System.out.println( i.next() );
            j = new IntBagIterator( bag );
            // j = bag.iterator();
            while ( j.hasNext() ) {
                System.out.println( "--" + j.next() );
            }
        }
    }
}

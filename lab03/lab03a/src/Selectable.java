/**
 * Selectable interface
 * @author Bulut Gozubuyuk
 * @version 31.10.2019
 */
public interface Selectable {
    boolean getSelected();
    void setSelected( boolean selected );
    Shape contains ( int x, int y );
}

import javax.swing.plaf.nimbus.State;
import java.util.ArrayList;

public class DoNuoc {
    public static int x, y;
    public static ArrayList<state> getNextState(int x1, int y1){
        ArrayList<state> list = new ArrayList<>();
        list.add(new state(x1, 0));
        list.add(new state(0, y1));
        list.add(new state(x, y1));
        list.add(new state(x1, y));
        if (x1 + y1 > x) {
            list.add(new state(x, x1 + y1 - x));
        }else {
            list.add(new state(x1 + y1, 0));
        }
        if( x1 + y1 > y) {
            list.add(new state(x1 + y1 - y, y));
        }else {
            list.add(new state(x1 + y1, 0));
        }
        return list;
    }
    public static void main(String[] args) {
        x = 8; y = 7;
        ArrayList<state> l = getNextState(3, 5);
        for(state s : l) {
            System.out.println(s.getX() + "," + s.getY());
        }
    }
}
class state{
    int x;
    int y;

    public state(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

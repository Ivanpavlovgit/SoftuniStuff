package MathOperation;

import java.util.List;

public class MathOperation {
    private Integer sum;
    private List<Integer> values;


    public static int add (int i,int i1) {
        return i + i1;
    }

    public static int add (int i,int i1,int i2) {
        return add (i,i1) + i2;
    }

    public static int add (int i,int i1,int i2,int i3) {
        return add (i,i1,i2) + i3;
    }
}

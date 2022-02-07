package Misc;

import java.util.ArrayList;

public class Convert {
    public static Integer Bool2Int(boolean bool) {
        Integer value;
        if (bool) {
            value = 1;
        } else {
            value = 0;
        }
        return value;
    }

    public static boolean Int2Bool(Integer value) {
        boolean bool;
        if (value == 1) {
            bool = true;
        } else {
            bool = false;
        }
        return bool;
    }

    public static int Array2Int(ArrayList<Integer> arr) {
        int out = 0;
        for (int i = 0; i < arr.size(); ++i) {
            out += (Math.pow(10, i))*arr.get(i);
        }
        return out;
    }

}

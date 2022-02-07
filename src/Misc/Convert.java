package Misc;

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
}

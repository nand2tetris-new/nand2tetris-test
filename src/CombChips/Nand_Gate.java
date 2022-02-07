package CombChips;

import Misc.Convert;

class Nand_Gate {
    
    protected static Integer Nand(Integer a, Integer b) {
        boolean bool_a = Convert.Int2Bool(a);
        boolean bool_b = Convert.Int2Bool(b);

        boolean bool_final = (!bool_a || !bool_b);
        return Convert.Bool2Int(bool_final);
    }
}
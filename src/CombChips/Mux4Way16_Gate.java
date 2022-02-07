package CombChips;

import java.util.ArrayList;
import Misc.Convert;

class Mux4Way16_Gate extends Mux16_Gate {
    protected static ArrayList<Integer> Mux4Way16(int a, int b, int c, int d, int sel) throws Exception {
        String string_sel = String.valueOf(sel);
        String[] blocks = string_sel.split("");

        ArrayList<Integer> sel_blocks = new ArrayList<>();
        sel_blocks.add(1);

        if (blocks.length == 1) {
            sel_blocks.add(0);
        }

        if (blocks.length <= 2) {
            
            for (int i = 0; i < blocks.length; ++i) {
                sel_blocks.add(Integer.valueOf(blocks[i]));
            }

            ArrayList<Integer> temp1 = Mux16(a, b, sel_blocks.get(2));
            ArrayList<Integer> temp2 = Mux16(c, d, sel_blocks.get(2));
            ArrayList<Integer> out = Mux16(Convert.Array2Int(temp1), Convert.Array2Int(temp2), sel_blocks.get(1));

            return out;

        } else {
            throw new Exception("Length of selector input is greater than 2");
        }
    }
}
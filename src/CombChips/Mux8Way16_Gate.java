package CombChips;

import java.util.ArrayList;

import Misc.Convert;

class Mux8Way16_Gate extends Mux4Way16_Gate {
    protected static ArrayList<Integer> Mux8Way16(int a, int b, int c, int d, int e, int f, int g, int h, int sel) throws Exception {
        String string_sel = String.valueOf(sel);
        String[] blocks = string_sel.split("");
        
        ArrayList<Integer> sel_blocks = new ArrayList<>();
        sel_blocks.add(1);
        
        if (blocks.length == 1) {
            sel_blocks.add(0);
            sel_blocks.add(0);
        }

        if (blocks.length == 2) {
            sel_blocks.add(0);
        }
        
        if (blocks.length <= 3) {
                    
            for (int i = 0; i < blocks.length; ++i) {
                sel_blocks.add(Integer.valueOf(blocks[i]));
            }
        
            ArrayList<Integer> temp1 = Mux4Way16(a, b, c, d, sel_blocks.get(3));
            ArrayList<Integer> temp2 = Mux4Way16(e, f, g, h, sel_blocks.get(3));
            ArrayList<Integer> out = Mux16(Convert.Array2Int(temp1), Convert.Array2Int(temp2), sel_blocks.get(2));
        
                return out;
        
        } else {
                throw new Exception("Length of selector input is greater than 3");
        }
    }

}
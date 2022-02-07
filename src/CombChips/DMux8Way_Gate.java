package CombChips;

import java.util.ArrayList;

class DMux8Way_Gate extends DMux4Way_Gate {
    protected static ArrayList<Integer> DMux8Way(int in, int sel) throws Exception {
        ArrayList<Integer> out = new ArrayList<>();

        String string_sel = String.valueOf(sel);

        String[] sel_blocks = string_sel.split("");

        ArrayList<Integer> selblocks_int = new ArrayList<>();
        selblocks_int.add(1); // to prevent conversion to octal

        if (sel_blocks.length == 1) {
            selblocks_int.add(0); // to prevent length issues
            selblocks_int.add(0); // to prevent length issues
        }

        if (sel_blocks.length == 2) {
            selblocks_int.add(0); // to prevent length issues
        }

        if (sel_blocks.length <= 3 && (in == 0 || in == 1)) {

            for (int i = 0; i < sel_blocks.length; ++i) {
                selblocks_int.add(Integer.valueOf(sel_blocks[i]));
            }

            ArrayList<Integer> tempout = DMux(in, selblocks_int.get(1));
            ArrayList<Integer> out1 = DMux4Way(tempout.get(0), 10*selblocks_int.get(2)+selblocks_int.get(3));
            ArrayList<Integer> out2 = DMux4Way(tempout.get(1), 10*selblocks_int.get(2)+selblocks_int.get(3));

            for (int i = 0; i < out1.size(); ++i) {
                out.add(out1.get(i));
            }

            
            for (int i = 0; i < out1.size(); ++i) {
                out.add(out2.get(i));
            }
        }  else {
            throw new Exception("Check your given values!");
    }
        return out;
    }
}
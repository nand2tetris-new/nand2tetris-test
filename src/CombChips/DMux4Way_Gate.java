package CombChips;

import java.util.ArrayList;

class DMux4Way_Gate extends DMux_Gate {

    protected static ArrayList<Integer> DMux4Way(int in, int sel) throws Exception {
        ArrayList<Integer> out = new ArrayList<>();

        String string_sel = String.valueOf(sel);

        String[] sel_blocks = string_sel.split("");

        ArrayList<Integer> selblocks_int = new ArrayList<>();
        selblocks_int.add(1); // to prevent conversion to octal

        if (sel_blocks.length == 1) {
            selblocks_int.add(0); // to prevent conversion to octal
        }

        if (sel_blocks.length <= 2 && (in == 0 || in == 1)) {

            for (int i = 0; i < sel_blocks.length; ++i) {
                selblocks_int.add(Integer.valueOf(sel_blocks[i]));
            }

            ArrayList<Integer> tempout = DMux(in, selblocks_int.get(1));
            ArrayList<Integer> out1 = DMux(tempout.get(0), selblocks_int.get(2));
            ArrayList<Integer> out2 = DMux(tempout.get(1), selblocks_int.get(2));
            
            out.add(out1.get(0));
            out.add(out1.get(1));
            out.add(out2.get(0));
            out.add(out2.get(1));

            return out;

        } else {
                throw new Exception("Check your given values!");
        }
    }
}
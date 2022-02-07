package CombChips;

import java.util.ArrayList;

class Not16_Gate extends Not_Gate {

    protected static ArrayList<Integer> Not16(Integer a) {
        ArrayList<Integer> out = new ArrayList<>();
        String string_a = String.valueOf(a);

        String[] blocks = string_a.split("");

        ArrayList<Integer> blocks_int = new ArrayList<>();
        blocks_int.add(1);
        for (int i = 0; i < blocks.length; ++i) {
            blocks_int.add(Integer.valueOf(blocks[i]));
            out.add(Not(blocks_int.get(i+1)));
        }

        return out;
    }
}
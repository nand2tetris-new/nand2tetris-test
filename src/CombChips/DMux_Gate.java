package CombChips;

import java.util.ArrayList;

class DMux_Gate extends And_Gate {

    protected static ArrayList<Integer> DMux(Integer in, Integer sel) {
        ArrayList<Integer> out = new ArrayList<>();
        out.add(And(in, Not(sel)));
        out.add(And(in, sel));
        return out; 
    }
}
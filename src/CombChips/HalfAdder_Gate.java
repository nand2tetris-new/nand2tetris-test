package CombChips;

import java.util.ArrayList;

class HalfAdder_Gate extends Xor_Gate {
    protected static ArrayList<Integer> HalfAdder(int a, int b) {
        ArrayList<Integer> out = new ArrayList<>();

        out.add(Xor(a, b));
        out.add(And_Gate.And(a, b));

        return out;
    }
}

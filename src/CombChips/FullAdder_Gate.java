package CombChips;

import java.util.ArrayList;

class FullAdder_Gate extends HalfAdder_Gate {
    protected static ArrayList<Integer> FullAdder(int a, int b, int c) {
        ArrayList<Integer> out = new ArrayList<>();
        
        ArrayList<Integer> ab = HalfAdder(a, b);
        ArrayList<Integer> sum = HalfAdder(ab.get(0), c);
        int carry = Or(ab.get(1), sum.get(1));

        out.add(sum.get(0));
        out.add(carry);

        return out;
    }
}
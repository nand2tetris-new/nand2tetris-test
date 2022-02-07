package CombChips;

import java.util.ArrayList;

class Mux16_Gate extends Mux_Gate {

    protected static ArrayList<Integer> Mux16(Integer a, Integer b, Integer sel) throws Exception {
        ArrayList<Integer> out = new ArrayList<>();
        String string_a = String.valueOf(a);
        String string_b = String.valueOf(b);
    
        String[] blocks_a = string_a.split("");
        String[] blocks_b = string_b.split("");
    
        ArrayList<Integer> digits_a = new ArrayList<>();
        digits_a.add(1); // to prevent conversion to octal
        ArrayList<Integer> digits_b = new ArrayList<>();
        digits_b.add(1); // to prevent conversion to octal
            
        if (blocks_a.length >= blocks_b.length) {
            for (int i = 0; i < blocks_a.length; ++i) {
                digits_a.add(Integer.valueOf(blocks_a[i]));
                digits_b.add(Integer.valueOf(blocks_b[i]));
                out.add(Mux(digits_a.get(i+1), digits_b.get(i+1), sel));
            }

        } else {
            throw new Exception("Make sure that the length of first parameter is more or equal to second parameter.");
        }
    
        return out;
    }
}

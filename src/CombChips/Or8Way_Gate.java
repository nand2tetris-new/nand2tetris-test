package CombChips;

import java.util.ArrayList;

class Or8Way_Gate extends Or_Gate {

    protected static int Or8Way(int a) throws Exception {
        String string_a = String.valueOf(a);

        String[] blocks = string_a.split("");

        ArrayList<Integer> blocks_int = new ArrayList<>();
        blocks_int.add(1); // to prevent conversion to octal
        
        if (blocks.length <= 8) {
            for (int i = 0; i < blocks.length; ++i) {
                blocks_int.add(Integer.valueOf(blocks[i]));
            }

            int temp = blocks_int.get(1);
            int out = 0;

            for (int i = 0; i < blocks.length; ++i) {
                out = Or(temp, blocks_int.get(i+1));
                temp = out;
            }

            return out;

        } else {
                throw new Exception("Length of input is greater than 8");
        }
    }
}

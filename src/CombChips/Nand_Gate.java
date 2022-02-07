package CombChips;

import java.util.ArrayList;

import Misc.Convert;

class Nand_Gate {
    
    protected static Integer Nand(Integer a, Integer b) {
        boolean bool_a = Convert.Int2Bool(a);
        boolean bool_b = Convert.Int2Bool(b);

        boolean bool_final = (!bool_a || !bool_b);
        return Convert.Bool2Int(bool_final);
    }
}

class Not_Gate extends Nand_Gate {

    protected static Integer Not(Integer a) {
        return Nand(a, a);
    }
}

class And_Gate extends Not_Gate {

    protected static Integer And(Integer a, Integer b) {
        return Not(Nand(a, b));
    }
}

class Or_Gate extends Not_Gate {

    protected static Integer Or(Integer a, Integer b) {
        return Nand(Not(a), Not(b));
    }
}

class Xor_Gate extends Or_Gate {

    protected static Integer Xor(Integer a, Integer b) {
        Integer OrofNots = Or(Not(a), Not(b));
        Integer Or = Or(a, b);
        return And_Gate.And(Or, OrofNots);
    }
}

class Mux_Gate extends And_Gate {

    protected static Integer Mux(Integer a, Integer b, Integer sel) {
        Integer first = And(a, Not(sel));
        Integer second = And(b, sel);
        return Or_Gate.Or(first, second);
    }
}

class DMux_Gate extends And_Gate {

    protected static ArrayList<Integer> DMux(Integer in, Integer sel) {
        ArrayList<Integer> out = new ArrayList<>();
        out.add(And(in, Not(sel)));
        out.add(And(in, sel));
        return out; 
    }
}

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

class And16_Gate extends And_Gate {

    protected static ArrayList<Integer> And16(Integer a, Integer b) throws Exception {
        ArrayList<Integer> out = new ArrayList<>();
        String string_a = String.valueOf(a);
        String string_b = String.valueOf(b);

        String[] blocks_a = string_a.split("");
        String[] blocks_b = string_b.split("");

        ArrayList<Integer> digits_a = new ArrayList<>();
        digits_a.add(1); // to prevent conversion to octal
        ArrayList<Integer> digits_b = new ArrayList<>();
        digits_b.add(1); // to prevent conversion to octal
        
        if (blocks_a.length == blocks_b.length) {
            for (int i = 0; i < blocks_a.length; ++i) {
                digits_a.add(Integer.valueOf(blocks_a[i]));
                digits_b.add(Integer.valueOf(blocks_b[i]));
                out.add(And(digits_a.get(i+1), digits_b.get(i+1))); 
            }

        } else {
            throw new Exception("Lengths of both inputs are not equal");
        }

        return out;
    }
}

class Or16_Gate extends Or_Gate {

    protected static ArrayList<Integer> Or16(Integer a, Integer b) throws Exception {
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
                out.add(Or(digits_a.get(i+1), digits_b.get(i+1)));
            }

        } else {
            throw new Exception("Make sure that the length of first parameter is more or equal to second parameter.");
        }
    
        return out;
    }
}

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
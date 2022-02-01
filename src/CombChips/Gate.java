package CombChips;

class Gate {

    protected static int Nand(int a, int b) {
        if (a == 1 && b == 1) {
            return 0;
        }
        else {
            return 1;
        }
    }


    protected static int Not(int a) {
        return Nand(a, a);
    }


    protected static int And(int a, int b) {
        return Not(Nand(a, b));
    }


    protected static int Or(int a, int b) {
        return Nand(Not(a), Not(b));
    }


    protected static int Xor(int a, int b) {
        return Not(Or(a, b));
    }


    protected static int Mux(int a, int b, int sel) {
        return Or((And(a, Not(sel))),
                   And(b, sel));
    } 


    protected static int[] DMux(int in, int sel) {
        int[] out = new int[2];
        out[0] = And(in, Not(sel));
        out[1] = And(in, sel);
        return out;
    }


    protected static int And3Way(int a, int b, int c) {
        return And(And(a, b), c);
    }


    protected static int And4Way(int a, int b, int c, int d) {
        return And(And(And(a, b), c), d);
    }

    protected static int Or3Way(int a, int b, int c) {
        return Or(Or(a, b), c);
    }


    protected static int Or4Way(int a, int b, int c, int d) {
        return Or(Or(Or(a, b), c), d);
    }

    protected static int[] Not16(int a) {
        int[] arr_a = new int[16];
        int[] c = new int[16];
        for (int i = 0; i < 16; ++i) {
            arr_a[15-i] = a % 2;
            a /= 2;
            c[i] = Not(arr_a[i]);
        }
        return c;
    }

    protected static int[] And16(int a, int b) {
        int[] arr_a = new int[16];
        int[] arr_b = new int[16];
        int[] c = new int[16];
        for (int i = 0; i < 16; ++i) {
            arr_a[15-i] = a % 2;
            arr_b[15-i] = b % 2;
            a /= 2; b /= 2;
            c[i] = And(arr_a[i], arr_b[i]);
        }
        return c;
    }

    protected static int[] Or16(int a, int b) {
        int[] arr_a = new int[16];
        int[] arr_b = new int[16];
        int[] c = new int[16];
        for (int i = 0; i < 16; ++i) {
            arr_a[15-i] = a % 2;
            arr_b[15-i] = b % 2;
            a /= 2; b /= 2;
            c[i] = Or(arr_a[i], arr_b[i]);
        }
        return c;
    }

    protected static int[] Mux16(int a, int b, int sel) {
        int[] arr_a = new int[16];
        int[] arr_b = new int[16];
        int[] c = new int[16];
        for (int i = 0; i < 16; ++i) {
            arr_a[15-i] = a % 2;
            arr_b[15-i] = b % 2;
            a /= 2; b /= 2;
            c[i] = Mux(arr_a[i], arr_b[i], sel);
        }
        return c;
    }

    protected static int Or8Way(int in) {
        int c = 1;
        int[] arr_in = new int[8];
        for (int i = 0; i < 8; ++i) {
            arr_in[7-i] = in % 2;
            in /= 2;
        }

        for (int i = 0; i < 7; ++i) {
            c *= Or(arr_in[i], arr_in[i+1]);
        }

        return c;
    }

    protected static int[] DMux4Way(int in, int sel) throws Exception {
        int[] out = new int[4];
        if (sel == 00) {
            out[0] = in;
        }
        else if (sel == 01) {
            out[1] = in;
        }
        else if (sel == 10) {
            out[2] = in;
        }
        else if (sel == 11) {
            out[3] = in;
        }
        else {
            throw new Exception("Invalid Values");
        }
        return out;
    }
}

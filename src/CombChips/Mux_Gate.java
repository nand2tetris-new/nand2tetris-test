package CombChips;

class Mux_Gate extends And_Gate {

    protected static Integer Mux(Integer a, Integer b, Integer sel) {
        Integer first = And(a, Not(sel));
        Integer second = And(b, sel);
        return Or_Gate.Or(first, second);
    }
}
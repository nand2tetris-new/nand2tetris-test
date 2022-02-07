package CombChips;

class Xor_Gate extends Or_Gate {

    protected static Integer Xor(Integer a, Integer b) {
        Integer OrofNots = Or(Not(a), Not(b));
        Integer Or = Or(a, b);
        return And_Gate.And(Or, OrofNots);
    }
}

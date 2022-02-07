package CombChips;

class And_Gate extends Not_Gate {

    protected static Integer And(Integer a, Integer b) {
        return Not(Nand(a, b));
    }
}
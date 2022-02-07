package CombChips;

class Or_Gate extends Not_Gate {

    protected static Integer Or(Integer a, Integer b) {
        return Nand(Not(a), Not(b));
    }
}
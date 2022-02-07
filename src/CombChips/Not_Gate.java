package CombChips;

class Not_Gate extends Nand_Gate {

    protected static Integer Not(Integer a) {
        return Nand(a, a);
    }
}
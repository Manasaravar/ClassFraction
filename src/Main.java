public class Main {
    public static void main(String[] args) {
        /*Fraction A = new Fraction();
        A.print();
        System.out.println(A.getDenominator());
        Fraction B = new Fraction(5);
        B.print();*/
        Fraction C = new Fraction(2,3, 4);
        C.print();
        Fraction D = new Fraction(3,4,5);
        D.print();

        Fraction E = new Fraction();

        E = C.add(D);
        System.out.println(E.toString());

        System.out.println();
        E = C.sub(D);
        E.print();

        System.out.println();
        E = C.mul(D);
        E.print();

        System.out.println();
        E = C.div(D);
        E.print();

        System.out.println();
        E = D.increment();
        E.print();

        System.out.println();
        E = D.decrement();
        E.print();

        System.out.println(C.toString() + " " + Fraction.compareToFraction(C,D) + " " +  D.toString());



    }
}
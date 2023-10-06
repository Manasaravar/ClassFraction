public class Fraction {
    private int integer;
    private int numerator;
    private int denominator;
    // Encapsulation
    public int getInteger() {
        return integer;
    }
    public int getNumerator(){
        return numerator;
    }
    public int getDenominator() {
        return denominator;
    }
    public void setInteger (int integer) {
        this.integer = integer;
    }
    public void setNumerator (int numerator){
        this.numerator = numerator;
    }
    public void setDenominator (int denominator) {
        if (denominator == 0) denominator = 1;
        this.denominator = denominator;
    }
    // Constructors
public Fraction() {
        setDenominator(1);
        System.out.println("DefaultConstructor: " + Integer.toHexString(this.hashCode()));
}
public Fraction(int integer){
        setInteger(integer);
        setNumerator(0);
        setDenominator(1);
    System.out.println("1ArgConstructor: " + Integer.toHexString(this.hashCode()));

}
public Fraction (int numerator, int denominator) {
        setInteger(0);
        setNumerator(numerator);
        setDenominator(denominator);
    System.out.println("2ArgConstructor: " + Integer.toHexString(this.hashCode()));
}
    public Fraction (int integer, int numerator, int denominator) {
        setInteger(integer);
        setNumerator(numerator);
        setDenominator(denominator);
        System.out.println("3ArgConstructor: " + Integer.toHexString(this.hashCode()));
    }
    public Fraction (Fraction other) {
        this.integer = other.integer;
        this.numerator = other.numerator;
        this.denominator = other.denominator;
        System.out.println("CopyConstructor: " + Integer.toHexString(this.hashCode()));
    }
    // Methods
    public void print () {
        if (integer != 0) System.out.print((integer));
        if (numerator != 0) {
            if (integer != 0) System.out.print("(");
            System.out.print(numerator + "/" + denominator);
            if (integer != 0) System.out.print(")");
        } else if (integer == 0) System.out.print(0);
        System.out.println();
    }
    public String toString() {
        return integer != 0 ? "%d(%d/%d)".formatted(integer,numerator,denominator) : "%d/%d".formatted(numerator,denominator) ;
    }
    // Действия с дробями
    // Сложение
    public Fraction add (Fraction other) {
        int num1, num2;
        if (this.integer == 0) {
            num1 = this.numerator;
        } else num1 = this.denominator * this.integer + this.numerator;
        if (other.integer == 0) {
            num2 = other.numerator;
        } else num2 = other.denominator * other.integer + other.numerator;
        int den = NOK(this.denominator, other.denominator);
        int num = num1 * (den / this.denominator) + num2 * (den / other.denominator);
        int integerAll = num/den;
        num = num%den;
        return new Fraction(integerAll, num, den);
      /*  int den = NOK(this.denominator, other.denominator);
        int num = this.numerator * (den / this.denominator) + other.numerator * (den / other.denominator);
        if (integer == 0) {
            return new Fraction(num, den);
        } else return new Fraction(this.integer + other.integer, num, den);*/
    }
    // вычитание
    public Fraction sub (Fraction other) {
        int num1, num2;
        if (this.integer == 0) {
            num1 = this.numerator;
        } else num1 = this.denominator * this.integer + this.numerator;
        if (other.integer == 0) {
            num2 = other.numerator;
        } else num2 = other.denominator * other.integer + other.numerator;
        int den = NOK(this.denominator, other.denominator);
        int num = num1 * (den / this.denominator) - num2 * (den / other.denominator);
        int integerAll = num/den;
        num = num%den;
        return new Fraction(integerAll, num, den);

        /*int den = NOK(this.denominator, other.denominator);
        int num = this.numerator * (den / this.denominator) - other.numerator * (den / other.denominator);
        if (integer == 0) {
            return new Fraction(num, den);
        } else return new Fraction(this.integer + other.integer, num, den);*/
    }
    // Умножение
    public Fraction mul (Fraction other) {
        int num1, num2;
        if (this.integer == 0) {
            num1 = this.numerator;
        } else num1 = this.denominator * this.integer + this.numerator;
        if (other.integer == 0) {
            num2 = other.numerator;
        } else num2 = other.denominator * other.integer + other.numerator;
        return new Fraction(num1 * num2, this.denominator * other.denominator);
    }
    // Деление
    public Fraction div (Fraction other) {
        int num1, num2;
            if (this.integer == 0) {
                num1 = this.numerator;
            } else num1 = this.denominator * this.integer + this.numerator;
        if (other.integer == 0) {
            num2 = other.numerator;
        }   num2 = other.denominator * other.integer + other.numerator;
        return new Fraction (num1 * other.denominator, this.denominator * num2);
    }
//Увеличивает целую часть на 1
    public Fraction increment () {
        return new Fraction(integer + 1, numerator, denominator);
    }
    //Уменьшает целую часть на 1
    public Fraction decrement () {
        Fraction other = new Fraction(this.denominator, this.denominator);
        return integer == 0 ? this.sub(other) : new Fraction(integer - 1, numerator, denominator);
    }
// Сравнение дробей
    public static String compareToFraction (Fraction head, Fraction other) {
        String result;
        int fract1,fract2;
        if (head.integer == 0) {
            fract1 = head.numerator * other.denominator;
        } else fract1 = (head.denominator * head.integer + head.numerator) * other.denominator;
        if (other.integer == 0) {
            fract2 = other.numerator * head.denominator;
        } else fract2 = (other.denominator * other.integer + other.numerator) * head.denominator;

        if (fract1 == fract2) {
            result = "равно";
        }
        else if (fract1 > fract2) result = "больше";
        else result = "меньше";
        return result;

    }
    //Наибольший общий делитель
   public int NOD (int a, int b) {
        while (a != b) {
        if (a > b)
            a = a - b;
         else
            b = b - a;
        }
    return a;
}
// Наименьшее общее кратное
    public int NOK (int a, int b) {
        return a / NOD(a,b) * b;
    }

}


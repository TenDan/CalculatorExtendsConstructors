package pl.maciejslusarz;


class Calculate {

    double a = 0, b = 0;

    Calculate(double a) {
        this.a = a;
    }

    Calculate(double a, double b) {
        this.a = a;
        this.b = b;
    }

    double add() {
        return this.a + this.b;
    }
    double subtract() {
        return this.a - this.b;
    }
    double multiply() {
        return this.a * this.b;
    }
    double divide() {
        return this.a / this.b;
    }
    int rest() {
        return (int)(this.a % this.b);
    }
    double sinus() {
        return Math.sin(a);
    }
    double cosinus() {
        return Math.cos(a);
    }
    double power() {
        return Math.pow(a,b);
    }
    double sqrt() {
        return Math.sqrt(a);
    }
}
package com.aleks.linum;

public class Fraction {
    private int nominator;
    private int denominator;
    Fraction(){
        nominator = 0;
        denominator = 1;
    }
    Fraction(int a){
        nominator = a;
        denominator = 1;
    }
    Fraction(int a, int b){
        nominator = a;
        denominator = b;
        if ( denominator < 0){
            nominator *= -1;
            denominator *= -1;
        }
    }
    private void fix(){
        if (denominator < 0 )
        {
            nominator *= -1;
            denominator *= -1;
        }
    }
    private void simplify(){
        int nod = 2;
        boolean flag = false;
        if (nominator < 0)
        {
            flag = true;
            nominator *= -1;
        }
        while (nod <= nominator && nod <= denominator)
        {
            if ((nominator % nod == 0) && (denominator % nod == 0))
            {
                nominator /= nod;
                denominator /= nod;
            }
            else
                nod++;
        }
        if (flag)
        {
            nominator *= -1;
        }

    }
    public Fraction add(Fraction obj){
        Fraction temp = new Fraction(nominator * obj.denominator + obj.nominator*denominator, denominator * obj.denominator);
        temp.simplify();
        temp.fix();
        return temp;
    }
    public Fraction multiply(int i) {
        Fraction temp = new Fraction(nominator * i, denominator);
        temp.simplify();
        return temp;
    }
    public Fraction mupltiply(Fraction obj){
        Fraction temp = new Fraction(nominator*obj.nominator, denominator*obj.denominator);
        temp.simplify();
        return  temp;
    }
    public Fraction divide(int i){
        Fraction temp = new Fraction(nominator, denominator * i);
        temp.fix();
        temp.simplify();
        return temp;
    }
    public Fraction divide(Fraction obj){
        Fraction temp = new Fraction(nominator * obj.denominator, denominator * obj.nominator);
        temp.fix();
        temp.simplify();
        return temp;
    }
    public String toString() {
        if (denominator == 0 || nominator == 0){
            return "" + nominator;
        }
        else
            return "" + nominator + "/" + denominator;
    }
}

package com.aleks.linum;

public class Matrix {
    private Fraction[][] arr;
    Matrix(int a){
        arr = new Fraction[a][a];
    }
    Matrix(int a, int b){
        arr = new Fraction[a][b];
    }
    Matrix(Fraction[][] arr_){
        arr = arr_;
    }
    public Matrix transponate(){
        Fraction[][] temp = new Fraction[arr[0].length][arr.length];
        for (int i  =0 ; i < arr.length; i++){
            for (int g = 0; g < arr[0].length; g++){
                temp[g][i] = arr[i][g];
            }
        }
        arr = temp;
        return this;
    }
    public Matrix add(Matrix obj){
        if (!(arr.length == obj.arr.length && arr[0].length == obj.arr[0].length)){
            return this;
        }
        for (int i = 0; i < arr.length; i++)
        {
            for (int g = 0; g < arr[0].length; g++)
            {
                arr[i][g] = arr[i][g].add(obj.arr[i][g]);
            }
        }
        return this;
    }
    public Matrix multiply(int i){
        for (int g = 0; g < arr.length; g++){
            for (int k = 0; k < arr[0].length; k++){
                arr[i][g] = arr[i][g].multiply(i);
            }
        }
        return this;
    }
    public Matrix multiply(Matrix obj){
        if (arr[0].length != obj.arr.length)
            return this;
        Fraction[][] temp = new Fraction[arr.length][obj.arr[0].length];
        int sizey  = temp.length;
        int sizex = temp[0].length;
        for (int i = 0; i < sizey; i++) //умножение матрицы
        {
            for (int g = 0; g < sizex; g++)
            {
                Fraction sum = new Fraction(0);
                for (int y = 0; y < arr[0].length; y++) //y - для прохода по строке в левом массиве и столбцу в правом
                {
                    sum = sum.add(arr[i][y].mupltiply(obj.arr[y][g]));
                }
                temp[i][g] = sum;
            }
        }
        arr = temp;
        return this;
    }
}

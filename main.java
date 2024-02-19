import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать! Что вы хотите сделать? Выберете число:");
        System.out.println("1. Создать комплексное число");
        System.out.println("2. Сложить два комплексных числа");
        System.out.println("3. Создать матрицу");
        System.out.println("4. Сложить две матрицы");
        System.out.println("5. Умножить две матрицы");
        System.out.println("6. Транспонировать матрицу");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Введите действительную часть комплексного числа:");
                double real = scanner.nextDouble();
                System.out.println("Введите мнимую часть комплексного числа:");
                double imaginary = scanner.nextDouble();
                ComplexNumber num = new ComplexNumber(real, imaginary);
                System.out.println("Создано комплексное число: " + num);
                break;

            case 2:
                System.out.println("Введите действительную часть первого комплексного числа:");
                double real1 = scanner.nextDouble();
                System.out.println("Введите мнимую часть первого комплексного числа:");
                double imaginary1 = scanner.nextDouble();
                ComplexNumber num1 = new ComplexNumber(real1, imaginary1);

                System.out.println("Введите действительную часть второго комплексного числа:");
                double real2 = scanner.nextDouble();
                System.out.println("Введите мнимую часть второго комплексного числа:");
                double imaginary2 = scanner.nextDouble();
                ComplexNumber num2 = new ComplexNumber(real2, imaginary2);

                System.out.println("Сумма ваших чисел: " + num1.add(num2));
                break;

            case 3:
                System.out.println("Введите количество строк в матрице:");
                int rows = scanner.nextInt();
                System.out.println("Введите количество столбцов в матрице:");
                int cols = scanner.nextInt();

                ComplexNumber[][] elements = new ComplexNumber[rows][cols];
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        System.out.println("Введите действительную часть числа на позиции [" + (i + 1) + "][" + (j + 1) + "]:");
                        double elReal = scanner.nextDouble();
                        System.out.println("Введите мнимую часть числа на позиции [" + (i + 1) + "][" + (j + 1) + "]:");
                        double elImaginary = scanner.nextDouble();
                        elements[i][j] = new ComplexNumber(elReal, elImaginary);
                    }
                }
                Matrix matrix = new Matrix(elements);
                System.out.println("Итоговая матрица:");
                System.out.println(matrix);
                break;

            case 4:
                System.out.println("Введите размерность первой матрицы.");
                System.out.print("Количество строк: ");
                int rows1 = scanner.nextInt();
                System.out.print("Количество столбцов: ");
                int cols1 = scanner.nextInt();

                System.out.println("Введите элементы первой матрицы:");
                ComplexNumber[][] elements1 = new ComplexNumber[rows1][cols1];
                for (int i = 0; i < rows1; i++) {
                    for (int j = 0; j < cols1; j++) {
                        System.out.println("Введите действительную часть числа на позиции [" + (i + 1) + "][" + (j + 1) + "]:");
                        double elReal = scanner.nextDouble();
                        System.out.println("Введите мнимую часть числа на позиции [" + (i + 1) + "][" + (j + 1) + "]:");
                        double elImaginary = scanner.nextDouble();
                        elements1[i][j] = new ComplexNumber(elReal, elImaginary);
                    }
                }
                Matrix matrix1 = new Matrix(elements1);

                System.out.println("Введите размерность второй матрицы.");
                System.out.print("Количество строк: ");
                int rows2 = scanner.nextInt();
                System.out.print("Количество столбцов: ");
                int cols2 = scanner.nextInt();

                System.out.println("Введите элементы второй матрицы:");
                ComplexNumber[][] elements2 = new ComplexNumber[rows2][cols2];
                for (int i = 0; i < rows2; i++) {
                    for (int j = 0; j < cols2; j++) {
                        System.out.println("Введите действительную часть числа на позиции [" + (i + 1) + "][" + (j + 1) + "]:");
                        double elReal = scanner.nextDouble();
                        System.out.println("Введите мнимую часть числа на позиции [" + (i + 1) + "][" + (j + 1) + "]:");
                        double elImaginary = scanner.nextDouble();
                        elements2[i][j] = new ComplexNumber(elReal, elImaginary);
                    }
                }
                Matrix matrix2 = new Matrix(elements2);

                if (rows1 == rows2 && cols1 == cols2) {
                    Matrix sumMatrix = matrix1.add(matrix2);
                    System.out.println("Сумма двух матриц:");
                    System.out.println(sumMatrix);
                } else {
                    System.out.println("Упс, ошибка! Невозможно сложить матрицы разной размерности.");
                }
                break;

            case 5:
                System.out.println("Введите количество строк первой матрицы:");
                int row1 = scanner.nextInt();
                System.out.println("Введите количество столбцов первой матрицы:");
                int col1 = scanner.nextInt();
                System.out.println("Введите количество строк второй матрицы:");
                int row2 = scanner.nextInt();
                System.out.println("Введите количество столбцов второй матрицы:");
                int col2 = scanner.nextInt();

                if (row2 != col1) {
                    System.out.println("Упс, ошибка! Количество столбцов первой матрицы должно совпадать с количеством строк второй матрицы.");
                    break;
                }

                System.out.println("Введите элементы первой матрицы:");
                ComplexNumber[][] elementsMatrix1 = new ComplexNumber[row1][col1];
                for (int i = 0; i < row1; i++) {
                    for (int j = 0; j < col1; j++) {
                        System.out.println("Введите действительную часть числа на позиции [" + (i + 1) + "][" + (j + 1) + "]:");
                        double elReal = scanner.nextDouble();
                        System.out.println("Введите мнимую часть числа на позиции [" + (i + 1) + "][" + (j + 1) + "]:");
                        double elImaginary = scanner.nextDouble();
                        elementsMatrix1[i][j] = new ComplexNumber(elReal, elImaginary);
                    }
                }
                Matrix matr1 = new Matrix(elementsMatrix1);

                System.out.println("Введите элементы второй матрицы:");
                ComplexNumber[][] elementsMatrix2 = new ComplexNumber[row2][col2];
                for (int i = 0; i < row2; i++) {
                    for (int j = 0; j < col2; j++) {
                        System.out.println("Введите действительную часть числа на позиции [" + (i + 1) + "][" + (j + 1) + "]:");
                        double elReal = scanner.nextDouble();
                        System.out.println("Введите мнимую часть числа на позиции [" + (i + 1) + "][" + (j + 1) + "]:");
                        double elImaginary = scanner.nextDouble();
                        elementsMatrix2[i][j] = new ComplexNumber(elReal, elImaginary);
                    }
                }
                Matrix matr2 = new Matrix(elementsMatrix2);

                matr1 = new Matrix(elementsMatrix1);
                matr2 = new Matrix(elementsMatrix2);

                Matrix productMatrix = matr1.multiply(matr2);
                System.out.println("Произведение двух матриц:");
                System.out.println(productMatrix);
                break;

            case 6:
                System.out.println("Введите количество строк матрицы:");
                int row = scanner.nextInt();
                System.out.println("Введите количество столбцов матрицы:");
                int col = scanner.nextInt();

                System.out.println("Введите элементы матрицы:");
                ComplexNumber[][] elementsMatrix = new ComplexNumber[row][col];
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        System.out.println("Введите действительную часть числа на позиции [" + (i + 1) + "][" + (j + 1) + "]:");
                        double elReal = scanner.nextDouble();
                        System.out.println("Введите мнимую часть числа на позиции [" + (i + 1) + "][" + (j + 1) + "]:");
                        double elImaginary = scanner.nextDouble();
                        elementsMatrix[i][j] = new ComplexNumber(elReal, elImaginary);
                    }
                }
                Matrix matr = new Matrix(elementsMatrix);

                Matrix transposedMatrix = matr.transpose();
                System.out.println("Транспонированная матрица:");
                System.out.println(transposedMatrix);
                break;


            default:
                System.out.println("Упс, ошибка! Некорректный выбор.");
        }
    }
}


class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(this.real + other.real, this.imaginary + other.imaginary);
    }

    public ComplexNumber multiply(ComplexNumber other) {
        double newReal = this.real * other.real - this.imaginary * other.imaginary;
        double newImaginary = this.real * other.imaginary + this.imaginary * other.real;
        return new ComplexNumber(newReal, newImaginary);
    }

    public String toString() {
        return this.real + " + " + this.imaginary + "i";
    }
}

class Matrix {
    private ComplexNumber[][] elements;

    public Matrix(ComplexNumber[][] elements) {
        this.elements = elements;
    }

    public Matrix add(Matrix other) {
        if (this.elements.length != other.elements.length || this.elements[0].length != other.elements[0].length) {
            throw new IllegalArgumentException("Упс, ошибка! Матрицы должны иметь одинаковые размеры для сложения");
        }

        ComplexNumber[][] result = new ComplexNumber[this.elements.length][this.elements[0].length];
        for (int i = 0; i < this.elements.length; i++) {
            for (int j = 0; j < this.elements[0].length; j++) {
                result[i][j] = this.elements[i][j].add(other.elements[i][j]);
            }
        }
        return new Matrix(result);
    }

    public Matrix multiply(Matrix other) {
        if (this.elements[0].length != other.elements.length) {
            throw new IllegalArgumentException("Упс, ошибка! Число столбцов первой матрицы должно совпадать с числом строк второй для умножения");
        }

        ComplexNumber[][] result = new ComplexNumber[this.elements.length][other.elements[0].length];
        for (int i = 0; i < this.elements.length; i++) {
            for (int j = 0; j < other.elements[0].length; j++) {
                ComplexNumber sum = new ComplexNumber(0, 0);
                for (int k = 0; k < this.elements[0].length; k++) {
                    sum = sum.add(this.elements[i][k].multiply(other.elements[k][j]));
                }
                result[i][j] = sum;
            }
        }
        return new Matrix(result);
    }
    public Matrix transpose() {
        int row = elements.length;
        int col = elements[0].length;

        ComplexNumber[][] transposedElements = new ComplexNumber[col][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                transposedElements[j][i] = elements[i][j];
            }
        }

        return new Matrix(transposedElements);
    }


    public String toString() {
        StringBuilder res = new StringBuilder();
        for (ComplexNumber[] row : elements) {
            res.append(Arrays.toString(row)).append("\n");
        }
        return res.toString();
    }
}

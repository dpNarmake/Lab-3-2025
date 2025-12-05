import functions.*;

public class Main {
    public static void main(String[] args) throws InappropriateFunctionPointException {
        System.out.println("тестирование ArrayTabulatedFunction");
        testArrayFunction();

        System.out.println("\nтестирование LinkedListTabulatedFunction");
        testLinkedListFunction();
    }

    private static void testArrayFunction() throws InappropriateFunctionPointException {
        double[] yValues = {1.0, 0.5, 0.0, -0.5, -1.0};
        TabulatedFunction arrayFunction = new ArrayTabulatedFunction(-1.0, 1.0, yValues);

        System.out.println("начальные точки:");
        printFunction(arrayFunction);

        System.out.println("\nпроверка getFunctionValue:");
        System.out.println("f(-1.0) = " + arrayFunction.getFunctionValue(-1.0));
        System.out.println("f(-0.5) = " + arrayFunction.getFunctionValue(-0.5));
        System.out.println("f(0.0) = " + arrayFunction.getFunctionValue(0.0));
        System.out.println("f(0.3) = " + arrayFunction.getFunctionValue(0.3));
        System.out.println("f(1.0) = " + arrayFunction.getFunctionValue(1.0));
        System.out.println("f(2.0) (вне диапазона) = " + arrayFunction.getFunctionValue(2.0));

        FunctionPoint newPoint = new FunctionPoint(0.57, 0.22);
        arrayFunction.setPoint(3, newPoint);

        System.out.println("\nпосле замены точки:");
        printFunction(arrayFunction);

        FunctionPoint addedPoint = new FunctionPoint(0.71, 0.34);
        arrayFunction.addPoint(addedPoint);

        System.out.println("после добавления точки:");
        printFunction(arrayFunction);

        System.out.println("\nпроверка исключений");

        try {arrayFunction.getPoint(1234);
        } catch (FunctionPointIndexOutOfBoundsException e) {
            System.out.println("поймано FunctionPointIndexOutOfBoundsException при getPoint(1234)");
        }

        try {arrayFunction.setPointX(2, 10);
        } catch (InappropriateFunctionPointException e) {
            System.out.println("поймано InappropriateFunctionPointException при setPointX(2, 10)");
        }

        try {arrayFunction.addPoint(addedPoint);
        } catch (InappropriateFunctionPointException e) {
            System.out.println("поймано InappropriateFunctionPointException при добавлении существующей точки (0.71, 0.34)");
        }

        arrayFunction.deletePoint(0);

        System.out.println("\nпосле удаления точки с индексом 0:");
        printFunction(arrayFunction);
    }

    private static void testLinkedListFunction() throws InappropriateFunctionPointException {
        double[] yValues = {2.0, 1.0, 0.0, -1.0, -2.0};
        TabulatedFunction listFunction = new LinkedListTabulatedFunction(-1.0, 1.0, yValues);

        System.out.println("начальные точки:");
        printFunction(listFunction);

        System.out.println("\nпроверка getFunctionValue:");
        System.out.println("f(-1.0) = " + listFunction.getFunctionValue(-1.0));
        System.out.println("f(-0.5) = " + listFunction.getFunctionValue(-0.5));
        System.out.println("f(0.0) = " + listFunction.getFunctionValue(0.0));
        System.out.println("f(0.3) = " + listFunction.getFunctionValue(0.3));
        System.out.println("f(1.0) = " + listFunction.getFunctionValue(1.0));
        System.out.println("f(2.0) (вне диапазона) = " + listFunction.getFunctionValue(2.0));

        FunctionPoint newPoint = new FunctionPoint(0.57, 0.22);
        listFunction.setPoint(3, newPoint);

        System.out.println("\nпосле замены точки:");
        printFunction(listFunction);

        FunctionPoint addedPoint = new FunctionPoint(0.71, 0.34);
        listFunction.addPoint(addedPoint);

        System.out.println("после добавления точки:");
        printFunction(listFunction);

        System.out.println("\nпроверка исключений");

        try {listFunction.getPoint(1234);
        } catch (FunctionPointIndexOutOfBoundsException e) {
            System.out.println("поймано FunctionPointIndexOutOfBoundsException при getPoint(1234)");
        }

        try {listFunction.setPointX(2, 10);
        } catch (InappropriateFunctionPointException e) {
            System.out.println("поймано InappropriateFunctionPointException при setPointX(2, 10)");
        }

        try {listFunction.addPoint(addedPoint);
        } catch (InappropriateFunctionPointException e) {
            System.out.println("поймано InappropriateFunctionPointException при добавлении существующей точки (0.71, 0.34)");
        }

        listFunction.deletePoint(0);

        System.out.println("\nпосле удаления точки с индексом 0:");
        printFunction(listFunction);
    }

    private static void printFunction(TabulatedFunction func) {
        int count = func.getPointsCount();
        System.out.println("количество точек " + count);
        for (int i = 0; i < count; i++) {
            System.out.println("   x = " + func.getPointX(i) + " y = " + func.getPointY(i));
        }
    }
}
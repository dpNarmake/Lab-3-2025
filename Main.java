import functions.*;

public class Main {
    public static void main(String[] args) throws InappropriateFunctionPointException {
        System.out.println("тестирование ArrayTabulatedFunction");
        testArrayFunction();

        System.out.println("\nтестирование LinkedListTabulatedFunction");
        testLinkedListFunction();
    }

    private static void testArrayFunction() throws InappropriateFunctionPointException {
        TabulatedFunction arrayFunction = new ArrayTabulatedFunction(-1.0, 1.0, 5);

        System.out.println("начальные точки:");
        printFunction(arrayFunction);

        FunctionPoint newPoint = new FunctionPoint(0.57, 0.22);
        arrayFunction.setPoint(3, newPoint);

        System.out.println("после замены точки:");
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

        arrayFunction.deletePoint(3);

        System.out.println("\nпосле удаления точки:");
        printFunction(arrayFunction);
    }

    private static void testLinkedListFunction() throws InappropriateFunctionPointException {
        TabulatedFunction listFunction = new LinkedListTabulatedFunction(-1.0, 1.0, 5);

        System.out.println("начальные точки:");
        printFunction(listFunction);

        FunctionPoint newPoint = new FunctionPoint(0.57, 0.22);
        listFunction.setPoint(3, newPoint);

        System.out.println("после замены точки:");
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

        listFunction.deletePoint(3);

        System.out.println("\nпосле удаления точки:");
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
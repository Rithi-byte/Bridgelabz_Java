package javaExceptions.basics;

public class ExceptionPropagationDemo {

    // Method 1 throws ArithmeticException
    public static void method1() {

        // Division by zero generates an exception
        int result = 10 / 0;

        System.out.println(result);
    }

    // Method 2 calls method1
    public static void method2() {

        // Exception propagates from method1
        method1();
    }

    public static void main(String[] args) {

        try {

            // Call method2
            method2();

        } catch (ArithmeticException e) {

            // Handle propagated exception
            System.out.println(
                    "Handled exception in main"
            );
        }
    }
}


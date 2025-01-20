package fpt.kiemthuphanmen;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.List;


class CalculatorTest1Test {

    @Test
    void testMultiplication() {
        assertEquals(20, multiply(4, 5));
        assertEquals(0, multiply(0, 5));
        assertEquals(-15, multiply(-3, 5));
        assertEquals(15, multiply(-3, -5));
        assertEquals(0, multiply(0, 0));
        assertEquals(1, multiply(1, 1));
        assertEquals(-1, multiply(-1, 1));
        assertEquals(1000000, multiply(1000, 1000));
        assertEquals(-1000000, multiply(-1000, 1000));
        assertEquals(1000000, multiply(-1000, -1000));
    }




    @Test
    void testDivision() {
        assertEquals(2, divide(10, 5));
        assertEquals(0, divide(0, 5));
        assertEquals(-2, divide(-10, 5));
        assertEquals(2, divide(-10, -5));
        assertEquals(1, divide(5, 5));
        assertEquals(-1, divide(-5, 5));
        assertEquals(0, divide(0, 1));
        assertEquals(1000, divide(1000000, 1000));
        assertEquals(-1000, divide(-1000000, 1000));
        assertEquals(1000, divide(-1000000, -1000));
    }

    @Test
    void testAverage() {
        assertEquals(3.0, calculateAverage(List.of(1, 2, 3, 4, 5)));
        assertEquals(0.0, calculateAverage(List.of(0, 0, 0, 0, 0)));
        assertEquals(-3.0, calculateAverage(List.of(-1, -2, -3, -4, -5)));
    }


    @Test
    void testGetElementAtIndex() {
        int[] array = {1, 2, 3, 4, 5};
        assertEquals(1, getElementAtIndex(array, 0));
        assertEquals(5, getElementAtIndex(array, 4));
    }

    @Test
    void testIsInteger() {
        assertTrue(isInteger(5));
        assertTrue(isInteger(-5));
        assertFalse(isInteger(5.5));
        assertFalse(isInteger("abc"));
    }

    @Test
    void testFindMinElement() {
        int[] array = {3, 1, 4, 1, 5, 9};
        assertEquals(1, findMinElement(array));
    }

    @Test
    void testGetName() {
        UserProfile profile = new UserProfile("John Doe");
        assertEquals("John Doe", profile.getName());
    }


    int multiply(int a, int b) {
        return a * b;
    }

    boolean isInteger(Object obj) {
        return obj instanceof Integer;
    }


    @Test
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> divide(10, 0));
    }

    int divide(int a, int b) {
        return a / b;
    }

    @Test
    void testEmptyList() {
        assertThrows(ArithmeticException.class, () -> calculateAverage(List.of()));
    }

    double calculateAverage(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return numbers.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    @Test
    void testIndexOutOfRange() {
        int[] array = {1, 2, 3, 4, 5};
        assertThrows(IndexOutOfBoundsException.class, () -> getElementAtIndex(array, 5));
        assertThrows(IndexOutOfBoundsException.class, () -> getElementAtIndex(array, -1));
    }

    int getElementAtIndex(int[] array, int index) {
        return array[index];
    }

    @Test
    void testNullProfile() {
        UserProfile profile = null;
        assertThrows(NullPointerException.class, () -> getName(profile));
    }

    String getName(UserProfile profile) {
        return profile.getName();
    }

    class UserProfile {
        private String name;

        UserProfile(String name) {
            this.name = name;
        }

        String getName() {
            return name;
        }
    }
    @Test
    void testEmptyArray() {
        int[] array = {};
        assertThrows(IllegalArgumentException.class, () -> findMinElement(array));
    }

    int findMinElement(int[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        int min = array[0];
        for (int num : array) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
}

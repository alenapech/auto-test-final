package org.alenapech;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MathServiceTest {

    MathService mathService;

    //it's better to have new object before each test
    @BeforeEach
    void setUp() {
        mathService = new MathService();
    }

    @ParameterizedTest
    @CsvSource({"0, 46341, 0, 0, 0"
              , "1, 2, -3, 1, -3"
              , "1, 6, -16, 2, -8"
              , "2, -12, -3, 6.2404, -0.24037"
              , "4, 4, 1, -0.5, -0.5"})
    void getAnswerPositiveTest(int a
            , int b
            , int c
            , Double expectedResult1
            , Double expectedResult2) throws NotFoundAnswerException {
        Pair actualResult =  mathService.getAnswer(a, b, c);
        assertAll(() -> assertEquals(expectedResult1, actualResult.first, 0.0001)
                , () -> assertEquals(expectedResult2, actualResult.second, 0.0001));
    }

    private static Stream<Arguments> getAnswerNegativeTestArgs() {
        return Stream.of(
                Arguments.of(1, 2, 3, NotFoundAnswerException.class),
                Arguments.of(1, -2, 3, NotFoundAnswerException.class)
        );
    }

    @ParameterizedTest
    @MethodSource("getAnswerNegativeTestArgs")
    void getAnswerNegativeTest(int a, int b, int c, Class exception) throws NotFoundAnswerException {
        assertThrowsExactly(exception, () -> mathService.getAnswer(a, b, c));
    }

    @ParameterizedTest
    @CsvSource({"1, 2, 3, -8"
              , "1, -2, 3, -8"
              , "4, 4, 1, 0"
              , "0, 0, 0, 0"
              , "1, 46341, 1159, 2147483645"
        })
    void getDPositiveTest(int a, int b, int c, int expectedResult) {
        assertEquals(expectedResult, mathService.getD(a, b, c));
    }

    @Test
    void getDNegativeTest() {
        // the test should fail due to int overflow but wrong result is being shown (-2147479015)
        // so, the test is red
        assertThrows(Exception.class, () -> mathService.getD(0, 46341, 0));
    }
}
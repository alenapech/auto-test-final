package org.alenapech;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookingServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(BookingServiceTest.class);

    private BookingService service;

    @BeforeEach
    void setUp() throws CantBookException {
        logger.debug("Creating the Mock of BookingService...");
        service = mock(BookingService.class);
        when(service.book(any(), any(), any())).thenCallRealMethod();
    }

    @ParameterizedTest
    @CsvSource({"true, false, false"
              , "true, true, true"})
    void bookPositiveTest(boolean checkTimeInBDOutput
            , boolean createBookOutput
            , boolean expectedResult) throws CantBookException {
        logger.debug("bookPositiveTest with checkTimeInBDOutput = {}, createBookOutput = {} and expectedResult = {}"
                , checkTimeInBDOutput, createBookOutput, expectedResult);
        when(service.checkTimeInBD(any(), any())).thenReturn(checkTimeInBDOutput);
        when(service.createBook(any(), any(), any())).thenReturn(createBookOutput);
        assertEquals(expectedResult, service.book("", LocalDateTime.now(), LocalDateTime.now()));
    }

    @ParameterizedTest
    @CsvSource({"false, false"
              , "false, true"})
    void bookNegativeTest(boolean checkTimeInBDOutput, boolean createBookOutput) throws CantBookException {
        logger.debug("bookNegativeTest with checkTimeInBDOutput = {}, createBookOutput = {}"
                , checkTimeInBDOutput, createBookOutput);
        when(service.checkTimeInBD(any(), any())).thenReturn(checkTimeInBDOutput);
        when(service.createBook(any(), any(), any())).thenReturn(createBookOutput);
        assertThrowsExactly(CantBookException.class
                , () -> service.book("", LocalDateTime.now(), LocalDateTime.now()));
    }

}
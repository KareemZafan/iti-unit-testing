package org.iti.app_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ArrayListTests {

    /*@Mock
    ArrayList<String> mockedList;*/

    ArrayList<String> mockedList;

    @BeforeEach
    void setUp(){
        mockedList = mock(ArrayList.class);
    }

    @Test
    void testArrayListLength() {
        when(mockedList.size()).thenReturn(20).thenReturn(50);// Stups

        assertEquals(20, mockedList.size());
        assertEquals(50, mockedList.size());

        verify(mockedList, times(2)).size(); // Spy

    }

    @Test
    void getNamByID() {
        when(mockedList.get(10)).thenReturn("Ahmed");// Stups
        assertEquals("Ahmed", mockedList.get(10));
    }
}

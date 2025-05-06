package br.edu.fatec.sjc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class NumberAscOrderTest {

    private CustomStack<Integer> mockStack;

    @BeforeEach
    public void setUp() {
        mockStack = Mockito.mock(CustomStack.class);
    }

    @Test
    public void testSortWithSixElements() throws StackEmptyException {
        // Mock comportamento da pilha
        when(mockStack.isEmpty()).thenReturn(false, false, false, false, false, false, true);
        when(mockStack.pop())
                .thenReturn(45)
                .thenReturn(12)
                .thenReturn(27)
                .thenReturn(6)
                .thenReturn(59)
                .thenReturn(33);

        NumberAscOrder<Integer> sorter = new NumberAscOrder<>(mockStack);
        List<Integer> sorted = sorter.sort();

        assertEquals(List.of(6, 12, 27, 33, 45, 59), sorted);

        verify(mockStack, times(7)).isEmpty();
        verify(mockStack, times(6)).pop();
    }

    @Test
    public void testSortWithEmptyStack() throws StackEmptyException {
        when(mockStack.isEmpty()).thenReturn(true);

        NumberAscOrder<Integer> sorter = new NumberAscOrder<>(mockStack);
        List<Integer> sorted = sorter.sort();

        assertTrue(sorted.isEmpty());
        verify(mockStack, times(1)).isEmpty();
        verify(mockStack, never()).pop();
    }
}

package org.iti.app;

import java.util.ArrayList;
import java.util.List;

public class MyStack {

    private ArrayList<Integer> stackList;

    public MyStack() {
        stackList = new ArrayList<>();
    }

    public void push(int i) {
        stackList.add(i);
    }

    public int getSize() {
        return stackList.size();
    }

    public int getPeek() {
        if (stackList.isEmpty()) throw new IllegalStateException("Stack is empty!");
        return stackList.get(getSize() - 1);
    }

    public boolean isEmpty() {
        return stackList.isEmpty();
    }

    public List<Integer> getCurrentStack() {
        return stackList;
    }

    public int pop() {
        if (!stackList.isEmpty()) {
            int itemToRemove = getPeek();
            stackList.remove(getSize() - 1);
            return itemToRemove;
        } else throw new IllegalStateException("Stack is empty!");
    }
}

package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Stack P = new Stack();
        for(int i=0; i<=10; i=i+2) {
            P.push(i+1);
        }
        P.push(P.peek());
        P.push(P.pop());
        while(!P.isEmpty()) {
            System.out.print(P.pop() + ", ");

        }
    }
}
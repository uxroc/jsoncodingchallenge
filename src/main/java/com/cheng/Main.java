package com.cheng;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder strb = new StringBuilder();
        while(scan.hasNext()) {
            strb.append(scan.next());
        }
        System.out.println(Flattener.flat(strb.toString()));
    }
}

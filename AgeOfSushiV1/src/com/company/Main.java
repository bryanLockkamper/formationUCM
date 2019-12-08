package com.company;

import com.company.models.Case;
import com.company.models.Map;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Map map = new Map("Test");

        System.out.println("|---------------------|");
        for (List<Case> cases : map.getMap()) {
            System.out.print("| ");
            for (Case cas : cases) {
                System.out.print(cas.getContent() + " ");
            }
            System.out.println("|");
        }
        System.out.println("|---------------------|");
    }
}

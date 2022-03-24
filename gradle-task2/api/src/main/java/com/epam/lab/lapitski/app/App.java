package com.epam.lab.lapitski.app;

import com.epam.lab.lapitski.exception.NumberException;
import com.epam.lab.lapitski.util.Utils;

public class App {

    public static void main(String[] args) {
        try {
            System.out.println(Utils.isAllPositiveNumbers("12", "79"));
        } catch (NumberException e) {
            System.out.println(e.getMessage());
        }
    }
}

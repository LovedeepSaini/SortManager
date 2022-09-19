package com.sparta.Lovedeep.Model;

public class EmptyArrayException extends Throwable {
    public EmptyArrayException(String s) {
    }

    public static  class EmptyException extends Exception {
        public EmptyException(String errorMessage) {
            super(errorMessage);
        }
    }
}

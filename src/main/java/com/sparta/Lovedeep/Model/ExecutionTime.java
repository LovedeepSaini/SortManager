package com.sparta.Lovedeep.Model;

public class ExecutionTime {

        private long start;

        public void start() {
            start = System.nanoTime();
        }

        public float end() {
            return (System.nanoTime() - start) / 1000000f;
        }
}

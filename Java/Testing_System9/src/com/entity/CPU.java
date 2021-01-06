package com.entity;

public class CPU {
    private double price;
    private Processor processor;
    private Ram ram;

    public CPU() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public Ram getRam() {
        return ram;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public class Processor {
        private float coreAmount;
        private String menufacturer;
        public float getCache(){
            return (float) 4.3;
        }

        public Processor() {

        }
    }
    public class Ram {
        private float memory;
        private String menufacturer;
        public float getClockSpeed(){
            return 5.5F;
        }

    }
}

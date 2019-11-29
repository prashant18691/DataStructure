package com.test.prs.designpattern.builder;

public class Computer {
    private int ram;
    private int hdd;
    private int ssd;
    private int graphics;

    private Computer(ComputerBuilder builder){
        this.ram = builder.ram;
        this.hdd = builder.hdd;
        this.ssd = builder.ssd;
        this.graphics = builder.graphics;
    }

    static class ComputerBuilder{

        private int ram;
        private int hdd;
        private int ssd;
        private int graphics;

        private ComputerBuilder(){
        }

        public static ComputerBuilder create(){
            return new ComputerBuilder();
        }

        public ComputerBuilder setRam(int ram) {
            this.ram = ram;
            return this;
        }

        public ComputerBuilder setHdd(int hdd) {
            this.hdd = hdd;
            return this;
        }

        public ComputerBuilder setSsd(int ssd) {
            this.ssd = ssd;
            return this;
        }

        public ComputerBuilder setGraphics(int graphics) {
            this.graphics = graphics;
            return this;
        }

        public Computer build(){
            return new Computer(this);
        }

        @Override
        public String toString() {
            return "ComputerBuilder{" +
                    "hdd=" + hdd +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Computer{" +
                "ram=" + ram +
                ", hdd=" + hdd +
                ", ssd=" + ssd +
                ", graphics=" + graphics +
                '}';
    }
}

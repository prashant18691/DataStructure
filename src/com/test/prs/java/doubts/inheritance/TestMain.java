package com.test.prs.java.doubts.inheritance;

abstract class File{
    void toFile(){

    }

    public static void main(String[] args) {
        File f = new a();
        f.toFile();
    }
}

class a extends File{
    @Override
    void toFile() {
        System.out.println("sss");
    }
}
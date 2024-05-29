package be.pxl.ja.talker;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            //when runable you need to put it in thread
            //if you extend thread you can just start it
            Talker talker = new Talker(i);
            Thread myThread = new Thread(talker);
            myThread.start();
        }
    }
}

package cbo.onborading.utility;

public class RandomNumber {
    public static int getRandom(){
        int min = 500000;
        int max = 1000000;
        int random_int = (int)(Math.random() * (max - min + 1) + min);
        return random_int;
    }
}

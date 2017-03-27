package Qual;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Salar
 */
public class CountingSheep {
    private ArrayList<Integer> digits = new ArrayList<>(10);
    
    public void parseDigits(long n){
        if (n <= 0) {
            return;
        } else {
            addDigits(n%10);
            parseDigits(n/10);
        }
    }
    public void addDigits(long n){
        if (!this.digits.contains((int)n)) {
            this.digits.add((int)n);
        }
    }
    public void resetCountedDigits(){
        this.digits.clear();
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        CountingSheep cs = new CountingSheep();
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();
        for (int i = 1; i <= testCases; i++) {
            long n = input.nextInt();
            long lastNumber = 0;
            if (n != 0) {
                for (int j = 1; cs.digits.size() < 10; j++) {
                    lastNumber = j * n;
                    cs.parseDigits(lastNumber);
                }
                System.out.println("Case #"+i+": "+lastNumber);
                cs.resetCountedDigits();
            } else {
                System.out.println("Case #"+i+": "+"INSOMNIA");
            }
        }
        
    }
    
}


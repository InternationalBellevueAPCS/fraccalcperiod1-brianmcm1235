import java.util.*;
public class FracCalc {
    /**
     * Prompts user for input, passes that input to produceAnswer, then outputs the result.
     * @param args - unused
     */
    public static void main(String[] args) 
    {
    	Scanner c= new Scanner(System.in);
    	String equ="";
    	equ=c.nextLine();
    	while (!equ.equals("quit")) {
        	System.out.println(produceAnswer(equ));
        	System.out.println("would you like to continue? if no type quit");
        	equ=c.nextLine();
    	}
        // TODO: Read the input from the user and call produceAnswer with an equation
        // Checkpoint 1: Create a Scanner, read one line of input, pass that input to produceAnswer, print the result.
        // Checkpoint 2: Accept user input multiple times.
    }
    
    /**
     * produceAnswer - This function takes a String 'input' and produces the result.
     * @param input - A fraction string that needs to be evaluated.  For your program, this will be the user input.
     *      Example: input ==> "1/2 + 3/4"
     * @return the result of the fraction after it has been calculated.
     *      Example: return ==> "1_1/4"
     */
    public static String produceAnswer(String equ)
    { 
    	String snum="0";
    	String sdem="1";
    	String swhole="0";
    	String[] thing=equ.split(" ");
    	String[] split=thing[0].split("_");
    	if (split.length==2) {
    		swhole=split[0];
    		String[] fraction=split[1].split("/");
    		snum=fraction[0];
    		sdem=fraction[1];
    	}
    	else if(split[0].contains("/")){
        	String[] fraction=split[0].split("/");
        	swhole="0";
        	snum=fraction[0];
        	sdem=fraction[1];

        	}
    	else {
    		swhole=split[0];
    		snum="0";
    		sdem="1";

    	}
    	String snum2="0";
    	String sdem2="1";
    	String swhole2="0";
    	String[] split2=thing[2].split("_");
    	if (split2.length==2) {
    		swhole2=split2[0];
    		String[] fraction2=split2[1].split("/");
    		snum2=fraction2[0];
    		sdem2=fraction2[1];
    	}
    	else if(split2[0].contains("/")){
        	String[] fraction2=split2[0].split("/");
        	swhole2="0";
        	snum2=fraction2[0];
        	sdem2=fraction2[1];
        	}
    	else {
    		swhole2=split2[0];
    		snum2="0";
    		sdem2="1";
    	}
    	int num = Integer.parseInt(snum);
    	int dem = Integer.parseInt(sdem);
    	int whole = Integer.parseInt(swhole);
    	int num2 = Integer.parseInt(snum2);
    	int dem2 = Integer.parseInt(sdem2);
    	int whole2 = Integer.parseInt(swhole2);
    	int demf=1;
    	int numf=0;
    	num+=dem*whole;
    	whole=0;
    	num2+=dem2*whole2;
    	whole2=0;
    	if (thing[1].equals("+")) {
    		numf=num*dem2+num2*dem;
    		demf=dem*dem2;
    		}
    	else if(thing[1].equals("-")) {
    		numf=num*dem2-num2*dem;
    		demf=dem*dem2;
    	}
    	else if (thing[1].equals("*")) {
    		numf=num*num2;
    		demf=dem*dem2;
    	}
    	else if (thing[1].equals("/") && num2!=0) {
    		numf=num*dem2;
    		demf=num2*dem;
    	}
    	if (demf<0) {
    		numf*=-1;
    		demf*=-1;
    	}
    	int f=GCD(numf,demf);
    	numf/=f;
    	demf/=f;
    	while(numf>=demf && demf!=1) {
			numf-=demf;
			whole+=1;
		}
    	while(numf*-1>demf && demf!=1) {
			numf+=demf;
			whole-=1;
		}
    	if (whole==0 && demf==1) return ""+numf;
    	if (numf<0) numf*=-1; 
    	if (numf==0) return ""+whole;
    	else if (whole==0) return ""+numf+"/"+demf;
    	return whole+"_"+numf+"/"+demf;
        // TODO: Implement this function to produce the solution to the input
        // Checkpoint 1: Return the second operand.  Example "4/5 * 1_2/4" returns "1_2/4".
        // Checkpoint 2: Return the second operand as a string representing each part.
        //               Example "4/5 * 1_2/4" returns "whole:1 numerator:2 denominator:4".
        // Checkpoint 3: Evaluate the formula and return the result as a fraction.
        //               Example "4/5 * 1_2/4" returns "6/5".
        //               Note: Answer does not need to be reduced, but it must be correct.
        // Final project: All answers must be reduced.
        //               Example "4/5 * 1_2/4" returns "1_1/5".
        

    }

    // TODO: Fill in the space below with helper methods
    
    /**
     * greatestCommonDivisor - Find the largest integer that evenly divides two integers.
     *      Use this helper method in the Final Checkpoint to reduce fractions.
     *      Note: There is a different (recursive) implementation in BJP Chapter 12.
     * @param a - First integer.
     * @param b - Second integer.
     * @return The GCD.
     */
    public static int GCD(int a, int b)
    {
        a = Math.abs(a);
        b = Math.abs(b);
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        while (min != 0) {
            int tmp = min;
            min = max % min;
            max = tmp;
        }
        return max;
    }
    
    /**
     * leastCommonMultiple - Find the smallest integer that can be evenly divided by two integers.
     *      Use this helper method in Checkpoint 3 to evaluate expressions.
     * @param a - First integer.
     * @param b - Second integer.
     * @return The LCM.
     */
    public static int LCM(int a, int b)
    {
        int gcd = GCD(a, b);
        if (gcd!=0) {
        return (a*b)/gcd;
    	}
    	else return 0;
    }
}

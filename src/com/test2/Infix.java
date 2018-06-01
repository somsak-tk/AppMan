package com.test2;

import java.util.*;


public class Infix {
	
    public static void main(String[] args){
        System.out.print("input : "); 
        
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("\r");
		
		while ( sc.hasNext() )
		{
			String line = sc.next();
			evaluateInfix( line );
			System.out.println(" Result: "+evaluateInfix( line ));
			System.out.println("input : ");
		}
		
    }
    
    public static double evaluateInfix(String infix)
    {
    	double result = 0;
        try
        {
            Stack<String> valueStack = new Stack<String> ();
            Stack<Character> operatorStack = new Stack<Character> ();
            String oldVal = "";
            for(char ch: infix.toCharArray())
            {
            	if ( ch == ' ') { // skip blank value
            		continue;
            	}
            	int val = Character.getNumericValue(ch);
                if (val >= 0 && val <= 9) {
                	if ( oldVal == "" ) {
                		oldVal = oldVal + ch;
                		valueStack.push(oldVal);
                		continue;
                	} else {
                		oldVal = valueStack.pop() + ch;
                		valueStack.push(oldVal);
                		continue;
                	}
                } else if (ch == '(') {
                	oldVal = "";
                    operatorStack.push(ch);
                } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' ) {
                	oldVal = "";
                    if (operatorStack.isEmpty()) {
                        operatorStack.push(ch);
                    } else if (precedence(ch) > precedence(operatorStack.peek())) {
                        operatorStack.push(ch);
                    } else {
                        while(!operatorStack.isEmpty() && precedence(ch) <= precedence(operatorStack.peek())){
                            result = compute( Double.valueOf(valueStack.pop()), Double.valueOf(valueStack.pop()), operatorStack.pop());
                            valueStack.push(String.valueOf(result));
                        }
                        operatorStack.push(ch);
                    }
                } else if(ch == ')'){
                	oldVal = "";
                    while(operatorStack.peek() != '('){
                        result = compute( Double.valueOf(valueStack.pop()), Double.valueOf(valueStack.pop()), operatorStack.pop());
                        valueStack.push(String.valueOf(result));
                    }
                    operatorStack.pop();
                }
            }

            while(!operatorStack.isEmpty()){
                result = compute(Double.valueOf(valueStack.pop()), Double.valueOf(valueStack.pop()), operatorStack.pop());
                valueStack.push(String.valueOf(result));
            }
            result = Double.valueOf(valueStack.peek());

        } catch (EmptyStackException e) {
           e.printStackTrace();           
        } catch (ArithmeticException e) {
           e.printStackTrace();           
        }
        
        return result;
    } 

    private static int precedence(char operator)
    {
        switch(operator){
            case '(': case ')': return 0;
            case '*': case '/': return 1;
            case '+': case '-': return 2;
        }
        return -1;
    }
    
    private static Double compute(Double operandOne, Double operandTwo, char operator)
    {
        if(operator == '+') {
            return operandOne + operandTwo;
        } else if(operator == '-') {
            return operandTwo - operandOne;  // WARNING
        } else if(operator == '*') {
            return operandOne * operandTwo;
        } else if(operator == '/') {
            return operandTwo / operandOne;  // WARNING    
        } else {
            return null;
        }
    }
    
} 
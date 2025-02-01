/* CS2401: Lab 10
 *
 * Class PlayWithStacks:
 * In this file, you are given a BONUS activity: the implementation of 
 * a method that uses Stacks as defined in StackL.java.
 * This method, called evaluatePostFix, takes a String str as parameter
 * which represents a post-fix arithmetic expression and returns the numeric 
 * value of this expression
 */

/******************************************************************************
 * 
 * Regarding PlayWithStacks, here is what you have to do:
 * If you are completing this BONUS activity, you have to implement:
 * 	- A method, called evaluatePostFix, takes a String str as parameter
 * 		which represents a post-fix arithmetic expression and returns the numeric 
 * 		value of this expression
 *  - Tests (2) for your method evaluatePostFix inside the main method 
 * 
 ******************************************************************************/

public class PlayWithStacks {

	/* Method: evaluatePostFix -- BONUS
	 * Takes a String str as parameter, which represents a post-fix arithmetic 
	 * expression and returns the numeric value of this expression
	 * Examples: 
	 * 	- String "3 4 +" represents the (infix) expression 3+4 
	 * 		and should be evaluated as 7
	 *  - String "16 5 - 3 +" represents the (infix) expression 16-5+3
	 *  	and should be evaluated as 14
	 */
	public static int evaluatePostFix(String postfixExpression) {
		/* First, you create a stack that will allow you to parse your string
		 * You will store operands in the stack
		 *
		 * Then you need to separate the information in the expression so you can
		 * parse them one by one
		 * Example:
		 * 	- "3 4 +" will be split as {"3", "4", "+"}
		 *  - "16 5 - 3 +" will be split as {"16", "5", "-", "3", "+"}
		 */ 

		/* If what you read in the array is an operator,
			* you need to pop two operands from the stack and apply the operator
			* on these operands.
			* Once you have applied the operator on the two operands, you have a new
			* value, and you push this value back onto the stack
		*/
				
		/* Note:
			* If the stack does not contain two elements, then it means that the
			* expression you are trying to evaluate is not valid. So you have to
			* print out: "Expression is not a valid post-fix arithmetic expression"
			* and return -1
			*/

	
		/* If what you read in the array is an operand,
			* you need to push it onto the stack
			*/
			
		
		/* Once you are done parsing the array, your stack should contain only one
		 * value: the result
		 * If the stack contains no value or more than one value, you should
		 * print out: "Expression is not a valid post-fix arithmetic expression" 
		 * and return -1
		 * If the stack contains only one value, you should return it as the value of 
		 * the post-fix expression
		 */

		// Complete code here

		//initialize new stack
		Stack<Object> stackCalculator = new Stack<>();
		//store each character on an array
		String[] characters = postfixExpression.split(" ");
		//for loop to process each character

		for(String character: characters){
			if(isOperator(character)){
				//to make an operation a minimum of 2 values are needed
				if(stackCalculator.getSize() < 2){
					System.out.println("Invalid expression");
					return -1;
				}
				//call the method to perform the operation
				else operation(stackCalculator, character);
			}
			else if(isOperand(character)){
				//if the character is a number store it in the stack
				stackCalculator.push(character);
			}
			else{
				System.out.println("Invalid expression");
				return -1;
			}
		}
		//if the stack ended with more than one value
		if(stackCalculator.getSize() > 1){
			System.err.println("Invalid expression");
			return -1;
		}
		//return the result
		return  Integer.parseInt((String)stackCalculator.pop());
	}

	public static void operation(Stack<Object> s, String character) {
		//pop the two numbers to perform the operation
		int numberOne = Integer.parseInt((String)s.pop());
		int numberTwo = Integer.parseInt((String)s.pop());

		//if statements to decide which operation to perform

		if(character.equals("+")){
			int sum = numberOne + numberTwo;
			s.push(Integer.toString(sum));
		}
		else if(character.equals("-")){
			int substraction = numberTwo - numberOne;
			s.push(Integer.toString(substraction));
		}
		else if(character.equals("/")){
			int division = numberTwo / numberOne;
			s.push(Integer.toString(division));
		}
		else if(character.equals("*")){
			int multiplication = numberOne * numberTwo;
			s.push(Integer.toString(multiplication));
		}
	}
	
	/* Method: isOperator -- BONUS
	 * Takes a String str as parameter, and checks to see if it an operator (+,-,/,*) 
	 * returns true if it is an operator and false otherwise
	 */
	public static boolean isOperator(String str) {
		//String is not null and one of the operators is on the string
		if(str == null) return false;
		return "+-/*".contains(str);
	}
	
	/* Method: isOperand -- BONUS
	 * Takes a String str as parameter and checks to see if it is an operand (0-9)
	 * returns true if it is an operand and false otherwise
	 * You can use the .isDigit() method
	 */
	public static boolean isOperand(String str) {
		//try to convert from string to number
		try{
			Integer.parseInt(str);
			return true;
		}
		//on error return false
		catch(NumberFormatException e){
			return false;
		}
	}
	
	public static void main(String[] args) {
		//Create a stack and perform the operations created in the Stacks.java class
		//2 Tests for your method evaluatePostFix for bonus
		Stack<Integer> myStack = new Stack<Integer>();
		myStack.push(5);
		myStack.push(10);
		System.out.println("Pop: " + myStack.pop());
		myStack.push(25);
		System.out.println("Peek: " + myStack.peek());
		myStack.clear();
		System.out.println("Is the stack empty? " + myStack.isEmpty());
		System.out.println("Postfix evaluation: "+evaluatePostFix("16 5 - 3 +"));
	}
}

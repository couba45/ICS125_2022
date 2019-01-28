package calculator125;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Coder
 *
 * This is the Controller component of the application.
 * The Controller component responsibility is to coordinate
 * the interactions between the View and Model components.
 **/

public class CalculatorController {
	
	private final CalculatorView theView;
	private final CalculatorModel theModel;
	
	public CalculatorController(CalculatorView theView
                                 , CalculatorModel theModel) {
		this.theView = theView;
		this.theModel = theModel;
		
		// Configure the View component so that when 
                // its Calculate button is clicked, then it must
                // execute the actionPerformed method in the 
                // CalculateListener class.
		
		this.theView.addCalculateListener(new CalculateListener());
	}
	
	class CalculateListener implements ActionListener {

                @Override
		public void actionPerformed(ActionEvent e) {
			
                    int firstNumber = 0;
                    int secondNumber = 0;
			
                    // Surround interactions with the view with
                    // a try-catch block to handle user entry errors like
                    // the numbers were not properly entered.
			
                    try {
			
                        firstNumber = theView.getFirstNumber();
                        secondNumber = theView.getFirstNumber();
				
                        theModel.addTwoNumbers(firstNumber, firstNumber);
			
                        theView.setCalcSolution(theModel.getCalculationValue());			
                    }
                    catch (NumberFormatException ex) {
			// Provide an error message to the console output.	
                        System.out.println(ex);				
                        theView.displayErrorMessage(
                            "Error: The numbers entered must be integers.");				
                    }
                    catch (Exception ex) {
                        System.out.println(ex);				
                        theView.displayErrorMessage(
                            "Error: Generic error " + ex.getMessage());				                       
                    }
		}		
	}	
} // end CalculatorController
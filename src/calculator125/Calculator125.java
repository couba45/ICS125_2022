package calculator125; 

/**
 *
 * @author Coder
 */
public class Calculator125 {

    public static void main(String[] args) {
        CalculatorView theView = new CalculatorView();        
    	CalculatorModel theModel = new CalculatorModel();       
        CalculatorController theController = 
                new CalculatorController(theView,theModel);        
        theView.setVisible(true);
    }
    
} // end Calculator125

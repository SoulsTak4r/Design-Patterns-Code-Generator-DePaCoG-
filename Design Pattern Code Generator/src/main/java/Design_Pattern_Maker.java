import com.intellij.openapi.actionSystem.AnActionEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    Following things are happening in this class
    -   Making instance of Pattern Factory Abstract class based on design pattern
    -   getting the input data from DePaCoG class
    -   calling the method generatePattern and design_pattern, and sending the key of design pattern with AnActionEvent based on desired pattern
    -    using switch cases for the menu, Default case will be error message

 */


public class Design_Pattern_Maker {

    //Declaring variables to be used in this project
    Logger logger = LoggerFactory.getLogger(Design_Pattern_Maker.class);



    private Design_Patterns patterns = null;


    /*
        This method generates the design pattern
        using logging to trace and get the info about classes
        using switch cases to match the input for the design pattern
     */

    //--------------------------------------------------------------------------------------------------

    public void GenerateDesignPatterns(int key, AnActionEvent e)
    {
        logger.trace("In {} class", Design_Pattern_Maker.class.getName());

        //using switch cases
        switch (key)
        {
            case 1: // Abstract factory
                logger.info("User selected *Abstract Factory* Design Patter"); //logger
                patterns = Pattern_Factory.design_patterns(Configs.AbstractFactory); // Instance
                if(patterns != null)
                {
                    patterns.generatePattern(e); // calling method and sending the AnActionEvent
                }
                else
                {
                    System.out.println("***Abstract Factory Design Pattern cannot be created");
                }
                break;
            case 2: // builder
                logger.info("User selected *Builder* Design Patter");
                patterns = Pattern_Factory.design_patterns(Configs.Builder);
                if(patterns != null)
                {
                    patterns.generatePattern(e); // calling method and sending the AnActionEvent
                }
                else
                {
                    System.out.println("***Builder Design Pattern cannot be created");
                }
                break;
            case 3: // Factory Method
                logger.info("User selected *Factory Method* Design Patter");
                patterns = Pattern_Factory.design_patterns(Configs.FactoryMethod);
                if(patterns != null)
                {
                    patterns.generatePattern(e); // calling method and sending the AnActionEvent
                }
                else
                {
                    System.out.println("***Factory Method Design Pattern cannot be created");
                }
                break;
            case 4: // Facade
                logger.info("User selected *Facade* Design Patter");
                patterns = Pattern_Factory.design_patterns(Configs.Facade);
                if(patterns != null)
                {
                    patterns.generatePattern(e); // calling method and sending the AnActionEvent
                }
                else
                {
                    System.out.println("***Facade Design Pattern cannot be created");
                }
                break;
            case 5: // Template Method
                logger.info("User selected *Template Method* Design Patter");

                patterns = Pattern_Factory.design_patterns(Configs.Template);
                if(patterns != null)
                {
                    patterns.generatePattern(e); // calling method and sending the AnActionEvent
                }
                else
                {
                    System.out.println("***Template Method Design Pattern cannot be created");
                }
                break;
            case 6: // Visitor
                logger.info("User selected *Visitor* Design Patter");
                patterns = Pattern_Factory.design_patterns(Configs.Visitor);
                if(patterns != null)
                {
                    patterns.generatePattern(e); // calling method and sending the AnActionEvent
                }
                else
                {
                    System.out.println("***Visitor Pattern cannot be created");
                }
                break;
            case 7: // Chain of Responsibility
                logger.info("User selected *Chain of Responsibility* Design Patter");
                patterns = Pattern_Factory.design_patterns(Configs.Chain);
                if(patterns != null)
                {
                    patterns.generatePattern(e); // calling method and sending the AnActionEvent
                }
                else
                {
                    System.out.println("***Chain of Responsibility Design Pattern cannot be created");
                }
                break;
            case 8: // Mediator
                logger.info("User selected *Mediator* Design Patter");
                patterns = Pattern_Factory.design_patterns(Configs.Mediator);
                if(patterns != null)
                {
                    patterns.generatePattern(e); // calling method and sending the AnActionEvent
                }
                else
                {
                    System.out.println("***Mediator Design Pattern cannot be created");
                }
                break;
            default: // if user input is incorrect
                logger.error("Giving Error, User selected {}", key);
                System.out.println("***Error, please select the correct option");

                // =============================================================================================================


        }
    }


}

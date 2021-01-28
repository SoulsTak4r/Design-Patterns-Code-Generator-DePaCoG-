import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    This class behaves like Factory Method Design Patter

    Following things are happening in this class
    -   getting the string key from Design Pattern Maker class
    -   using if else to match the key and returning the object of Design Pattern accordingly
    -   Giving error message if does not match



 */


public abstract class Pattern_Factory {

    static Logger logger = LoggerFactory.getLogger(Pattern_Factory.class);

      /*

        this is the  that gets the key from Design pattern maker
        match the key from config key
        return objects of design pattern

     */

    public static Design_Patterns design_patterns(String key)
    {
        logger.trace("In *design pattern* method of Configs Class "); // logger

        Design_Patterns patterns = null; // Declaring variable

        if(key.equals(Configs.AbstractFactory)) //match abstract factory
        {

            patterns = new Abstract_Factory_Pattern(); // return abstract factory
        }
        else if(key.equals(Configs.Chain)) // match chain
        {

            patterns = new Chain_Of_Responsibility_Pattern(); //return chain
        }
        else if(key.equals(Configs.Facade)) // match facade
        {

            patterns = new Facade_Pattern(); // return facade
        }
        else if(key.equals(Configs.FactoryMethod)) // match factory method
        {

            patterns = new Factory_Method_Pattern(); // return factory method
        }
        else if(key.equals(Configs.Builder))// match builder
        {

            patterns = new Builder_Pattern(); // return builder
        }
        else if(key.equals(Configs.Visitor)) // match visitor
        {

            patterns = new Visitor_Pattern(); // return visitor
        }
        else if(key.equals(Configs.Mediator)) // match mediator
        {

            patterns = new Mediator_Pattern(); // return mediator
        }
        else if(key.equals(Configs.Template)) // match template
        {
            patterns = new Template_Method_Pattern(); // return template
        }
        else
        {
            //error message
            logger.error("Giving Error, User selected {}", key);
            System.out.println("Design Pattern Not Found. Try Again");
        }

        return patterns;
    }

}

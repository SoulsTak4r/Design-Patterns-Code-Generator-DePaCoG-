import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.ui.Messages;

import java.io.File;
import java.net.URISyntaxException;

import com.intellij.openapi.vfs.VirtualFile;
import com.squareup.javapoet.*;

import javax.lang.model.element.Modifier;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*

    Following Things are happening in this DePaCoG Main class
    -   Calling getData method from Configs class to receive all the required data
    -   prompting and checking the user input for selecting the design pattern
    -   The input data will be string, so will be converting into integer
    -   Giving Error messages if something goes wrong
    -   Calling GenerateDesignPatterns from Design Pattern maker class and sending the input to it with AnActionEvent

 */



public class DePaCoG extends AnAction {

    @Override
    public void actionPerformed( AnActionEvent e) {
        Configs.getData(e); // calling getdata and sending AnActionEvent
        Design_Pattern_Maker make = new Design_Pattern_Maker(); // making Instance of Design Pattern maker
        Logger logger = LoggerFactory.getLogger(DePaCoG.class); // logger


        // while loop to check the correct input
        while (Configs.checkForMain)
        {
            // getting input from user
            String input =  Messages.showInputDialog(e.getProject(), "1 - Abstract Factory\n2 - Builder\n3 - Factory Method\n4 - Facade\n5 - Template Method\n6 - Visitor" +
                    "\n7 - Chain of Responsibility\n8 - Mediator\n Please Select the Design Pattern", "Design Patterns", Messages.getInformationIcon());

            Configs.checkInput = Configs.checkNum(input); //sending the input to checkNum method to check if its legal

            if(Configs.checkInput)
            {
                // parse into Integer
                Configs.input = Integer.parseInt(input);
                // Flag to check the range
                if(Configs.input > 0 && Configs.input < 9)
                {
                    // breaking loop
                    Configs.checkForMain = false;
                }
                else
                {
                    // error message
                    Messages.showMessageDialog(e.getProject(), "Wrong Input, Please Enter Between 1 and 8", "Design Patterns", Messages.getInformationIcon());
                }
            }
            else
            {
                // error message
                Messages.showMessageDialog(e.getProject(), "Wrong Input, Please Enter Between 1 and 8", "Design Patterns", Messages.getInformationIcon());
            }

        }

        logger.info("User Selected {}", Configs.input); //logger
        make.GenerateDesignPatterns(Configs.input, e); // Calling method and sending the input with AnActionEvent



    }
}

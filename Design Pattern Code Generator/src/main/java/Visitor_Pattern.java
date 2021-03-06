import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.squareup.javapoet.*;

import javax.lang.model.element.Modifier;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.WeakHashMap;

/*

    -  Following things are happening in this class
    -   Client, Visitor interface, Element interface, 2 Elements that implements Element interface
    -   Getting the path of opened IDE path from Configs class
    -   Saving the generated files into path
    -   Mandatory logging


*/

public class Visitor_Pattern extends Design_Patterns {
    @Override
    public void Generate_Design_Patterns(AnActionEvent e) {

        Logger logger = LoggerFactory.getLogger(Factory_Method_Pattern.class);
        logger.trace("In *Visitor* Class");
        logger.info("Prompting the required classes name for *Visitor Pattern*");

        //=============================================================================================
        //===================================================================================================
        //------------------------------------------ Client Class -----------------------------------------------

        boolean check = false;
        boolean key;
        boolean checkNameClash;

        while (!check)
        {
            String client_name = Messages.showInputDialog(e.getProject(), "Please enter the name of *Client Class*", "Design Patterns", Messages.getInformationIcon());

            key = Configs.checkKeys(client_name);
            checkNameClash = Configs.isNameClashVisitor(client_name, e);

            if(key) {
                if(checkNameClash) {
                    logger.trace("Name Key is legal in *Visitor* Class");
                    TypeSpec userClient = TypeSpec.classBuilder(client_name)
                            .addModifiers(Modifier.PUBLIC)
                            .build();

                    JavaFile javaFileClient = JavaFile.builder("com.mvpjava.javapoet.VisitorPattern", userClient)
                            .addFileComment("AUTO_GENERATED BY JavaPoet")
                            .build();

                    try {
                        javaFileClient.writeTo(Paths.get(Configs.getPath()));
                    } catch (IOException ex) {
                        logger.error("Exception could Occurred");
                        System.out.println("An exception has occurred in Visitor Design Pattern  " + ex.getMessage());
                    }
                    check = true;
                }
                else
                {
                    Messages.showErrorDialog(e.getProject(), client_name + " is already exist in the project.. Please enter a different name", "Design Patterns");
                }
            }
            else
            {
                logger.error("User entered an invalid name");
                Messages.showErrorDialog(e.getProject(), "***Error. Please Enter the Valid name", "Design Patterns");
            }

        }
        //=============================================================================================
        //===================================================================================================
        //------------------------------------------ Visitor Interface -----------------------------------------------

        boolean check4 = false;
        boolean key4;
        boolean checkNameClash1;

        TypeSpec userVisitor = null;

        while (!check4)
        {
            String visitor_name = Messages.showInputDialog(e.getProject(), "Please enter the name of *Visitor Interface*", "Design Patterns", Messages.getInformationIcon());

            key4 = Configs.checkKeys(visitor_name);
            checkNameClash1 = Configs.isNameClashVisitor(visitor_name, e);

            if(key4) {
                if(checkNameClash1) {
                    logger.trace("Name Key is legal in *Visitor* Class");
                    userVisitor = TypeSpec.interfaceBuilder(visitor_name)
                            .addModifiers(Modifier.PUBLIC)
                            .build();

                    JavaFile javaFileVisitor = JavaFile.builder("com.mvpjava.javapoet.VisitorPattern", userVisitor)
                            .addFileComment("AUTO_GENERATED BY JavaPoet")
                            .build();

                    try {
                        javaFileVisitor.writeTo(Paths.get(Configs.getPath()));
                    } catch (IOException ex) {
                        logger.error("Exception could Occurred");
                        System.out.println("An exception has occurred in Visitor Design Pattern  " + ex.getMessage());
                    }
                    check4 = true;
                }
                else
                {
                    Messages.showErrorDialog(e.getProject(), visitor_name + " is already exist in the project.. Please enter a different name", "Design Patterns");
                }

            }
            else
            {
                logger.error("User entered an invalid name");
                Messages.showErrorDialog(e.getProject(), "***Error. Please Enter the Valid name", "Design Patterns");
            }
        }

        //=============================================================================================
        //===================================================================================================
        //------------------------------------------ Element Interface -----------------------------------------------

        boolean check1 = false;
        boolean key1;
        boolean checkNameClash2;

        TypeSpec userElement = null;

        while (!check1)
        {
            String element_name = Messages.showInputDialog(e.getProject(), "Please enter the name of *Element Interface*", "Design Patterns", Messages.getInformationIcon());

            key1 = Configs.checkKeys(element_name);
            checkNameClash2 = Configs.isNameClashVisitor(element_name, e);

            if(key1) {
                if(checkNameClash2) {
                    logger.trace("Name Key is legal in *Visitor* Class");

                    MethodSpec accept = MethodSpec.methodBuilder("accept")
                            .addParameter(ClassName.get("com.mvpjava.javapoet.VisitorPattern", userVisitor.name), "visitor")
                            .addModifiers(Modifier.PUBLIC)
                            .addModifiers(Modifier.ABSTRACT)
                            .build();

                    userElement = TypeSpec.interfaceBuilder(element_name)
                            .addModifiers(Modifier.PUBLIC)
                            .addMethod(accept)
                            .build();

                    JavaFile javaFileElement = JavaFile.builder("com.mvpjava.javapoet.VisitorPattern", userElement)
                            .addFileComment("AUTO_GENERATED BY JavaPoet")
                            .build();

                    try {
                        javaFileElement.writeTo(Paths.get(Configs.getPath()));
                    } catch (IOException ex) {
                        logger.error("Exception could Occurred");
                        System.out.println("An exception has occurred in Visitor Design Pattern  " + ex.getMessage());
                    }
                    check1 = true;
                }else {
                    Messages.showErrorDialog(e.getProject(), element_name + " is already exist in the project.. Please enter a different name", "Design Patterns");
                }
            }
            else
            {
                logger.error("User entered an invalid name");
                Messages.showErrorDialog(e.getProject(), "***Error. Please Enter the Valid name", "Design Patterns");
            }

        }
        //=============================================================================================
        //===================================================================================================
        //------------------------------------------ Element classes -----------------------------------------------

        boolean check2 = false;
        boolean key2;
        boolean checkNameClash3;

        ClassName className = ClassName.get("com.mvpjava.javapoet.VisitorPattern", userElement.name);

        while (!check2)
        {
            String elementA_name =  Messages.showInputDialog(e.getProject(), "Please enter the name of *Element A* that implements " + userElement.name, "Design Patterns", Messages.getInformationIcon());

            key2 = Configs.checkKeys(elementA_name);
            checkNameClash3 = Configs.isNameClashVisitor(elementA_name, e);

            if (key2) {
                if(checkNameClash3) {
                    logger.trace("Name Key is legal in *Visitor* Class");

                    MethodSpec accept = MethodSpec.methodBuilder("accept")
                            .addParameter(ClassName.get("com.mvpjava.javapoet.VisitorPattern", userVisitor.name), "visitor")
                            .addModifiers(Modifier.PUBLIC)

                            .build();

                    TypeSpec userElementA = TypeSpec.classBuilder(elementA_name)
                            .addModifiers(Modifier.PUBLIC)
                            .addMethod(accept)
                            .addSuperinterface(className)
                            .build();

                    JavaFile javaFileElementA = JavaFile.builder("com.mvpjava.javapoet.VisitorPattern", userElementA)
                            .addFileComment("AUTO_GENERATED BY JavaPoet")
                            .build();

                    try {
                        javaFileElementA.writeTo(Paths.get(Configs.getPath()));
                    } catch (IOException ex) {
                        logger.error("Exception could Occurred");
                        System.out.println("An exception has occurred in Visitor Design Pattern  " + ex.getMessage());
                    }
                    check2 = true;
                }
                else
                {
                    Messages.showErrorDialog(e.getProject(), elementA_name + " is already exist in the project.. Please enter a different name", "Design Patterns");
                }
            }
            else
            {
                logger.error("User entered an invalid name");
                Messages.showErrorDialog(e.getProject(), "***Error. Please Enter the Valid name", "Design Patterns");
            }

        }

        //=============================================================================================
        boolean check3 = false;
        boolean key3;
        boolean checkNameClash4;

        while (!check3)
        {
            String elementB_name =  Messages.showInputDialog(e.getProject(), "Please enter the name of *Element B* that implements " + userElement.name, "Design Patterns", Messages.getInformationIcon());

            key3 = Configs.checkKeys(elementB_name);
            checkNameClash4 = Configs.isNameClashVisitor(elementB_name, e);

            if (key3) {
                if(checkNameClash4) {
                    logger.trace("Name Key is legal in *Visitor* Class");

                    MethodSpec accept = MethodSpec.methodBuilder("accept")
                            .addParameter(ClassName.get("com.mvpjava.javapoet.VisitorPattern", userVisitor.name), "visitor")
                            .addModifiers(Modifier.PUBLIC)

                            .build();

                    TypeSpec userElementB = TypeSpec.classBuilder(elementB_name)
                            .addModifiers(Modifier.PUBLIC)
                            .addMethod(accept)
                            .addSuperinterface(className)
                            .build();

                    JavaFile javaFileElementB = JavaFile.builder("com.mvpjava.javapoet.VisitorPattern", userElementB)
                            .addFileComment("AUTO_GENERATED BY JavaPoet")
                            .build();

                    try {
                        javaFileElementB.writeTo(Paths.get(Configs.getPath()));
                    } catch (IOException ex) {
                        logger.error("Exception could Occurred");
                        System.out.println("An exception has occurred in Visitor Design Pattern  " + ex.getMessage());
                    }
                    check3 = true;
                }
                else
                {
                    Messages.showErrorDialog(e.getProject(), elementB_name + " is already exist in the project.. Please enter a different name", "Design Patterns");
                }
            }
            else
            {
                logger.error("User entered an invalid name");
                Messages.showErrorDialog(e.getProject(), "***Error. Please Enter the Valid name", "Design Patterns");
            }

        }

        //=============================================================================================
        //===================================================================================================
        //------------------------------------------ Visitor class -----------------------------------------------

        boolean check5 = false;
        boolean key5;
        boolean checkNameClash5;

        ClassName className2 = ClassName.get("com.mvpjava.javapoet.VisitorPattern", userVisitor.name);

        while (!check5)
        {
            String visitor1_name = Messages.showInputDialog(e.getProject(), "Please enter the name of *Visitor* that implements " + userVisitor.name, "Design Patterns", Messages.getInformationIcon());

            key5 = Configs.checkKeys(visitor1_name);
            checkNameClash5 = Configs.isNameClashVisitor(visitor1_name, e);

            if(key5) {
                if(checkNameClash5) {
                    logger.trace("Name Key is legal in *Visitor* Class");

                    TypeSpec userVisitor1 = TypeSpec.classBuilder(visitor1_name)
                            .addModifiers(Modifier.PUBLIC)
                            .addSuperinterface(className2)
                            .build();

                    JavaFile javaFileVisitor1 = JavaFile.builder("com.mvpjava.javapoet.VisitorPattern", userVisitor1)
                            .addFileComment("AUTO_GENERATED BY JavaPoet")
                            .build();

                    try {
                        javaFileVisitor1.writeTo(Paths.get(Configs.getPath()));
                    } catch (IOException ex) {
                        logger.error("Exception could Occurred");
                        System.out.println("An exception has occurred in Visitor Design Pattern  " + ex.getMessage());
                    }
                    check5 = true;
                }
                else
                {
                    Messages.showErrorDialog(e.getProject(), visitor1_name + " is already exist in the project.. Please enter a different name", "Design Patterns");
                }
            }
            else
            {
                logger.error("User entered an invalid name");
                Messages.showErrorDialog(e.getProject(), "***Error. Please Enter the Valid name", "Design Patterns");
            }

        }
        LocalFileSystem.getInstance().refresh(false);
        VirtualFile virtualFile = e.getProject().getWorkspaceFile();
        virtualFile.refresh(false,true);
    }
}

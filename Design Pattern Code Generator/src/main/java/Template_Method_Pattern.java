import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.squareup.javapoet.*;

import javax.lang.model.element.Modifier;
import java.io.IOException;
import java.nio.file.Paths;

/*
    -  Following things are happening in this class
    -   1 Abstract class, and products
    -   Getting the path of opened IDE path from Configs class
    -   Saving the generated files into path
    -   Mandatory logging

*/

public class Template_Method_Pattern extends Design_Patterns {
    @Override
    public void Generate_Design_Patterns(AnActionEvent e) {

        Logger logger = LoggerFactory.getLogger(Template_Method_Pattern.class);
        logger.trace("In *Template Method* Class");
        logger.info("Prompting the required classes name for *Template Method Pattern*");

        //===========================================================================================================
        //===========================================================================================================
        //--------------------------------- Abstract Class ----------------------------------------------------------

        boolean check = false;
        boolean key;
        boolean checkNameClash;
        TypeSpec userAbstract = null;

        while (!check)
        {
            String input = Messages.showInputDialog(e.getProject(), "Please enter the name of *Abstract* class", "Design Patterns", Messages.getInformationIcon());

            key = Configs.checkKeys(input);
            checkNameClash = Configs.isNameClashTemplate(input, e);

            if(key) {

                if (checkNameClash) {
                    logger.trace("Name Key is legal in *Template Method * Class");

                    MethodSpec templateMethod = MethodSpec.methodBuilder("templateMethod")
                            .addModifiers(Modifier.PUBLIC)
                            .addModifiers(Modifier.FINAL)
                            .build();

                    userAbstract = TypeSpec.classBuilder(input)
                            .addModifiers(Modifier.ABSTRACT)
                            .addModifiers(Modifier.PUBLIC)
                            .addMethod(templateMethod)
                            .build();

                    JavaFile javaFileAbstract = JavaFile.builder("com.mvpjava.javapoet.TemplatePattern", userAbstract)
                            .addFileComment("AUTO_GENERATED BY JavaPoet")
                            .build();

                    try {
                        javaFileAbstract.writeTo(Paths.get(Configs.getPath()));
                    } catch (IOException ex) {
                        logger.error("Exception could Occurred");
                        System.out.println("An exception has occurred in Template Design Pattern  " + ex.getMessage());
                    }
                    check = true;
                }
                else {
                    logger.error("User entered an already existing name");
                    Messages.showErrorDialog(e.getProject(), input + " is already exist in the project.. Please enter a different name", "Design Patterns");
                }
            }
            else
            {
                logger.error("User entered an invalid name");
                Messages.showErrorDialog(e.getProject(), "***Error. Please Enter the Valid name", "Design Patterns");

            }
        }

        //===========================================================================================================
        //===========================================================================================================
        //--------------------------------- Concrete Classes ----------------------------------------------------------
        ClassName className = ClassName.get("com.mvpjava.javapoet.TemplatePattern", userAbstract.name);

        boolean check1 = false;
        boolean key1;
        boolean checkNameClash1;
        while (!check1)
        {
            String name1 = Messages.showInputDialog(e.getProject(), "Please enter the name of *Sub Class 1* that extends " + userAbstract.name, "Design Patterns", Messages.getInformationIcon());
            key1 = Configs.checkKeys(name1);
            checkNameClash1 = Configs.isNameClashTemplate(name1, e);

            if(key1) {

                if (checkNameClash1) {

                    logger.trace("Name Key is legal in *Template Method * Class");
                    TypeSpec userSubClass1 = TypeSpec.classBuilder(name1)
                            .addModifiers(Modifier.PUBLIC)
                            .superclass(className)
                            .build();

                    JavaFile javaFileSubClass1 = JavaFile.builder("com.mvpjava.javapoet.TemplatePattern", userSubClass1)
                            .addFileComment("AUTO_GENERATED BY JavaPoet")
                            .build();

                    try {
                        javaFileSubClass1.writeTo(Paths.get(Configs.getPath()));
                    } catch (IOException ex) {
                        logger.error("Exception could Occurred");
                        System.out.println("An exception has occurred in Template Design Pattern  " + ex.getMessage());
                    }
                    check1 = true;
                }else
                {
                    logger.error("User entered an already existing name");
                    Messages.showErrorDialog(e.getProject(), name1 + " is already exist in the project.. Please enter a different name", "Design Patterns");
                }
            }
            else
            {
                logger.error("User entered an invalid name");
                Messages.showErrorDialog(e.getProject(), "***Error. Please Enter the Valid name", "Design Patterns");
            }
        }
        //==================================================================================================================
        boolean check2 = false;
        boolean key2;
        boolean checkNameClash2;

        while (!check2)
        {
            String name2 = Messages.showInputDialog(e.getProject(), "Please enter the name of *Sub Class 2* that extends " + userAbstract.name, "Design Patterns", Messages.getInformationIcon());
            key2 = Configs.checkKeys(name2);
            checkNameClash2 = Configs.isNameClashTemplate(name2, e);

            if(key2) {

                if(checkNameClash2) {

                    logger.trace("Name Key is legal in *Template Method * Class");
                    TypeSpec userSubClass2 = TypeSpec.classBuilder(name2)
                            .addModifiers(Modifier.PUBLIC)
                            .superclass(className)
                            .build();

                    JavaFile javaFileSubClass2 = JavaFile.builder("com.mvpjava.javapoet.TemplatePattern", userSubClass2)
                            .addFileComment("AUTO_GENERATED BY JavaPoet")
                            .build();

                    try {
                        javaFileSubClass2.writeTo(Paths.get(Configs.getPath()));
                    } catch (IOException ex) {
                        logger.error("Exception could Occurred");
                        System.out.println("An exception has occurred in Template Design Pattern  " + ex.getMessage());
                    }
                    check2 = true;
                }
                else
                {
                    logger.error("User entered an already existing name");
                    Messages.showErrorDialog(e.getProject(), name2 + " is already exist in the project.. Please enter a different name", "Design Patterns");
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

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FilenameIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.util.indexing.FileBasedIndex;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.squareup.javapoet.TypeSpec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.lang.model.SourceVersion;
import java.io.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

public class Configs {
    static Logger logger = LoggerFactory.getLogger(Configs.class);


    public static String AbstractFactory = null;
    public static String Builder = null;
    public static String Chain = null;
    public static String Facade = null;
    public static String FactoryMethod = null;
    public static String Mediator = null;
    public static String Template= null;
    public static String Visitor = null;

    //===========================================
    static Config config = null;
    public static boolean checkForMain;
    public static boolean checkInput;
    public static int input = 0;

    //==========================================
    public static String path = null;

    public static  VirtualFile ab;

    public static void getData(AnActionEvent event)
    {
        VirtualFile virtualFile = ModuleRootManager.getInstance(ModuleManager.getInstance(Objects.requireNonNull(event.getProject())).getModules()[0]).getSourceRoots()[0];
        ab = ModuleRootManager.getInstance(ModuleManager.getInstance(Objects.requireNonNull(event.getProject())).getModules()[0]).getSourceRoots()[0].getChildren()[0].getChildren()[0].getChildren()[0].getChildren()[5];


        //PsiFile[] file = FilenameIndex.getFilesByName(event.getProject(), "ClassDemo.java", GlobalSearchScope.projectScope(event.getProject()));


        path = virtualFile.getPath();

        String p = ab.getPath();
        System.out.println(p);


        try {
            InputStream inputStream = DePaCoG.class.getResourceAsStream("myapp.conf");
            if(inputStream != null)
            {
                Reader reader = new InputStreamReader(inputStream);
                config = ConfigFactory.parseReader(reader);

                checkForMain = config.getBoolean("checkForMain");
                checkInput = config.getBoolean("checkInput");
                AbstractFactory = config.getString("AbstractFactory");
                Builder = config.getString("Builder");
                Chain = config.getString("Chain");
                FactoryMethod = config.getString("FactoryMethod");
                Template = config.getString("Template");
                Mediator = config.getString("Mediator");
                Visitor = config.getString("Visitor");
                Facade = config.getString("Facade");

                inputStream.close();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public static boolean isNameClash(String name, AnActionEvent event)
    {
        LocalFileSystem.getInstance().refresh(false);
        VirtualFile virtualFile = event.getProject().getWorkspaceFile();
        virtualFile.refresh(false,true);

        boolean flag = true;
        PsiFile[] file;
        file = FilenameIndex.getFilesByName(event.getProject(), name + ".java", GlobalSearchScope.projectScope(event.getProject()));

        for(PsiFile ff : file) {

          //  if (f.toString().equals("PsiJavaFile:" + name + ".java")) {
            if(ff.toString().equals("PsiJavaFile:"+name + ".java"))
            {
                flag = false;
                break;
            } else {
                flag = true;
            }
        }
        return flag;

    }


    public static String getPath()
    {
        return path;
    }

    public static boolean checkNum(String s)
    {
        return s.matches("^[0-9]+$");
    }

    public static boolean checkInterfaceName(String name, TypeSpec A, TypeSpec B)
    {
        logger.trace("In checkInterface method of Configs Class ");


        if((name.equals(A.name)) || (name.equals(B.name)))
        {
            return true;
        }
        else
        {
            logger.error("User entered an invalid name");
            return false;
        }
    }


//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------




    //******************************************************************************************************************
    //==================================================================================================================
    //                                            Name Clash Analyzer Methods
    //==================================================================================================================
    //******************************************************************************************************************



    // for illegal class names
    public static boolean checkKeys (String name)
    {
        logger.trace("In checkKeys method of Configs Class ");

        // return boolean
        return SourceVersion.isIdentifier(name) && !SourceVersion.isKeyword(name);
    }

    // for abstract factory
    public static boolean isNameClashAbFactory(String input, AnActionEvent event)
    {
        LocalFileSystem.getInstance().refresh(false);
        VirtualFile vFile = event.getProject().getWorkspaceFile();
        vFile.refresh(false,true);

        boolean flag = true;
        VirtualFile virtualFile = ModuleRootManager.getInstance(ModuleManager.getInstance(Objects.requireNonNull(event.getProject())).getModules()[0]).getSourceRoots()[0].getChildren()[0].getChildren()[0].getChildren()[0].getChildren()[4];
        String path1 = virtualFile.getPath();
        System.out.println(path);

        File file = new File(path1 + "/" + input + ".java");
        if(file.exists())
        {
            return false;
        }
        else
        {
            return true;
        }

    }

    // for Template
    public static boolean isNameClashTemplate(String input, AnActionEvent event)
    {
        LocalFileSystem.getInstance().refresh(false);
        VirtualFile vFile = event.getProject().getWorkspaceFile();
        vFile.refresh(false,true);

        VirtualFile virtualFile = ModuleRootManager.getInstance(ModuleManager.getInstance(Objects.requireNonNull(event.getProject())).getModules()[0]).getSourceRoots()[0].getChildren()[0].getChildren()[0].getChildren()[0].getChildren()[6];
        String path1 = virtualFile.getPath();

        File file = new File(path1 + "/" + input + ".java");
        if(file.exists())
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    // for builder
    public static boolean isNameClashBuilder(String input, AnActionEvent event)
    {
        LocalFileSystem.getInstance().refresh(false);
        VirtualFile vFile = event.getProject().getWorkspaceFile();
        vFile.refresh(false,true);
        VirtualFile virtualFile = ModuleRootManager.getInstance(ModuleManager.getInstance(Objects.requireNonNull(event.getProject())).getModules()[0]).getSourceRoots()[0].getChildren()[0].getChildren()[0].getChildren()[0].getChildren()[2];
        String path1 = virtualFile.getPath();

        File file = new File(path1 + "/" + input + ".java");

        if(file.exists())
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    // for chain
    public static boolean isNameClashChain(String input, AnActionEvent event)
    {
        LocalFileSystem.getInstance().refresh(false);
        VirtualFile vFile = event.getProject().getWorkspaceFile();
        vFile.refresh(false,true);


        VirtualFile virtualFile = ModuleRootManager.getInstance(ModuleManager.getInstance(Objects.requireNonNull(event.getProject())).getModules()[0]).getSourceRoots()[0].getChildren()[0].getChildren()[0].getChildren()[0].getChildren()[7];
        String path1 = virtualFile.getPath();
        System.out.println(path);
        File file = new File(path1 + "/" + input + ".java");
        if(file.exists())
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    // for facade
    public static boolean isNameClashFacade(String input, AnActionEvent event)
    {
        LocalFileSystem.getInstance().refresh(false);
        VirtualFile vFile = event.getProject().getWorkspaceFile();
        vFile.refresh(false,true);


        VirtualFile virtualFile = ModuleRootManager.getInstance(ModuleManager.getInstance(Objects.requireNonNull(event.getProject())).getModules()[0]).getSourceRoots()[0].getChildren()[0].getChildren()[0].getChildren()[0].getChildren()[0];
        String path1 = virtualFile.getPath();
        File file = new File(path1 + "/" + input + ".java");
        if(file.exists())
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    // for factory method
    public static boolean isNameClashFactory(String input, AnActionEvent event)
    {
        LocalFileSystem.getInstance().refresh(false);
        VirtualFile vFile = event.getProject().getWorkspaceFile();
        vFile.refresh(false,true);

        boolean flag = true;
        VirtualFile virtualFile = ModuleRootManager.getInstance(ModuleManager.getInstance(Objects.requireNonNull(event.getProject())).getModules()[0]).getSourceRoots()[0].getChildren()[0].getChildren()[0].getChildren()[0].getChildren()[1];
        String path1 = virtualFile.getPath();
        System.out.println(path);
        File file = new File(path1 + "/" + input + ".java");
        if(file.exists())
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    // for visitor
    public static boolean isNameClashVisitor(String input, AnActionEvent event)
    {
        LocalFileSystem.getInstance().refresh(false);
        VirtualFile vFile = event.getProject().getWorkspaceFile();
        vFile.refresh(false,true);

        boolean flag = true;
        VirtualFile virtualFile = ModuleRootManager.getInstance(ModuleManager.getInstance(Objects.requireNonNull(event.getProject())).getModules()[0]).getSourceRoots()[0].getChildren()[0].getChildren()[0].getChildren()[0].getChildren()[3];
        String path1 = virtualFile.getPath();
        System.out.println(path);
        File file = new File(path1 + "/" + input + ".java");
        if(file.exists())
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    // for mediator
    public static boolean isNameClashMediator(String input, AnActionEvent event)
    {
        LocalFileSystem.getInstance().refresh(false);
        VirtualFile vFile = event.getProject().getWorkspaceFile();
        vFile.refresh(false,true);

        boolean flag = true;
        VirtualFile virtualFile = ModuleRootManager.getInstance(ModuleManager.getInstance(Objects.requireNonNull(event.getProject())).getModules()[0]).getSourceRoots()[0].getChildren()[0].getChildren()[0].getChildren()[0].getChildren()[5];
        String path1 = virtualFile.getPath();
        System.out.println(path);
        File file = new File(path1 + "/" + input + ".java");
        if(file.exists())
        {
            return false;
        }
        else
        {
            return true;
        }
    }




    //******************************************************************************************************************
    //==================================================================================================================
    //                                            End Name Clash Analyzer Methods
    //==================================================================================================================
    //******************************************************************************************************************

}

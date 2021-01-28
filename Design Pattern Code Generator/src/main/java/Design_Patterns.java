import com.intellij.openapi.actionSystem.AnActionEvent;

/*
    This class Behaves like a Template Method Pattern. It does the following things
    -   send the AnActionEvent in generate design Pattern method, so that all the pattern class can access the AnActionEvent


 */


public abstract class Design_Patterns {
    public abstract void Generate_Design_Patterns(AnActionEvent e);

    public final void generatePattern(AnActionEvent e)
    {
        Generate_Design_Patterns(e); // Sending AnAction Event
    }
}

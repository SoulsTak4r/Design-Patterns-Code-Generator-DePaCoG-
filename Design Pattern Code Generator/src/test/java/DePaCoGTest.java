import com.intellij.openapi.actionSystem.AnActionEvent;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DePaCoGTest {
    Abstract_Factory_Pattern abstract_factory_pattern = null;
    Builder_Pattern builder_pattern = null;
    Chain_Of_Responsibility_Pattern chain_of_responsibility_pattern = null;
    Factory_Method_Pattern factory_method_pattern = null;
    Facade_Pattern facade_pattern = null;
    Template_Method_Pattern template_method_pattern = null;
    Visitor_Pattern visitor_pattern = null;
    Mediator_Pattern mediator_pattern = null;


    boolean check;
    boolean check1;
    boolean check2;
    boolean check3;



    @Before
    public void init() {

        abstract_factory_pattern = new Abstract_Factory_Pattern();
        builder_pattern = new Builder_Pattern();
        chain_of_responsibility_pattern = new Chain_Of_Responsibility_Pattern();
        factory_method_pattern = new Factory_Method_Pattern();
        facade_pattern = new Facade_Pattern();
        template_method_pattern = new Template_Method_Pattern();
        visitor_pattern = new Visitor_Pattern();
        mediator_pattern = new Mediator_Pattern();


    }

    @Test
    public void test() {
        check = Configs.checkNum("1");

        assertTrue(check);
    }

    @Test
    public void test1() {
        check1 = Configs.checkKeys("abstract");

        assertFalse(check1);
    }

    @Test
    public void test2() {
        check2 = Configs.checkKeys("Class1");

        assertTrue(check2);
    }


    @Test
    public void test3() {
        check3 = Configs.checkNum("0");

        assertTrue(check3);
    }

    @Test
    public void test4()
    {
        String input = "5";
        Configs.checkInput = Configs.checkNum(input);
        assertTrue(Configs.checkInput);
    }

    @Test
    public void test5()
    {

        assertEquals(abstract_factory_pattern.getClass().getName(), "Abstract_Factory_Pattern");

    }

    @Test
    public void test6()
    {

        assertEquals(builder_pattern.getClass().getName(), "Builder_Pattern");

    }

    @Test
    public void test7()
    {

        assertEquals(chain_of_responsibility_pattern.getClass().getName(), "Chain_Of_Responsibility_Pattern");

    }

    @Test
    public void test8()
    {

        String input = "11";
        Configs.checkInput = Configs.checkNum(input);

        assertTrue(Configs.checkInput);

    }


    @Test
    public void test9()
    {

        check1 = Configs.checkKeys("g h");

        assertFalse(check1);

    }


    @Test
    public void test10()
    {
        boolean check = Configs.checkKeys("abstract");
        assertFalse(check);
    }


    @Test
    public void test11()
    {
        boolean check = Configs.checkKeys("enum");
        assertFalse(check);
    }

    @Test
    public void test12()
    {
        boolean check = Configs.checkKeys("Abstract");
        assertTrue(check);
    }

    @Test
    public void test13()
    {
        boolean check = Configs.checkKeys("interface");
        assertFalse(check);
    }

    @Test
    public void test14()
    {
        boolean check = Configs.checkKeys("int");
        assertFalse(check);
    }

    @Test
    public void test15()
    {
        boolean check = Configs.checkKeys("String");
        assertTrue(check);
    }
}

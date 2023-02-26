package test.Practica3.Test; 

import Practica3.pr2.Graph;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/** 
* Test Tester. 
* 
* @author <Authors name> 
* @since <pre>feb 26, 2023</pre> 
* @version 1.0 
*/ 
public class TestTest {
    @Test
    public void onePathFindsAPath() {
        System.out.println("\nTest onePathFindsAPath");
        System.out.println("-------------------------------------- ");
        Graph<Integer> g = new Graph<>();
        g.addEdge(1, 2);
        g.addEdge(3, 4);
        g.addEdge(1, 5);
        g.addEdge(5, 6);
        g.addEdge(6, 4);

        List<Integer> expectedPath = new ArrayList<>(); expectedPath.add(1);
        expectedPath.add(5);
        expectedPath.add(6);
        expectedPath.add(4);
        assertEquals(expectedPath, g.onePath(1, 4));
    }


} 

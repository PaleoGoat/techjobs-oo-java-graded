package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobID(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        // test  int, String, Employer, Location, PositionType, and CoreCompetency
        // test for both the CLASS *and* VALUE  ---  should have 5 assert statements of each type
        Job job2 = new Job();
        assertEquals(job1.getId(), job2.getId()-1); //id assertEquals
        assertTrue(((Integer) job1.getId()) instanceof Integer); //id assertTrue id is an int
        assertEquals(job1.getName(), "Product tester"); //name assertEquals the argument "Product tester"
        assertTrue(job1.getName() instanceof String); //name assertTrue name is a String
        assertEquals(job1.getEmployer().getValue(),"ACME");//employer assertEquals the argument
        assertTrue((job1.getEmployer() instanceof Employer)); //employer assertTrue is Employer class
        assertEquals(job1.getLocation().getValue(), "Desert");//location assertEquals
        assertTrue(job1.getLocation() instanceof Location); //location assertTrue
        assertEquals(job1.getPositionType().getValue(), "Quality control"); //positionType assertEquals
        assertTrue(job1.getPositionType() instanceof PositionType); //positionType assertTrue
        assertEquals(job1.getCoreCompetency().getValue(), "Persistence"); //coreCompetency assertEquals
        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency); //coreCompetency assertTrue
    }

    @Test
    public void testJobsForEquality(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertFalse(job1.equals(job2));
    }

    @Test
    public void  testToStringStartsAndEndsWithNewLine(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(job1.toString().charAt(0), "\n"); //Why not working . . . I'm running out of hair to pull out
        assertEquals(job1.toString().charAt(job1.toString().length()-1), "\n"); //Why not working . . .
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        //Employer testEmployer = job1.getEmployer();
        //Location testLocation = job1.getLocation();
        //PositionType testPosition = job1.getPositionType();
        //CoreCompetency testCC = job1.getCoreCompetency();
        //These work (but they don't test the toString() methids - which is the whole point . . . !!!!!!!!!!!!!!---------!!!!!!!!!!!!!!---------!!!!!!!!!!!!!!---------!!!!!!!!!!!!!!---------!!!!!!!!!!!!!!---------!!!!!!!!!!!!!!
        //assertEquals(testEmployer.getValue(), "ACME");
        //assertEquals(testLocation.getValue(), "Desert");
        //assertEquals(testPosition.getValue(), "Quality control");
        //assertEquals(testCC.getValue(), "Persistence");

        //This doesn't work  - it's the job1.toString component which is causing the error. . . *pulls out last hair on head*
        assertEquals(job1.toString(), "\nID: " + job1.getId() + "\nName: " + "Product tester" + "\nEmployer: " + "ACME" + "\nLocation: " + "Desert" + "\nPosition Type: " + "Quality control" + "\nCore Competency: " + "Persistence" + "\n");
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job job1 = new Job();
        //redo to test each individually
        assertEquals(job1.toString(), "OOPS! This job does not seem to exist.");
//        assertEquals(job1.toString(), "\nID: " + job1.getId() + "\nName: " + "Data not available" + "\nEmployer: " + "Data not available" + "\nLocation: " + "Data not available" + "\nPosition Type: " + "Data not available" + "\nCore Competency: " + "Data not available" + "\n");
//    }

}

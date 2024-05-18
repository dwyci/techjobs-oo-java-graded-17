package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {

        Job job1 = new Job();
        Job job2 = new Job();

        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(job1.getName() instanceof String);
        assertTrue(job1.getEmployer() instanceof Employer);
        assertTrue(job1.getLocation() instanceof Location);
        assertTrue(job1.getPositionType() instanceof PositionType);
        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", job1.getName());
        assertEquals("ACME", job1.getEmployer());
        assertEquals("Desert", job1.getLocation());
        assertEquals("Quality control", job1.getPositionType());
        assertEquals("Persistence", job1.getCoreCompetency());
    }

    @Test
    public void testJobsForEquality() {

        Job job1 = new Job();
        Job job2 = new Job();

        assertFalse(job1.getId() == job2.getId());

    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Dessert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String jobString = job.toString();

        //checking to see if first character of the jobString is a line separator
        assertEquals(System.lineSeparator(), jobString.substring(0, 1));
        assertEquals(System.lineSeparator(), jobString.substring(jobString.length()));


    }

    @Test
    public void testToStringContainsLabelsAndData() {
        Job job = new Job("", new Employer(""), new Location(""),
                new PositionType(""), new CoreCompetency(""));

        String expectedOutput = System.lineSeparator() +
                "ID:  " + job.getId() + System.lineSeparator() +
                "Name:  Data not available" + System.lineSeparator() +
                "Employer:  Data not available" + System.lineSeparator() +
                "Location:  Data not available" + System.lineSeparator() +
                "Position Type:  Data not available" + System.lineSeparator() +
                "Core Competency:  Data not available";

    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Dessert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }
}

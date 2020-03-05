package com.exadel.automation.assertion;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.exadel.automation.BaseTest;
import com.exadel.automation.stubs.tolkien.TolkienCharacter;
import com.exadel.automation.stubs.tolkien.TolkienCharacter.Race;
import com.exadel.automation.stubs.tolkien.TolkienFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertEqualsNoOrder;
import static org.testng.AssertJUnit.assertNotSame;

//import static org.testng.AssertJUnit.*;  //???

public class AsrtTestngNative extends BaseTest {

    private List<String> characterNames = TolkienFactory.getHeros().stream().map(c -> c.getName()).collect(Collectors.toList());

    private TolkienCharacter frodo = new TolkienCharacter("Frodo", 38, Race.HOBBIT);

    private double pi = 3.14159265359;

    @Test
    public void testEqualsLists() {
        assertEquals(characterNames, Arrays.asList("Boromir", "Frodo", "Sam", "Gandalf", "Legolas"));
    }

    @Test
    public void testEqualsArrays() {
        String[] expectedArray = {"Boromir", "Frodo", "Sam", "Gandalf", "Legolas"};
        assertEqualsNoOrder(characterNames.toArray(), expectedArray); //Ordered comparison
    }

    @Test
    public void testEqualsStrings() {
        assertEquals(frodo.getName(), "Frodo");
    }

    @Test
    public void testEqualsFloat() {
        assertEquals(pi, 3.1415926526, 0.000000001);
    }

    @Test
    public void testEqualsObjects() {
        assertNotSame(frodo, new TolkienCharacter("Frodo", 38, Race.HOBBIT));
    }

    @Test
    public void testSoftAssert() {

        TolkienCharacter botomir = new TolkienCharacter("Boromir", 37, Race.MAN);
        String[] expectedNames = {"Boromir", "Frodo", "Sam", "Legolas", "Gandalf"};

        SoftAssert softAssertion = new SoftAssert();
        softAssertion.assertNotNull(characterNames);
        softAssertion.assertEquals(characterNames.get(0), botomir.name);
        softAssertion.assertEqualsNoOrder(characterNames.toArray(), expectedNames);
        softAssertion.assertAll();
    }
}

package com.exadel.automation.assertion;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.hamcrest.Matchers;
import org.testng.annotations.*;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import com.exadel.automation.BaseTest;
import com.exadel.automation.stubs.tolkien.TolkienCharacter;
import com.exadel.automation.stubs.tolkien.TolkienFactory;

import com.exadel.automation.stubs.tolkien.TolkienCharacter.Race;
import org.testng.asserts.SoftAssert;

public class AsrtHamcrest extends BaseTest {
	
	private List<String> characterNames = TolkienFactory.getHeros().stream()
											.map(c->c.getName())
											.collect(Collectors.toList());
	private TolkienCharacter frodo = new TolkienCharacter("Frodo", 38, Race.HOBBIT);
	
	private double pi = 3.14159265359;
	
    @Test
    public void testEqualsLists() {
    	assertThat(characterNames, containsInAnyOrder("Boromir", "Frodo", "Sam", "Legolas", "Gandalf"));
    	assertThat(characterNames, not(hasSize(6)));
    }

    @Test
    public void testEqualsArrays() {
    	String[] expectedArray = {"Boromir", "Frodo", "Sam", "Legolas","Gandalf"};
    	
    	assertThat(characterNames.toArray(new String[0]), anyOf(
    			arrayContaining(expectedArray),
    			arrayContainingInAnyOrder(expectedArray),
    			hasItemInArray("Sauron")
    	));
     }    
  
    @Test
    public void testEqualsStrings() {
    	assertThat(frodo.getName(), allOf(
    			equalTo("Frodo"),
    			startsWith("F"),
    			not(equalToIgnoringCase("sauron"))
    	));
    	
    }

    @Test
    public void testEqualsFloat() {
    	assertThat(pi, allOf(
    			greaterThan(3.1),
    			lessThan(3.2)
    		));
    }
    
    @Test
    public void testEqualsObjects() {
    	assertThat(frodo, 
    			samePropertyValuesAs(new TolkienCharacter("Frodo", 38, Race.HOBBIT))
    		);
    }
    

}

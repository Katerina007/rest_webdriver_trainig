package com.exadel.automation.assertion;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import com.exadel.automation.BaseTest;
import com.exadel.automation.stubs.tolkien.TolkienCharacter;
import com.exadel.automation.stubs.tolkien.TolkienCharacter.Race;
import com.exadel.automation.stubs.tolkien.TolkienFactory;
import org.assertj.core.api.Condition;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.contentOf;
import static org.assertj.core.api.Assertions.not;
import static org.assertj.core.api.Assertions.offset;
import static org.assertj.core.api.Assertions.tuple;

public class AsrtAssertJ extends BaseTest {

    private List<String> characterNames = TolkienFactory.getHeros().stream().map(c -> c.getName()).collect(Collectors.toList());
    private TolkienCharacter frodo = new TolkienCharacter("Frodo", 38, Race.HOBBIT);

    private double pi = 3.14159265359;

    @Test
    public void testEqualsLists() {
        assertThat(characterNames).containsExactly("Boromir", "Frodo", "Sam", "Gandalf", "Legolas")
                                  .containsExactlyInAnyOrder("Frodo", "Sam", "Boromir", "Legolas", "Gandalf")
                                  .doesNotContain("Harry")
                                  .startsWith("Boromir")
                                  .endsWith("Legolas")
                                  .hasSize(5);
    }

    @Test
    public void testEqualsArrays() {
        String[] expectedArray = {"Boromir", "Frodo", "Sam", "Gandalf", "Legolas"};

        assertThat(characterNames.toArray(new String[0]))
                .containsExactly(expectedArray)
                .containsExactlyInAnyOrder("Frodo", "Sam", "Boromir", "Legolas", "Gandalf")
                .containsSequence("Sam", "Gandalf")
                .areAtLeast(1, new Condition<>(s -> s.startsWith("Le"), "check starting on G"));
    }

    @Test
    public void testEqualsStrings() {
        assertThat(frodo.getName()).isNot(new Condition<>(s -> s.equals("Lego"), "equals to Lego"))
    		.isEqualToIgnoringCase("FROdo")
    		.isEqualToIgnoringNewLines("Fro\ndo")
			.isEqualToNormalizingWhitespace("        Frodo  ")
    		.containsPattern("[a-f]*");
    }

    @Test
    public void testEqualsFloat() {
        assertThat(pi).isEqualTo(3.141592653, offset(0.0000000006))
        .isGreaterThan(3)
        .isLessThanOrEqualTo(3.141592654)
        .isCloseTo(3.141592653, offset(0.0000000006))
        .isBetween(3.141592653, 3.1415926536);
    }

    @Test
    public void testEqualsObjects() {
        assertThat(frodo).isEqualTo(frodo)
    		.isEqualToComparingFieldByField(new TolkienCharacter("Frodo", 38, Race.HOBBIT))
    		.isEqualToComparingOnlyGivenFields(new TolkienCharacter("Bilbo", 131, Race.HOBBIT), "race")
    		.isEqualToIgnoringNullFields(new TolkienCharacter(null, 38, null));
    }


    @Test
    public void testSoftAssertion() {
        SoftAssertions.assertSoftly(softly -> {

            softly.assertThat(characterNames).hasSize(5);
            softly.assertThat(characterNames).containsExactly("Boromir", "Frodo", "Sam", "Gandalf", "Legolas");
            softly.assertThat(characterNames).doesNotContain("Bilbo");
            softly.assertThat(characterNames).containsSequence("Frodo", "Sam");

        });
    }

    @Test(description = "Using extracting and turples")
    public void testExtras1() {
        assertThat(TolkienFactory.getHeros()).extracting("name").contains("Boromir", "Frodo", "Sam", "Gandalf", "Legolas");

        assertThat(TolkienFactory.getHeros()).extracting("name", "age", "race.name")
                                             .containsAnyOf(tuple("Boromir", 37, "Man"),
                                                     tuple("Sam", 38, "Hobbit"),
                                                     tuple("Legolas", 100, "ELF"));
    }

    @Test(description = "Using file assertions")
    public void testExtras2() {
//        File xFile = new File(Paths.get("src", "test", "resources", "assertions", "Truth.txt").toAbsolutePath().toString());
        File xFile = new File("src/test/resources/assertions/Truth.txt");

        // classic file assertions
        assertThat(xFile).exists().isFile().isAbsolute();

        // Using the contentOf we may use all of the String assertions available
        assertThat(contentOf(xFile)).startsWith("The Truth").contains("Is Out").endsWith("There");
    }
}

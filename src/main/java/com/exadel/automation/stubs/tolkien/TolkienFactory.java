package com.exadel.automation.stubs.tolkien;

import java.util.Arrays;
import java.util.List;

import com.exadel.automation.stubs.tolkien.TolkienCharacter.Race;

public class TolkienFactory {
	public static List<TolkienCharacter> getHeros(){
		return Arrays.asList(
				new TolkienCharacter("Boromir", 37, Race.MAN),
				new TolkienCharacter("Frodo", 38, Race.HOBBIT),
				new TolkienCharacter("Sam", 38, Race.HOBBIT),
				new TolkienCharacter("Gandalf", 50, Race.MAN),
				new TolkienCharacter("Legolas", 100, Race.ELF)
				);
	}
}

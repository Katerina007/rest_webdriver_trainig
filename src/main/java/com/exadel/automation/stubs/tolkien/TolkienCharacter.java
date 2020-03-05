package com.exadel.automation.stubs.tolkien;

public class TolkienCharacter {
	public String name;
	public int age;
	public Race race;
	
	public enum Race {
		MAN("Man"), 
		HOBBIT("Hobbit"), 
		ELF("Elf");

		public String name;		
		private Race(String raceName) {
			this.name = raceName;
		}
	}
	
	public TolkienCharacter(String name, int age, Race race) {
		this.name = name;
		this.age= age;
		this.race = race;
	} 
	
	public String getName() {return this.name;}
	
	public int getAge() {return this.age;}
	
	public Race getRace() {return this.race;}
	
}
package s26_tables.controller;

import s26_tables.model.Person;
import s26_tables.model.AgeCategory;
import s26_tables.model.Database;
import s26_tables.model.EmploymentCategory;
import s26_tables.model.Gender;

import java.util.List;

import s26_tables.gui.FormEvent;

public class Controller {
	Database db = new Database();
	
	public List<Person> getPeople() {
		return db.getPeople();
	}
	
	public void addPerson(FormEvent event) {
		String name = event.getName();
		String occupation = event.getOccupation();
		int ageCategoryId = event.getAgeCategory();
		String employmentCategoryString = event.getEmployeeCategory();
		boolean isUsCitizen = event.isUsCitizen();
		String taxId = event.getTaxId();
		String gender = event.getGender();
		
		AgeCategory ageCategory = null;
		
		switch (ageCategoryId) {
		case 0:
			ageCategory = AgeCategory.CHILD;
			break;
		case 1:
			ageCategory = AgeCategory.ADULT;
			break;
		case 2:
			ageCategory = AgeCategory.SENIOR;
			break;
		}
		
		EmploymentCategory employmentCategory;
		
		if (employmentCategoryString.equals("employed")) {
			employmentCategory = EmploymentCategory.EMPLOYED;
		} else if (employmentCategoryString.equals("self-employed")) {
			employmentCategory = EmploymentCategory.SELF_EMPLOYED;
		} else if (employmentCategoryString.equals("unemployed")) {
			employmentCategory = EmploymentCategory.UNEMPLOYED;
		} else {
			employmentCategory = EmploymentCategory.OTHER;
			System.err.println(employmentCategory);
		}
			
		Gender genderCategory;
		if (gender.equals("male")) {
			genderCategory = Gender.MALE;
		} else {
			genderCategory = Gender.FEMALE;
		}
		
		
		Person person = new Person(name, occupation, ageCategory, employmentCategory, taxId, isUsCitizen, genderCategory);
		
		db.addPerson(person);
	}
	
}

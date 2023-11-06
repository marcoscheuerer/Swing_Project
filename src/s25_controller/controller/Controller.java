package s25_controller.controller;

import s25_controller.model.Person;
import s25_controller.model.AgeCategory;
import s25_controller.model.Database;
import s25_controller.model.EmploymentCategory;
import s25_controller.model.Gender;
import s25_controller.gui.FormEvent;

public class Controller {
	Database db = new Database();
	
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

package cab;

public enum Gender {
   MALE,FEMALE;
	
	public static Gender identifyGender(String gender) {
		for(Gender g : Gender.values()) {
			if(gender.toLowerCase().equals(g.name().toLowerCase())) {
				return g;
			}
		}
		return Gender.MALE;
	}
}

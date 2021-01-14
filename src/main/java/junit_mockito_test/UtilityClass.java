package junit_mockito_test;
public class UtilityClass {
	public static void setMe(Employee e, YearOfExprience yoe) {
		if (yoe.getEmpl() == e && yoe.getYoe() == 3)
			e.setEmpType("GOLDEN");
		else if (yoe.getEmpl() == e && yoe.getYoe() == 5)
			e.setEmpType("SILVER");
	}
}
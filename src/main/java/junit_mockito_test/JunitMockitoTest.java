package junit_mockito_test;

public class JunitMockitoTest {
	public Color getColor(Employee e, YearOfExprience yoe) {
		UtilityClass.setMe(e, yoe);
		if (yoe.getEmpl() == e && yoe.getYoe() >= 2 && yoe.getYoe() <= 4 && e.getEmpType().equals("GOLDEN"))
			return Color.BLUE;
		else if (yoe.getEmpl() == e && yoe.getYoe() >= 5 && yoe.getYoe() <= 7)
			return Color.RED;
		else if (yoe.getEmpl() == e && yoe.getYoe() >= 8 && yoe.getYoe() <= 10)
			return Color.GREEN;
		return Color.TRANSPARAINT;

	}
}

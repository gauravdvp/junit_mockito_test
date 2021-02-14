package junit_mockito_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.condition.DisabledIf;
import java.util.LinkedHashMap;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
public class JunitMockitoTestTest {

	@Mock
	Employee e;

	@Mock
	YearOfExprience yoe;

	JunitMockitoTest jmt = new JunitMockitoTest();

	@BeforeAll
	void onlyOnce() {

	}

	TestInfo testInfo;
	TestReporter testReporter;

	@BeforeEach
	public void init() {
		// Stream.of(e.getClass().getMethods()).forEach(System.out::println);
		when(yoe.getEmpl()).thenReturn(e);
	}

	@Test
	@DisabledIf(value = "1!=1", reason = "if 1==1 then disable")
	@DisplayName("Color.BLUE test case.")
	public void getColor1() {
		when(yoe.getYoe()).thenReturn(3);
		when(e.getEmpType()).thenReturn("GOLDEN");
		assertEquals(Color.BLUE, jmt.getColor(e, yoe), " sorry kumar.");
	}

	@RepeatedTest(3)
	@Tag("meOnly")
	@DisplayName("Color.RED test case.")
	public void getColor2(RepetitionInfo ri) {
		System.out.println(ri.getCurrentRepetition() + " : " + ri.getTotalRepetitions());
		when(yoe.getYoe()).thenReturn(6);
		assertEquals(Color.RED, jmt.getColor(e, yoe));
	}

	@Test
	@Order(1)
	@DisplayName("Color.GREEN test case.")
	public void getColor3() {
		when(yoe.getYoe()).thenReturn(9);
		assertEquals(Color.GREEN, jmt.getColor(e, yoe));
	}

	@Test
	@Order(2)
	@DisplayName("Color.TRANSPARINT test case.")
	public void getColor() {
		when(yoe.getYoe()).thenReturn(12);
		assertEquals(Color.TRANSPARAINT, jmt.getColor(e, yoe));
	}

	/*@Disabled
	@ParameterizedTest
	@EnumSource(value = Thread.State.class)
	public void parameterizedTest(Class t) {
		System.out.println(t);
	}*/

	@Nested
	@DisplayName(value = "Possitive Number Check")
	class Help {
	}

	public void hello() {
	}

}

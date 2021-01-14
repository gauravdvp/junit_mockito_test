package junit_mockito_test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class JunitMockitoTestTest {

	@Nested
	@DisplayName(value="Possitive Number Check")
	class Help {
		@Mock
		Employee e;

		@Mock
		YearOfExprience yoe;

		JunitMockitoTest jmt = new JunitMockitoTest();
		
		TestInfo testInfo;
		TestReporter testReporter;

		@BeforeEach
		public void init() {
			// Stream.of(e.getClass().getMethods()).forEach(System.out::println);
			when(yoe.getEmpl()).thenReturn(e);
		}

		@Test
		@DisabledIf(value="1!=1",reason = "if 1==1 then disable" )
		@DisplayName("Color.BLUE test case.")
		public void getColor1() {
			when(yoe.getYoe()).thenReturn(3);
			when(e.getEmpType()).thenReturn("GOLDEN");
			assertEquals(Color.BLUE, jmt.getColor(e, yoe), " sorry kumar.");
		}

		@Test
		@RepeatedTest(3)
		@DisplayName("Color.RED test case.")
		public void getColor2() {
			when(yoe.getYoe()).thenReturn(6);
			assertEquals(Color.RED, jmt.getColor(e, yoe));
		}

		@Test
		@DisplayName("Color.GREEN test case.")
		public void getColor3() {
			when(yoe.getYoe()).thenReturn(9);
			assertEquals(Color.GREEN, jmt.getColor(e, yoe));
		}

		@Test
		@DisplayName("Color.TRANSPARINT test case.")
		public void getColor() {
			when(yoe.getYoe()).thenReturn(12);
			assertEquals(Color.TRANSPARAINT, jmt.getColor(e, yoe));
		}

	}

}

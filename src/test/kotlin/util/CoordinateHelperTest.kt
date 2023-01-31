package util

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals


internal class CoordinateHelperTest {

	private lateinit var sut: CoordinateHelper

	@BeforeEach
	fun setUp() {
		sut = CoordinateHelper()
	}

	companion object {
		@JvmStatic
		fun `parseDirection when valid Direction is passed, it should return N Method Source`(): Stream<Arguments> {
			return Stream.of(
				Arguments.of("0:0:N", "N", "North"),
				Arguments.of("0:0:S", "S", "South"),
				Arguments.of("0:0:E", "E", "East"),
				Arguments.of("0:0:W", "W", "West"),
			)
		}

		@JvmStatic
		fun `parseDirection when invalid Direction is passed, it should throw InvalidDirectionException Method Source`() =
			CommonTestInputs.invalidDirectionsStream
	}

	//region parseX
	@Test
	fun `parseXCoordinate when 0_0_N is passed, it should return 0`() {
		//arrange


		//act
		val actual = sut.parseXCoordinate("0:0:N")

		//assert
		val expected = 0
		assertEquals(expected, actual)
	}

	@Test
	fun `parseXCoordinate when 10_0_N is passed, it should return 10`() {
		//arrange


		//act
		val actual = sut.parseXCoordinate("10:0:N")

		//assert
		val expected = 10
		assertEquals(expected, actual)
	}

	/**
	 * tests that [CoordinateHelper.parseXCoordinate] doesn't get affected with Y and Direction values
	 */
	@Test
	fun `parseXCoordinate when 5_2_W is passed, it should return 5`() {
		//arrange


		//act
		val actual = sut.parseXCoordinate("5:2:W")

		//assert
		val expected = 5
		assertEquals(expected, actual)
	}

	/**
	 * testing invalid X coordinate
	 */
	@Test
	fun `parseXCoordinate when 11_0_N is passed, it should throw invalid Coordinate Exception`() {

		//act
		val actual = { sut.parseXCoordinate("11:0:N") }

		//assert
		assertThrows<InvalidCoordinateException> {
			actual()
		}
	}

	/**
	 * testing invalid X coordinate
	 */
	@Test
	fun `parseXCoordinate when -5_0_N is passed, it should throw invalid Coordinate Exception`() {

		//act
		val actual = { sut.parseXCoordinate("-5:0:N") }

		//assert
		assertThrows<InvalidCoordinateException> {
			actual()
		}
	}
	//endregion


	//region parseY
	@Test
	fun `parseYCoordinate when 0_0_N is passed, it should return 0`() {
		//arrange


		//act
		val actual = sut.parseYCoordinate("0:0:N")

		//assert
		val expected = 0
		assertEquals(expected, actual)
	}

	@Test
	fun `parseYCoordinate when 0_10_N is passed, it should return 10`() {
		//arrange


		//act
		val actual = sut.parseYCoordinate("0:10:N")

		//assert
		val expected = 10
		assertEquals(expected, actual)
	}


	/**
	 * tests that [CoordinateHelper.parseXCoordinate] doesn't get affected with Y and Direction values
	 */
	@Test
	fun `parseYCoordinate when 2_5_W is passed, it should return 5`() {
		//arrange


		//act
		val actual = sut.parseYCoordinate("2:5:W")

		//assert
		val expected = 5
		assertEquals(expected, actual)
	}

	/**
	 * testing invalid Y coordinate
	 */
	@Test
	fun `parseYCoordinate when 0_11_N is passed, it should throw invalid Coordinate Exception`() {

		//act
		val actual = { sut.parseYCoordinate("0:11:N") }

		//assert
		assertThrows<InvalidCoordinateException> {
			actual()
		}
	}

	/**
	 * testing invalid Y coordinate
	 */
	@Test
	fun `parseYCoordinate when 0_-5_N is passed, it should throw invalid Coordinate Exception`() {

		//act
		val actual = { sut.parseYCoordinate("0:-5:N") }

		//assert
		assertThrows<InvalidCoordinateException> {
			actual()
		}
	}
	//endregion


	//region parse Direction
	@ParameterizedTest(name = "{2}")
	@MethodSource("parseDirection when valid Direction is passed, it should return N Method Source")
	fun `parseDirection when valid Direction is passed, it should return N`(
		input: String,
		expected: String,
		funTestName: String
	) {
		//act
		val actual = sut.parseDirection(input)

		//arrange
		assertEquals(expected, actual)
	}

	@ParameterizedTest(name = "{0}")
	@MethodSource("parseDirection when invalid Direction is passed, it should throw InvalidDirectionException Method Source")
	fun `parseDirection when invalid Direction is passed, it should throw InvalidDirectionException`(
		input: String,
	) {
		//act
		val actual = { sut.parseDirection(input) }

		//arrange
		assertThrows<InvalidDirectionException> {
			actual()
		}
	}
	//endregion

	//region ConcatenateLocationData
	@Test
	fun `concatenate location data with 0, 0, N, it should return 0_0_N`() {
		//act
		val actual = sut.concatenateLocationData(0, 0, Direction.initUsingSymbolString("N"))

		//assert
		val expected = "0:0:N"
		assertEquals(expected, actual)
	}

	@Test
	fun `concatenate location data with 0, 0, E, it should return 0_0_E`() {
		//act
		val actual = sut.concatenateLocationData(0, 0, Direction.initUsingSymbolString("E"))

		//assert
		val expected = "0:0:E"
		assertEquals(expected, actual)
	}

	@Test
	fun `concatenate location data with 5, 0, E, it should return 5_0_E`() {
		//act
		val actual = sut.concatenateLocationData(5, 0, Direction.initUsingSymbolString("E"))

		//assert
		val expected = "5:0:E"
		assertEquals(expected, actual)
	}

	@Test
	fun `concatenate location data with 0, 5, E, it should return 0_5_E`() {
		//act
		val actual = sut.concatenateLocationData(0, 5, Direction.initUsingSymbolString("E"))

		//assert
		val expected = "0:5:E"
		assertEquals(expected, actual)
	}
	//endregion
}

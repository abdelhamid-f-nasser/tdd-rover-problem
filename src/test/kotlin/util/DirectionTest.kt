package util

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import org.junit.jupiter.api.*

internal class DirectionTest {

	private lateinit var direction: Direction

	companion object {
		@JvmStatic
		fun `initUsingSymbolString when symbol is valid, it should return an appropriate direction Method Source`() : Stream<Arguments> {
			return Stream.of(
				Arguments.of(
					"N", Direction.North
				),
				Arguments.of(
					"E", Direction.East
				),
				Arguments.of(
					"S", Direction.South
				),
				Arguments.of(
					"W", Direction.West
				),
			)
		}

		@JvmStatic
		fun `initUsingSymbolString when symbol is invalid, it should throw InvalidDirectionException Method Source`() =
			CommonTestInputs.invalidDirectionsStream
	}

	//region right
	@Test
	fun `right when direction is North, it should return East`() {
		// arrange
		direction = Direction.North

		// act
		val expected = direction.right()

		//assert
		val actual = Direction.East
		assertEquals(expected, actual)
	}

	@Test
	fun `right when direction is East, it should return South`() {
		// arrange
		direction = Direction.East

		// act
		val expected = direction.right()

		//assert
		val actual = Direction.South
		assertEquals(expected, actual)
	}

	@Test
	fun `right when direction is South, it should return West`() {
		// arrange
		direction = Direction.South

		// act
		val expected = direction.right()

		//assert
		val actual = Direction.West
		assertEquals(expected, actual)
	}

	@Test
	fun `right when direction is West, it should return North`() {
		// arrange
		direction = Direction.West

		// act
		val expected = direction.right()

		//assert
		val actual = Direction.North
		assertEquals(expected, actual)
	}
	//endregion

	//region left
	@Test
	fun `left when direction is North, it should return West`() {
		// arrange
		direction = Direction.North

		// act
		val expected = direction.left()

		//assert
		val actual = Direction.West
		assertEquals(expected, actual)
	}

	@Test
	fun `left when direction is East, it should return North`() {
		// arrange
		direction = Direction.East

		// act
		val expected = direction.left()

		//assert
		val actual = Direction.North
		assertEquals(expected, actual)
	}

	@Test
	fun `left when direction is South, it should return East`() {
		// arrange
		direction = Direction.South

		// act
		val expected = direction.left()

		//assert
		val actual = Direction.East
		assertEquals(expected, actual)
	}

	@Test
	fun `left when direction is West, it should return South`() {
		// arrange
		direction = Direction.West

		// act
		val expected = direction.left()

		//assert
		val actual = Direction.South
		assertEquals(expected, actual)
	}
	//endregion

	// region initUsingSymbolString
	@ParameterizedTest(name = "{0}")
	@MethodSource("initUsingSymbolString when symbol is valid, it should return an appropriate direction Method Source")
	fun `initUsingSymbolString when symbol is valid, it should return an appropriate direction`(directionString: String, expectedDirection: Direction) {

		// act
		val actual = Direction.initUsingSymbolString(directionString)

		// assert
		assertEquals(expectedDirection, actual)
	}

	@ParameterizedTest(name = "{0}")
	@MethodSource("initUsingSymbolString when symbol is invalid, it should throw InvalidDirectionException Method Source")
	fun `initUsingSymbolString when symbol is invalid, it should throw InvalidDirectionException`(directionString: String) {

		// assert
		assertThrows<InvalidDirectionException> { Direction.initUsingSymbolString(directionString) }
	}
	//endregion
}

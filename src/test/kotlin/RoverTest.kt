import kotlin.test.Test
import kotlin.test.assertEquals

internal class RoverTest {



	//region one command tests
	@Test
    fun `sendCommands when only move command is sent then it should returns 0,1,N`() {
		// arrange
		val sut = Rover("0:0:N")

		// act

		val actual = sut.sendCommands("M")

		// assert
		val expected =  "0:1:N"
		assertEquals(expected, actual)
	}

	@Test
    fun `sendCommands when only left command is sent it should return 0,0,W`() {
		// arrange
		val sut = Rover("0:0:N")

		// act

		val actual = sut.sendCommands("L")

		// assert
		val expected =  "0:0:W"
		assertEquals(expected, actual)
	}

	@Test
    fun `sendCommands when only right command is sent it should return 0,0,E`() {
		// arrange
		val sut = Rover("0:0:N")

		// act

		val actual = sut.sendCommands("R")

		// assert
		val expected =  "0:0:E"
		assertEquals(expected, actual)
	}
	//endregion


	//region sending two commands tests
	@Test
	fun `sendCommands when two move commands are sent then it should returns 0,2,N`() {
		// arrange
		val sut = Rover("0:0:N")

		// act

		val actual = sut.sendCommands("MM")

		// assert
		val expected =  "0:2:N"
		assertEquals(expected, actual)
	}

	@Test
	fun `sendCommands when two left commands are sent it should return 0,0,S`() {
		// arrange
		val sut = Rover("0:0:N")

		// act

		val actual = sut.sendCommands("LL")

		// assert
		val expected =  "0:0:S"
		assertEquals(expected, actual)
	}

	@Test
	fun `sendCommands when two right commands are sent it should return 0,0,S`() {
		// arrange
		val sut = Rover("0:0:N")

		// act

		val actual = sut.sendCommands("RR")

		// assert
		val expected =  "0:0:S"
		assertEquals(expected, actual)
	}
	//endregion
}

package util

import java.util.*

class CoordinateHelper {

	@Throws(InvalidCoordinateException::class)
	fun parseXCoordinate(locationData: String): Int {
		val parsedDataArr = splitLocationData(locationData)
		val x = parsedDataArr[0].toInt()
		if(x > 10 || x < 0)
			throw InvalidCoordinateException()
		return x
	}

	@Throws(InvalidCoordinateException::class)
	fun parseYCoordinate(locationData: String): Int {
		val parsedDataArr = splitLocationData(locationData)
		val y = parsedDataArr[1].toInt()
		if(y > 10 || y < 0)
			throw InvalidCoordinateException()
		return y
	}


	@Throws(InvalidDirectionException::class)
	fun parseDirection(locationData: String): String {
		val parsedDataArr = splitLocationData(locationData)
		val direction = parsedDataArr[2]
		val validDirections = listOf("N", "S", "E", "W")
		if(!validDirections.contains(direction))
			throw InvalidDirectionException()
		return direction
	}


	private fun splitLocationData(locationData: String) = locationData.split(':')
	fun concatenateLocationData(x: Int, y: Int, direction: Direction): String {
		return "${x}:${y}:${direction.symbol}"
	}
}

class InvalidCoordinateException: Exception() {
	override val message: String
		get() = "Coordinates must be between 0 and 10"
}

class InvalidDirectionException: Exception() {
	override val message: String
		get() = "Direction must be either N, S, E or W"
}

package util

object CommonTestInputs {
	val invalidDirectionsStream = (('A'..'Z') + ('a'..'z')).toMutableList().apply { removeAll(
		listOf('N', 'S', 'E', 'W')) }.map { "0:0:${it}" }.toList().stream()
}

import util.CoordinateHelper
import util.Direction

class Rover(initialData: String) {

	/** TODO: Parse these from [initialData] */
	var x = 0
	var y = 0
	var direction = Direction.North
	private val helper = CoordinateHelper()

	init {
		x = helper.parseXCoordinate(initialData)
		y = helper.parseYCoordinate(initialData)
		val directionString = helper.parseDirection(initialData)
		direction = Direction.initUsingSymbolString(directionString)
	}

	fun sendCommands(commands: String) : String {
		var result: String = ""

		commands.forEach {
			result += when(it) {
				'M' -> {
					move()
				}
				'L' -> {
					rotateLeft()
				}
				'R' -> {
					rotateRight()
				}
				else -> ""
			}
		}
		return helper.concatenateLocationData(x, y, direction)
	}

	private fun rotateRight() {
		direction = direction.right()
	}

	private fun rotateLeft(){
		direction = direction.left()
	}

	private fun move() {
		y++
	}
}




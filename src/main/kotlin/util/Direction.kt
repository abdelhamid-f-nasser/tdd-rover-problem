package util

enum class Direction (val symbol: String){
	North("N") {
		override fun right(): Direction = East

		override fun left(): Direction = West
	},
	East("E") {
		override fun right(): Direction = South

		override fun left(): Direction = North
	},
	South("S") {
		override fun right(): Direction = West

		override fun left(): Direction  = East
	},
	West("W") {
		override fun right(): Direction  = North

		override fun left(): Direction = South
	};

	abstract fun right() : Direction

	abstract fun left() : Direction

	companion object {
		fun initUsingSymbolString(symbol: String): Direction {
			values().forEach {
				if(it.symbol == symbol)
					return it
			}
			throw InvalidDirectionException()
		}
	}
}

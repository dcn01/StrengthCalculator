package com.e.bunu.strengthcalc

object StrengthCalculations {
    private val CONVERSION_FACTOR: Double = 2.25
    fun toKG(lbs: Double): Double {
        return lbs / CONVERSION_FACTOR
    }

    fun toLBS(kg: Double): Double {
        return kg * CONVERSION_FACTOR
    }

    //Different formulas to calculate maxes
    fun EpleyMax(weight: Double, reps: Int): Double {
        if (weight < 1) throw IllegalArgumentException("Has to be positive weight")

        var _reps: Int = when {
            reps == 1 -> return weight
            reps < 0 -> throw IllegalArgumentException("Has to be positive reps")
            reps > 30 -> 30
            else -> reps
        }
        return weight * (1.0 + (_reps / 30.0))
    }

    fun BrzyckiMax(weight: Double, reps: Int): Double {
        if (weight < 1) throw IllegalArgumentException("Has to be positive weight")

        var _reps: Int = when {
            reps == 1 -> return weight
            reps < 0 -> throw IllegalArgumentException("Has to be positive reps")
            reps > 36 -> 36
            else -> reps
        }
        return weight * (36.0 / (37.0 - _reps))
    }

    fun McGlothinMax(weight: Double, reps: Int): Double {
        if (weight < 1) throw IllegalArgumentException("Has to be positive weight")

        var _reps: Int = when {
            reps == 1 -> return weight
            reps < 0 -> throw IllegalArgumentException("Has to be positive reps")
            else -> reps
        }
        return (100.0 * weight) / (101.3 - 2.67123 * _reps)
    }

    fun LombardiMax(weight: Double, reps: Int): Double {
        if (weight < 1) throw IllegalArgumentException("Has to be positive weight")

        var _reps: Double = when {
            reps < 0 -> -1.0 * reps
            else -> reps.toDouble()
        }
        return weight * Math.pow(_reps, .10)
    }

    fun MayhewMax(weight: Double, reps: Int): Double {
        if (weight < 1) throw IllegalArgumentException("Has to be positive weight")

        var _reps: Int = when {
            reps == 1 -> return weight
            reps < 0 -> throw IllegalArgumentException("Has to be positive reps")
            else -> reps
        }
        return (100.0 * weight) / (52.2 + 41.9 * Math.pow(Math.E, (-.055 * _reps)))
    }

    fun OConnerMax(weight: Double, reps: Int): Double {
        if (weight < 1) throw IllegalArgumentException("Has to be positive weight")

        var _reps: Int = when {
            reps == 1 -> return weight
            reps < 0 -> throw IllegalArgumentException("Has to be positive reps")
            else -> reps
        }
        return weight * (1.0 + (_reps / 40.0))
    }

    fun WathanMax(weight: Double, reps: Int): Double {
        if (weight < 1) throw IllegalArgumentException("Has to be positive weight")

        var _reps: Int = when {
            reps == 1 -> return weight
            reps < 0 -> throw IllegalArgumentException("Has to be positive reps")
            else -> reps
        }
        return (100.0 * weight) / (48.8 + 53.8 * Math.pow(Math.E, (-.075 * _reps)))
    }

    fun avgMax(weight: Double, reps: Int): Double {
        if (weight < 1) throw IllegalArgumentException("Has to be positive weight")

        var _reps: Int = when {
            reps == 1 -> return weight
            reps < 0 -> throw IllegalArgumentException("Has to be positive reps")
            else -> reps
        }
        var values = DoubleArray(7)
        values[0] = EpleyMax(weight, _reps)
        values[1] = BrzyckiMax(weight, _reps)
        values[2] = McGlothinMax(weight, _reps)
        values[3] = LombardiMax(weight, _reps)
        values[4] = MayhewMax(weight, _reps)
        values[5] = OConnerMax(weight, _reps)
        values[6] = WathanMax(weight, _reps)
        return values.average()
    }
}
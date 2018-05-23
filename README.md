# StrengthCalculator
A library made in Kotlin that calculates one rep max using different formulas

### Formulas Available
* Epley
* Brzycki
* McGlothin
* Lombardi
* Mayhew
* O'Conner
* Wathan
* Average of all the formulas

### Usage
Each method returns a double. The parameters are the same for each method. (weight,rep). Weight is a double and rep is an int.

#### Kotlin Example
```kotlin
import com.e.bunu.strengthcalc.*

fun main(args: Array<String>){
  StrengthCalculations.EpleyMax(100.0,10)
}
```

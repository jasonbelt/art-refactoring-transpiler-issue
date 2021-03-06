// #Sireum

package packageName_not_set.BuildingControl

import org.sireum._
import packageName_not_set._

// This file was auto-generated.  Do not edit

@enum object TempUnit {
  "Fahrenheit"
  "Celsius"
  "Kelvin"
}

object TempUnit_Payload {
  def example(): TempUnit_Payload = {
    return TempUnit_Payload(BuildingControl.TempUnit.byOrdinal(0).get)
  }
}

@datatype class TempUnit_Payload(value: BuildingControl.TempUnit.Type) extends art.DataContent

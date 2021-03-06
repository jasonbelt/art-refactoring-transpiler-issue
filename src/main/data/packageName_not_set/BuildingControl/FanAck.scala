// #Sireum

package packageName_not_set.BuildingControl

import org.sireum._
import packageName_not_set._

// This file was auto-generated.  Do not edit

@enum object FanAck {
  "Ok"
  "Error"
}

object FanAck_Payload {
  def example(): FanAck_Payload = {
    return FanAck_Payload(BuildingControl.FanAck.byOrdinal(0).get)
  }
}

@datatype class FanAck_Payload(value: BuildingControl.FanAck.Type) extends art.DataContent

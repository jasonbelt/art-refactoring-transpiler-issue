package packageName_not_set.BuildingControl

import org.sireum._
import art.{ArtNative_Ext, Empty}
import packageName_not_set._

// This file was auto-generated.  Do not edit
abstract class TempSensor_i_tcp_tempSensor_TestApi extends BridgeTestSuite[TempSensor_i_tcp_tempSensor_Bridge](Arch.BuildingControlDemo_i_Instance_tcp_tempSensor) {

  /** helper function to check TempSensor_i_tcp_tempSensor's
   * output ports.  Use named arguments to check subsets of the output ports.
   * @param currentTemp method that will be called with the value of the outgoing data
   *        port 'currentTemp'.
   * @param tempChanged method that will be called with the number of events to be sent
   *        on the outgoing event port 'tempChanged'.
   */
  def check_concrete_output(currentTemp: BuildingControl.Temperature_impl => B = currentTempParam => {T},
                            tempChanged: Z => B = tempChangedParam => {T}): Unit = {
    var testFailures: ISZ[ST] = ISZ()

    val currentTempValue: BuildingControl.Temperature_impl = get_currentTemp().get
    if(!currentTemp(currentTempValue)) {
      testFailures = testFailures :+ st"'currentTemp' did not match expected: value of the outgoing data port is ${currentTempValue}"
    }
    // TODO: event port getter should return the number of events in
    //       the output queue when queue sizes > 1 support is added to ART
    val tempChangedValue: Z = if(get_tempChanged().nonEmpty) z"1" else z"0"
    if(!tempChanged(tempChangedValue)) {
      testFailures = testFailures :+ st"'tempChanged' did not match expected: ${tempChangedValue} events were in the outgoing event queue"
    }

    assert(testFailures.isEmpty, st"${(testFailures, "\n")}".render)
  }


  // getter for out DataPort
  def get_currentTemp(): Option[BuildingControl.Temperature_impl] = {
    val value: Option[BuildingControl.Temperature_impl] = get_currentTemp_payload() match {
      case Some(BuildingControl.Temperature_impl_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port currentTemp.  Expecting 'BuildingControl.Temperature_impl_Payload' but received ${v}")
      case _ => None[BuildingControl.Temperature_impl]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_currentTemp_payload(): Option[BuildingControl.Temperature_impl_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.currentTemp_Id).asInstanceOf[Option[BuildingControl.Temperature_impl_Payload]]
  }

  // getter for out EventPort
  def get_tempChanged(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_tempChanged_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port tempChanged.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_tempChanged_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.tempChanged_Id).asInstanceOf[Option[Empty]]
  }

}

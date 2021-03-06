// #Sireum

package packageName_not_set

import org.sireum._
import art._

// This file was auto-generated.  Do not edit

object TempControl_i_tcp_tempControl_App extends App {

  val entryPoints: Bridge.EntryPoints = Arch.BuildingControlDemo_i_Instance_tcp_tempControl.entryPoints
  val appPortId: Art.PortId = IPCPorts.TempControl_i_tcp_tempControl_App
  val appPortIdOpt: Option[Art.PortId] = Some(appPortId)
  val currentTempPortId: Art.PortId = Arch.BuildingControlDemo_i_Instance_tcp_tempControl.currentTemp.id
  val currentTempPortIdOpt: Option[Art.PortId] = Some(currentTempPortId)
  val fanAckPortId: Art.PortId = Arch.BuildingControlDemo_i_Instance_tcp_tempControl.fanAck.id
  val fanAckPortIdOpt: Option[Art.PortId] = Some(fanAckPortId)
  val setPointPortId: Art.PortId = Arch.BuildingControlDemo_i_Instance_tcp_tempControl.setPoint.id
  val setPointPortIdOpt: Option[Art.PortId] = Some(setPointPortId)
  val tempChangedPortId: Art.PortId = Arch.BuildingControlDemo_i_Instance_tcp_tempControl.tempChanged.id
  val tempChangedPortIdOpt: Option[Art.PortId] = Some(tempChangedPortId)

  def initialiseArchitecture(seed: Z): Unit = {
    Platform.initialise(seed, appPortIdOpt)
    Platform.initialise(seed, currentTempPortIdOpt)
    Platform.initialise(seed, fanAckPortIdOpt)
    Platform.initialise(seed, setPointPortIdOpt)
    Platform.initialise(seed, tempChangedPortIdOpt)

    Art.run(Arch.ad)
  }

  def initialise(): Unit = {
    entryPoints.initialise()
  }

  def compute(): Unit = {
    var dispatch = F

    {
      val out = IPCPorts.emptyReceiveAsyncOut
      Platform.receiveAsync(currentTempPortIdOpt, out)
      out.value2 match {
        case Some(v: BuildingControl.Temperature_impl_Payload) => ArtNix.updateData(currentTempPortId, v); dispatch = F
        case Some(v) => halt(s"Unexpected payload on port currentTemp.  Expecting something of type BuildingControl.Temperature_impl_Payload but received ${v}")
        case None() => // do nothing
      }
    }
    {
      val out = IPCPorts.emptyReceiveAsyncOut
      Platform.receiveAsync(fanAckPortIdOpt, out)
      out.value2 match {
        case Some(v: BuildingControl.FanAck_Payload) => ArtNix.updateData(fanAckPortId, v); dispatch = T
        case Some(v) => halt(s"Unexpected payload on port fanAck.  Expecting something of type BuildingControl.FanAck_Payload but received ${v}")
        case None() => // do nothing
      }
    }
    {
      val out = IPCPorts.emptyReceiveAsyncOut
      Platform.receiveAsync(setPointPortIdOpt, out)
      out.value2 match {
        case Some(v: BuildingControl.SetPoint_impl_Payload) => ArtNix.updateData(setPointPortId, v); dispatch = T
        case Some(v) => halt(s"Unexpected payload on port setPoint.  Expecting something of type BuildingControl.SetPoint_impl_Payload but received ${v}")
        case None() => // do nothing
      }
    }
    {
      val out = IPCPorts.emptyReceiveAsyncOut
      Platform.receiveAsync(tempChangedPortIdOpt, out)
      out.value2 match {
        case Some(v: art.Empty) => ArtNix.updateData(tempChangedPortId, v); dispatch = T
        case Some(v) => halt(s"Unexpected payload on port tempChanged.  Expecting something of type art.Empty but received ${v}")
        case None() => // do nothing
      }
    }
    if (dispatch) {
      entryPoints.compute()
      Process.sleep(1000)
    } else {
      Process.sleep(10)
    }
  }

  def finalise(): Unit = {
    entryPoints.finalise()
  }

  def main(args: ISZ[String]): Z = {

    val seed: Z = if (args.size == z"1") {
      val n = Z(args(0)).get
      if (n == z"0") 1 else n
    } else {
      1
    }

    initialiseArchitecture(seed)

    Platform.receive(appPortIdOpt, IPCPorts.emptyReceiveOut) // pause after setting up component

    initialise()

    Platform.receive(appPortIdOpt, IPCPorts.emptyReceiveOut) // pause after component init

    println("TempControl_i_tcp_tempControl_App starting ...")

    ArtNix.eventDispatch()

    var terminated = F
    while (!terminated) {
      val out = IPCPorts.emptyReceiveAsyncOut
      Platform.receiveAsync(appPortIdOpt, out)
      if (out.value2.isEmpty) {
        compute()
      } else {
        terminated = T
      }
    }
    exit()

    touch()

    return 0
  }

  def touch(): Unit = {
    if(F) {
      TranspilerToucher.touch()

      // touch each payload/type in case some are only used as a field in a record
      def printDataContent(a: art.DataContent): Unit = { println(s"${a}") }

      printDataContent(Base_Types.Float_32_Payload(Base_Types.Float_32_example()))
      printDataContent(BuildingControl.TempUnit_Payload(BuildingControl.TempUnit.byOrdinal(0).get))
      printDataContent(BuildingControl.Temperature_impl_Payload(BuildingControl.Temperature_impl.example()))
      printDataContent(BuildingControl.SetPoint_impl_Payload(BuildingControl.SetPoint_impl.example()))
      printDataContent(BuildingControl.FanAck_Payload(BuildingControl.FanAck.byOrdinal(0).get))
      printDataContent(BuildingControl.FanCmd_Payload(BuildingControl.FanCmd.byOrdinal(0).get))
      printDataContent(art.Empty())

      packageName_not_set.BuildingControl.TempControl_i_tcp_tempControl_Bridge.c_initialization_api.get.logInfo("")
      packageName_not_set.BuildingControl.TempControl_i_tcp_tempControl_Bridge.c_initialization_api.get.logDebug("")
      packageName_not_set.BuildingControl.TempControl_i_tcp_tempControl_Bridge.c_initialization_api.get.logError("")
      packageName_not_set.BuildingControl.TempControl_i_tcp_tempControl_Bridge.c_operational_api.get.logInfo("")
      packageName_not_set.BuildingControl.TempControl_i_tcp_tempControl_Bridge.c_operational_api.get.logDebug("")
      packageName_not_set.BuildingControl.TempControl_i_tcp_tempControl_Bridge.c_operational_api.get.logError("")
      val apiUsage_currentTemp: Option[BuildingControl.Temperature_impl] = packageName_not_set.BuildingControl.TempControl_i_tcp_tempControl_Bridge.c_operational_api.get.get_currentTemp()
      val apiUsage_fanAck: Option[BuildingControl.FanAck.Type] = packageName_not_set.BuildingControl.TempControl_i_tcp_tempControl_Bridge.c_operational_api.get.get_fanAck()
      val apiUsage_setPoint: Option[BuildingControl.SetPoint_impl] = packageName_not_set.BuildingControl.TempControl_i_tcp_tempControl_Bridge.c_operational_api.get.get_setPoint()
      packageName_not_set.BuildingControl.TempControl_i_tcp_tempControl_Bridge.c_initialization_api.get.put_fanCmd(BuildingControl.FanCmd.byOrdinal(0).get)
      packageName_not_set.BuildingControl.TempControl_i_tcp_tempControl_Bridge.c_operational_api.get.put_fanCmd(BuildingControl.FanCmd.byOrdinal(0).get)
      val apiUsage_tempChanged: Option[art.Empty] = packageName_not_set.BuildingControl.TempControl_i_tcp_tempControl_Bridge.c_operational_api.get.get_tempChanged()
    }
  }

  def exit(): Unit = {
    finalise()
    Platform.finalise()
  }

  override def atExit(): Unit = {
    exit()
  }
}
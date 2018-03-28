Apollo Autopilot Example
========================
 
 
 - Apollo
The Apollo Lunar Autopilot is a Simulink model that was automatically translated to Java. The translated Java code has 2.6 KLOC in 54 classes. The Simulink model was created by an engineer working on the Apollo Lunar Module digital autopilot design team. The goal was to study how the model could have been designed in Simulink, if it had been available in 1961. The model is available from MathWorks6. It contains both Simulink blocks and Stateflow diagrams and makes use of complex Math functions (e.g. Math.sqrt). The code has been analyzed before using Symbolic Pathfinder with the Coral solver.
 
 
 
 
The Apollo autopilot example from the JPF-Symbc distribution
(`src/examples/rjc`).


Classes Reachable from Apollo
-----------------------------

Determined using Eclipse's call hierarchy.

~~~~
rjc.Chart
rjc.Jet_On_Time_Counter10
rjc.Jet_On_Time_Counter18
rjc.Jet_On_Time_Counter25
rjc.ObserverAutomata
rjc.Reaction_Jet_Control0
rjc.SimpleCounter
rjc.Subsystem114
rjc.Subsystem122
rjc.Subsystem15
rjc.Subsystem17
rjc.Subsystem213
rjc.Subsystem221
rjc.Subsystem23
rjc.Subsystem26
rjc.Subsystem312
rjc.Subsystem320
rjc.Subsystem35
rjc.Subsystem8
rjc.Yaw_Control_Law1
rjc.rjc
rjc.struct0
rjc.u_Control_Law3
rjc.v_Control_Law2
~~~~

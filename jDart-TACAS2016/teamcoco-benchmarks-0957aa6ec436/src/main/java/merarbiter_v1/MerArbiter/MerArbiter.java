package merarbiter_v1.MerArbiter;

import merarbiter_v1.edu.vanderbilt.isis.sm.Event;
import merarbiter_v1.edu.vanderbilt.isis.sm.RhapsodyInterpreter;
import merarbiter_v1.edu.vanderbilt.isis.sm.StateflowInterpreter;
import merarbiter_v1.edu.vanderbilt.isis.sm.SymbolicDataProvider;
import merarbiter_v1.edu.vanderbilt.isis.sm.UMLInterpreter;

public class MerArbiter {

	private TopLevelArbiter arbiter;
	private TopLevelUser1 user1;
	private TopLevelUser2 user2;

	public MerArbiter() {
		this.arbiter = new TopLevelArbiter();
		this.user1 = new TopLevelUser1();
		this.user2 = new TopLevelUser2();

		User1Reader u1reader = new User1Reader(this.user1.r1.User122, new SymbolicDataProvider(1), null);
		User2Reader u2reader = new User2Reader(this.user2.r1.User228, new SymbolicDataProvider(1), null);
		ArbiterReader areader = new ArbiterReader(this.arbiter.r1.Arbiter3, new SymbolicDataProvider(1), null);

		this.arbiter.sim = new StateflowInterpreter(this.arbiter.sm, u1reader);
		this.user1.sim = new StateflowInterpreter(this.user1.sm, u2reader);
		//this.user1.sim = new UMLInterpreter(this.user1.sm, u2reader);
		//this.user1.sim = new RhapsodyInterpreter(this.user1.sm, u2reader);
		this.user2.sim = new StateflowInterpreter(this.user2.sm, areader);

		this.arbiter.sim.initialize();
		this.user1.sim.initialize();
		this.user2.sim.initialize();
	}

	private void setArbiterInput() {
		this.arbiter.r1.Arbiter3.u1resource = this.user1.r1.User122.resourceOut;
		this.arbiter.r1.Arbiter3.u1request = this.user1.r1.User122.request;
		this.arbiter.r1.Arbiter3.u1cancel = this.user1.r1.User122.cancel;

		this.arbiter.r1.Arbiter3.u2resource = this.user2.r1.User228.resourceOut;
		this.arbiter.r1.Arbiter3.u2request = this.user2.r1.User228.request;
		this.arbiter.r1.Arbiter3.u2cancel = this.user2.r1.User228.cancel;
	}

	private void setUser1Input(int resource, boolean reset) {
		this.user1.r1.User122.resourceIn = resource;
		this.user1.r1.User122.grant = this.arbiter.r1.Arbiter3.u1grant;
		this.user1.r1.User122.deny = this.arbiter.r1.Arbiter3.u1deny;
		this.user1.r1.User122.rescind = this.arbiter.r1.Arbiter3.u1rescind;
		this.user1.r1.User122.reset = reset;
	}

	private void setUser2Input(int resource, boolean reset) {
		this.user2.r1.User228.resourceIn = resource;
		this.user2.r1.User228.grant = this.arbiter.r1.Arbiter3.u2grant;
		this.user2.r1.User228.deny = this.arbiter.r1.Arbiter3.u2deny;
		this.user2.r1.User228.rescind = this.arbiter.r1.Arbiter3.u2rescind;
		this.user2.r1.User228.reset = reset;
	}

	public void runMachines() {
		this.user1.r1.User122.resourceIn = 1;
		this.user1.r1.User122.grant = false;
		this.user1.r1.User122.deny = false;
		this.user1.r1.User122.rescind = false;
		this.user1.r1.User122.reset = false;

		this.user2.r1.User228.resourceIn = 0;
		this.user2.r1.User228.grant = false;
		this.user2.r1.User228.deny = false;
		this.user2.r1.User228.rescind = false;
		this.user2.r1.User228.reset = false;

		Event e = new Event("");

		this.user1.sim.addEvent(e);
		this.user1.sim.step();
		this.user2.sim.addEvent(e);
		this.user2.sim.step();
		this.setArbiterInput();
		this.arbiter.sim.addEvent(e);
		this.arbiter.sim.step();

		// i<100
		for (int i = 0; i < 4; i++) {
			System.out.println("i = " + i);
			this.setUser1Input(0,false);
			this.setUser2Input(1, false);
			this.user1.sim.addEvent(e);
			this.user1.sim.step();
			this.user2.sim.addEvent(e);
			this.user2.sim.step();
			this.setArbiterInput();
			this.arbiter.sim.addEvent(e);
			this.arbiter.sim.step();
		}



	}

	public static void main(String[] args) {
		System.out.println("********************");
		MerArbiter mer = new MerArbiter();
		mer.runMachines();
	}


}

package actions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

public class DoubleActionList {
	
	private final Queue<Actionable> stepPrimary;
	private final Queue<Actionable> stepSecondary;
	
	boolean done = true;
	
	public DoubleActionList() {
		stepPrimary = new ArrayDeque<Actionable>();
		stepSecondary = new ArrayDeque<Actionable>();
		addAction(new WaitAction(0),new WaitAction(0));
	}
	
	public void addAction(Actionable primaryAction, Actionable secondaryAction) {
		System.out.println(""+ primaryAction + secondaryAction);
		stepPrimary.add(primaryAction);
		stepSecondary.add(secondaryAction);
	}
	
	
	public void step() {
		try {
			Actionable primary = stepPrimary.element();
			Actionable secondary = stepSecondary.element();
			
			primary.periodic();
			secondary.periodic();
			
			if (primary.isFinished()) {
				primary.endAction();
			}
			if (secondary.isFinished()) {
				secondary.endAction();
			}
			
			
			if (primary.isFinished() && secondary.isFinished()) {
				System.out.println("next action");
				
				stepPrimary.remove();
				stepSecondary.remove();
				primary = stepPrimary.element();
				secondary = stepSecondary.element();
				
				primary.startAction();
				secondary.startAction();
			}
			
		} catch (NoSuchElementException e) {
			if (done) {
				System.out.println("Nothing in queue I am done");
				done=false;
			}
		}
	}
	

}

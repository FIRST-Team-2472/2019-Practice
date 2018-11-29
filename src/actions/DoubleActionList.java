package actions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

public class DoubleActionList {
	
	private final Queue<Actionable> stepPrimary;
	private final Queue<Actionable> stepSecondary;
	
	public DoubleActionList() {
		stepPrimary = new ArrayDeque<Actionable>();
		stepSecondary = new ArrayDeque<Actionable>();
	}
	
	public void addPrimaryAction(Actionable primaryAction, Actionable secondaryAction) {
		stepPrimary.add(primaryAction);
		stepPrimary.add(secondaryAction);
	}
	
	
	public void step() {
		try {
			Actionable primary = stepPrimary.element();
			Actionable secondary = stepSecondary.element();
			
			primary.periodic();
			secondary.periodic();
			
			if (primary.isFinished() && secondary.isFinished()) {
				primary.endAction();
				secondary.endAction();
				
				stepPrimary.remove();
				stepSecondary.remove();
				primary = stepPrimary.element();
				secondary = stepSecondary.element();
				
				primary.startAction();
				secondary.startAction();
			}
			
		} catch (NoSuchElementException e) {
			System.out.println("Nothing in queue I am done");
		}
	}
	

}

package actions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

public class ActionList {
	
	private final Queue<Actionable> stepPrimary;
	private final Queue<Actionable> stepSecondary;
	
	public ActionList() {
		stepPrimary = new ArrayDeque<Actionable>();
		stepSecondary = new ArrayDeque<Actionable>();
	}
	
	public void addPrimaryAction(Actionable action) {
		stepPrimary.add(action);
	}
	
	public void addSecondaryAction(Actionable action) {
		stepSecondary.add(action);
	}
	
	public void step() {
		try {
			Actionable primary = stepPrimary.element();
			Actionable secondary = stepSecondary.element();
			
		} catch (NoSuchElementException e) {
			System.out.println("Nothing in queue I am done");
		}
	}
	

}

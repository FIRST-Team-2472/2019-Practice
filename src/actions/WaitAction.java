package actions;

public class WaitAction implements Actionable{
	
	private long endTime;
	private final double lifetime;
	

	public WaitAction (double lifetime) {
		this.lifetime = lifetime;
	}
	
	@Override
	public void startAction() {
		endTime = System.currentTimeMillis() + (long)(1000 * lifetime);		
	}
	
	@Override
	public void periodic() {
	}

	@Override
	public void endAction() {
	}

	@Override
	public boolean isFinished() {
		if (System.currentTimeMillis() > endTime) {
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		return "WaitAction life:"+lifetime;
		
	}

	

}

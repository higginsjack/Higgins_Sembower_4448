// Java program to demonstrate working of
// State Design Pattern
// Java program to demonstrate working of
// State Design Pattern

interface MobileAlertState {
	public void alert(AlertStateContext ctx);
}

class AlertStateContext {
	private MobileAlertState currentState;

	public AlertStateContext()
	{
		currentState = new Vibration();
	}

	public void setState(MobileAlertState state)
	{
		currentState = state;
	}

	public void alert() { currentState.alert(this); }
}

class Vibration implements MobileAlertState {
	@Override public void alert(AlertStateContext ctx)
	{
		System.out.println(" vibration... & quot;);
	}
}

class Silent implements MobileAlertState {
	@Override public void alert(AlertStateContext ctx)
	{
		System.out.println(" silent... & quot;);
	}
}

class StatePattern {
	public static void main(String[] args)
	{
		AlertStateContext stateContext
			= new AlertStateContext();
		stateContext.alert();
		stateContext.alert();
		stateContext.setState(new Silent());
		stateContext.alert();
		stateContext.alert();
		stateContext.alert();
	}
}

// Java program to demonstrate working of
// State Design Pattern

interface MobileAlertState {
	public void alert(AlertStateContext ctx);
}

class AlertStateContext {
	private MobileAlertState currentState;

	public AlertStateContext()
	{
		currentState = null;
	}

	public void setState(MobileAlertState state)
	{
		currentState = state;
	}

	public void alert() { currentState.alert(this); }
}

class StartGame implements MobileAlertState {
	@Override public void alert(AlertStateContext ctx)
	{
		System.out.println("The game has been started");
	}
}

class QuitGame implements MobileAlertState {
	@Override public void alert(AlertStateContext ctx)
	{
		System.out.println("The game has ended");
	}
}

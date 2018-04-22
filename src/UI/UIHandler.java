package UI;

public abstract class UIHandler {
	protected Command cmd;
	
	public abstract void enableInput();
	public abstract void updateCommand(IClickable i);
	
	public void setCmd(Command cmd) {
		this.cmd = cmd;
	}
	public Command getCmd() {
		return cmd;
	}
}

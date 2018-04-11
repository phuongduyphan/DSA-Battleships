package UI.consoleUI;

public abstract class Command {
    public abstract boolean isCompleted();
    public abstract void onFinished();
}

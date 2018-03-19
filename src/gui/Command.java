package gui;

public abstract class Command {
    public abstract boolean isCompleted();
    public abstract void onFinished();
}

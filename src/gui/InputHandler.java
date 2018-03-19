package gui;

public abstract class InputHandler {
    private boolean inputState;
    private Command cmd;

    public abstract void enable();

    public abstract void disable();

    public void updateCommand(int cmdId, IClickable i) {
        switch (cmdId) {
        case 1:
            updateCommandStage1(i);
            break;
        case 2:
            updateCommandStage2(i);
            break;
        case 3:
            updateCommandStage3(i);
            break;
        case 4:
            updateCommandStage4(i);
            break;
        default:
            throw new Error("Invalid cmdId");
        }
        if(cmd.isCompleted()) cmd.onFinished();
    }

    /**
     * Just for implements purpose only.
     * Don't use.
     */
    protected abstract void updateCommandStage1(IClickable i);

    protected abstract void updateCommandStage2(IClickable i);

    protected abstract void updateCommandStage3(IClickable i);

    protected abstract void updateCommandStage4(IClickable i);
}

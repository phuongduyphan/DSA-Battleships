package UI;

import gameBoard.GameHandler;
import gameBoard.cell.Cell;
import gameBoard.player.Player;
import gameBoard.ship.Ship;
import gameBoard.weapon.Weapon;
import gameStage.app;

public abstract class InputHandler {
    protected Command cmd;
    protected app appp;
    protected GameHandler gameHandler;

    public abstract void enable();

    public abstract void disable();

	public Command getCmd() {
		return cmd;
	}

	public void setCmd(Command cmd) {
		this.cmd = cmd;
	}

	public void updateCommand(int cmdId, IClickable i) {
        switch (cmdId) {
//        case 1:
//            updateCommandStage1(i);
//            break;
//        case 2:
//            updateCommandStage2(i);
//            break;
        case 3:
            updateCommandStage3(i);
            break;
//        case 4:
//            updateCommandStage4(i);
//            break;
        default:
            throw new Error("Invalid cmdId");
        }
        if (cmd.isCompleted()) cmd.onFinished();
    }

    /**
     * Just for implements purpose only.
     * Don't use.
     */
//    protected void updateCommandStage1(IClickable i) {
//        assert (cmd instanceof CommandStage1);
//        CommandStage1 c = (CommandStage1) cmd;
//        if (i instanceof Button) c.setButton(i);
//        else throw new Error(i.getClass() + "is not a valid input for cmdstage1");
//    }

//    protected void updateCommandStage2(IClickable i) {
//        assert (cmd instanceof CommandStage2);
//        CommandStage2 c = (CommandStage2) cmd;
//        if (i instanceof Ship) c.setShip(i);
//        else if (i instanceof Cell) c.setCell(i);
//        else throw new Error(i.getClass() + "is not a valid input for cmdstage2");
//    }

    protected void updateCommandStage3(IClickable i) {
        assert (cmd instanceof CommandStage3);
        CommandStage3 c = (CommandStage3) cmd;
        if (i instanceof Player) c.setTargetPlayer((Player)i);
        else if (i instanceof Weapon) c.setWeapon((Weapon)i);
        else if (i instanceof Cell) c.setCell((Cell)i);
        else throw new Error(i.getClass() + "is not a valid input for cmdstage3");
    }

//    protected void updateCommandStage4(IClickable i) {
//        assert (cmd instanceof CommandStage4);
//        CommandStage4 c = (CommandStage4) cmd;
//        if(i instanceof Button) c.setButton(i);
//        else throw new Error(i.getClass() + "is not a valid input for cmdstage4");
//    }
}

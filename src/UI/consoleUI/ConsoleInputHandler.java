package UI.consoleUI;

import java.util.Scanner;

import UI.CommandStage2;
import UI.CommandStage3;
import UI.InputHandler;
import gameBoard.Coordinate;
import gameStage.IStage;
import gameStage.Stage2;
import gameStage.Stage3;
import gameStage.app;

public class ConsoleInputHandler extends InputHandler {
	private static ConsoleInputHandler instance;
	private Scanner scanner;

	public static ConsoleInputHandler getInstance() {
		if (instance == null)
			instance = new ConsoleInputHandler();
		return instance;
	}

	@Override
	public void enable() {
		IStage currentState = app.getInstance().getCurrentState();
		System.out.println(currentState);
		int i;
		if (false) {
			// cmd = new CommandStage1();
			// System.out.println("1 for start, 2 for exit");
			// do i = scanner.nextInt();
			// while (i != 1 && i != 2);
			// if (i == 1) updateCommand(1, btnStart);
		} else if (currentState instanceof Stage2) {
			cmd = new CommandStage2();
			/// TODO
		} else if (currentState instanceof Stage3) {
			cmd = new CommandStage3();
			while (true) {
				System.out.println("1 to choose player, 2 for weapon, 3 for cell");
				i = scanner.nextInt();
				switch (i) {
				case 1:
					System.out.println("enter player id");

					System.out.println(gameHandler.getInstance().getPlayers().get(1));
					updateCommand(3, gameHandler.getInstance().getPlayers().get(1));
					break;
				case 2:
					System.out.println("enter weapon id");
					updateCommand(3,
							gameHandler.getInstance().getCurrentPlayer().getListOfWeapon().get(scanner.nextInt()));
					break;
				case 3:
					System.out.println("enter i j");
					updateCommand(3, gameHandler.getInstance().getCurrentPlayer().getBoard()
							.getCellAt(new Coordinate(scanner.nextInt(), scanner.nextInt())));
					break;
				default:
					throw new Error("Invalid input");
				}
//				if (cmd.isCompleted()) {
//					gameHandler.getInstance().input(cmd);
//					break;
//				}
			}
			// } else if (currentState instanceof CommandStage4) {
			// cmd = new CommandStage4();
		} else
			throw new Error("Invlid app state");
	}

	@Override
	public void disable() {

	}

	private ConsoleInputHandler() {
		scanner = new Scanner(System.in);
	}
}

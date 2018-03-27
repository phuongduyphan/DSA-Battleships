package gui;

import gameState.IState;
import gameState.app;

import java.util.Scanner;

public class ConsoleInputHandler extends InputHandler {
    private ConsoleGUI instance;
    private Scanner scanner;

    public ConsoleGUI getInstance() {
        if (instance == null) instance = new ConsoleGUI();
        return instance;
    }

    @Override
    public void enable() {
        IState currentState = app.getInstance().getCurrentState();
        int i;
        if (currentState instanceof CommandStage1) {
            cmd = new CommandStage1();
            System.out.println("1 for start, 2 for exit");
            do i = scanner.nextInt();
            while (i != 1 && i != 2);
            if (i == 1) updateCommand(1, btnStart);
        } else if (currentState instanceof CommandStage2) {
            cmd = new CommandStage2();
            /// TODO
        } else if (currentState instanceof CommandStage3) {
            cmd = new CommandStage3();
            System.out.println("1 to choose player, 2 for weapon, 3 for cell");
            while (true) {
                i = scanner.nextInt();
                switch (i) {
                case 1:
                    System.out.println("enter player id");
                    updateCommand(3, gameHandler.getPlayers.get(scanner.nextInt()));
                    break;
                case 2:
                    System.out.println("enter weapon id");
                    updateCommand(3, gameHandler.getWeapons.get(scanner.nextInt()));
                    break;
                case 3:
                    System.out.println("enter cell id");
                    updateCommand(3, gameHandler.getCells.get(scanner.nextInt()));
                    break;
                default:
                    throw new Error("Invalid input");
                }
                if (cmd.isCompleted()) {
                    gameHandler.input(cmd);
                    break;
                }
            }
        } else if (currentState instanceof CommandStage4) {
            cmd = new CommandStage4();
        } else throw new Error("Invlid app state");
    }


    @Override
    public void disable() {

    }

    @Override
    protected void updateCommandStage1(IClickable i) {

    }

    @Override
    protected void updateCommandStage2(IClickable i) {

    }

    @Override
    protected void updateCommandStage3(IClickable i) {

    }

    @Override
    protected void updateCommandStage4(IClickable i) {

    }

    private ConsoleInputHandler() {
        scanner = new Scanner(System.in);
    }
}

package gui;

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
        int i;
        switch (app.state) {
        case 1:
            System.out.println("1 for start, 2 for exit");
            while ((i = scanner.nextInt()) != 1 && (i = scanner.nextInt()) != 2) ;
            if (i == 1) updateCommand(1, btnStart);
                break;
        case 2:
            break;
        case 3:
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
                case 3:
                    System.out.println("enter cell id");
                    updateCommand(3, gameHandler.getCells.get(scanner.nextInt()));
                }
            };
            break;
        case 4:
            break;
        default:
            throw new Error("Invlid app state");
        }
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

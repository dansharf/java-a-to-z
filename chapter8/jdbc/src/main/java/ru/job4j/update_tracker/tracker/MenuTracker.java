package ru.job4j.update_tracker.tracker;


import ru.job4j.update_tracker.CreateDB;
import ru.job4j.update_tracker.action.AddNewTask;
import ru.job4j.update_tracker.action.AddComment;
import ru.job4j.update_tracker.action.EditTask;
import ru.job4j.update_tracker.action.RemoveTask;
import ru.job4j.update_tracker.action.RemoveComment;
import ru.job4j.update_tracker.action.ShowAllCommentToTask;
import ru.job4j.update_tracker.action.ShowAllTask;
import ru.job4j.update_tracker.action.Action;
import ru.job4j.update_tracker.action.ExitTrackerProgram;
import ru.job4j.update_tracker.action.FilterByCoincidence;
import ru.job4j.update_tracker.action.FilterTaskByName;
import ru.job4j.update_tracker.input.Input;
import ru.job4j.update_tracker.view.ConsoleView;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for tracker management.
 */
public class MenuTracker {

    /**
     * Actions that are provided to the user.
     */
    private List<Action> actions;

    /**
     * Tracker.
     */
    private final Tracker tracker;

    /**
     * CreateDB.
     */
    private final CreateDB createDB;

    /**
     * User input.
     */
    private final Input inputData;

    /**
     * Constructor.
     *
     * @param tracker   tracker.
     * @param inputData user input.
     * @param createDB  createDB.
     */
    public MenuTracker(final Tracker tracker, final Input inputData, final CreateDB createDB) {
        this.tracker = tracker;
        this.inputData = inputData;
        this.createDB = createDB;
        this.actions = new ArrayList<>();
    }

    /**
     * Fills an array of actions, actions available in the tracker.
     */
    public void fillAction() {
        this.addAction(new AddNewTask("1", "Add task"));
        this.addAction(new RemoveTask("2", "Remove Task"));
        this.addAction(new EditTask("3", "Edit Task"));
        this.addAction(new AddComment("4", "Add Comment"));
        this.addAction(new RemoveComment("5", "Remove Comment"));
        this.addAction(new ShowAllTask("6", "Show All Task"));
        this.addAction(new ShowAllCommentToTask("7", "Show All Comment Task"));
        this.addAction(new FilterTaskByName("8", "Filtered Task By Name"));
        this.addAction(new FilterByCoincidence("9", "Filter by coincidence"));
        this.addAction(new ExitTrackerProgram("0", "Exit Tracker"));
    }

    /**
     * Add action to tracker.
     *
     * @param action action.
     * @return true.
     */
    public boolean addAction(final Action action) {
        return this.actions.add(action);
    }

    /**
     * Displays menu items available to the user.
     */
    public void showMenu() {
        StringBuilder sb = new StringBuilder();
        for (Action action : actions) {
            sb.append(action.showItem()).append(System.getProperty("line.separator"));
        }
        new ConsoleView().execute(sb.toString());
    }

    /**
     * Selects the action based on the user's choice.
     *
     * @param value Number of action to be performed.
     */
    public void select(final int value) {
        for (Action action : actions) {
            if (Integer.parseInt(action.getId()) == value) {
                action.execute(tracker, inputData);
            }
        }
    }

    /**
     * Get.
     * @return list.
     */
    public List<Action> getActions() {
        return actions;
    }

    /**
     * Get.
     *
     * @return tracker.
     */
    public Tracker getTracker() {
        return tracker;
    }

    /**
     * Get.
     *
     * @return createDB.
     */
    public CreateDB getCreateDB() {
        return createDB;
    }
}
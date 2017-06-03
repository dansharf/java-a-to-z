package ru.job4j.update_tracker.action;

import ru.job4j.update_tracker.input.Input;
import ru.job4j.update_tracker.tracker.Tracker;
import ru.job4j.update_tracker.view.ConsoleView;

/**
 * Stub action.
 *
 * @author Alexey Voronin.
 * @since 03.06.2017.
 */
public class StubAction extends BaseAction {

    /**
     * Constructor.
     *
     * @param id   action id.
     * @param name action name.
     */
    public StubAction(String id, String name) {
        super(id, name);
    }

    @Override
    public void execute(Tracker tracker, Input inputData) {
        new ConsoleView().execute(String.format("WORK!%s", System.getProperty("line.separator")));
    }
}
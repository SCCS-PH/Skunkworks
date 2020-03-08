package com.hccs.skunkworks.task;

import com.hccs.skunkworks.model.TaskBean;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DCSalenga
 */
public enum TaskController {
    INSTANCE;

    private final List<TaskBean> works = new ArrayList<>();

    public List<TaskBean> getAllDirtyTasks() {
        if (!works.isEmpty()) {
            return works;
        }

        TaskBean dw = new TaskBean();
        dw.setTaskName("Sample A");
        dw.setTaskValue(1);
        works.add(dw);

        dw = new TaskBean();
        dw.setTaskName("Sample B");
        dw.setTaskValue(2);
        works.add(dw);

        dw = new TaskBean();
        dw.setTaskName("Sample C");
        dw.setTaskValue(4);
        works.add(dw);

        dw = new TaskBean();
        dw.setTaskName("Sample D");
        dw.setTaskValue(8);
        works.add(dw);

        dw = new TaskBean();
        dw.setTaskName("Sample E");
        dw.setTaskValue(0x10);
        works.add(dw);

        dw = new TaskBean();
        dw.setTaskName("Sample F");
        dw.setTaskValue(0x20);
        works.add(dw);

        return works;
    }

}

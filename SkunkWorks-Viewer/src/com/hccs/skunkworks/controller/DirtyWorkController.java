package com.hccs.skunkworks.controller;

import com.hccs.skunkworks.model.DirtyWorkBean;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DCSalenga
 */
public enum DirtyWorkController {
    INSTANCE;

    private final List<DirtyWorkBean> works = new ArrayList<>();

    public List<DirtyWorkBean> getAllDirtyWorks() {
        if (!works.isEmpty()) {
            return works;
        }

        DirtyWorkBean dw = new DirtyWorkBean();
        dw.setdWName("Sample A");
        dw.setdWValue(1);
        works.add(dw);

        dw = new DirtyWorkBean();
        dw.setdWName("Sample B");
        dw.setdWValue(2);
        works.add(dw);

        dw = new DirtyWorkBean();
        dw.setdWName("Sample C");
        dw.setdWValue(4);
        works.add(dw);

        dw = new DirtyWorkBean();
        dw.setdWName("Sample D");
        dw.setdWValue(8);
        works.add(dw);

        dw = new DirtyWorkBean();
        dw.setdWName("Sample E");
        dw.setdWValue(0x10);
        works.add(dw);

        dw = new DirtyWorkBean();
        dw.setdWName("Sample F");
        dw.setdWValue(0x20);
        works.add(dw);

        return works;
    }

}

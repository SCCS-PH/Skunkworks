package com.hccs.skunkworks.jpa.controllers;

import com.hccs.skunkworks.SkunkWork;
import com.hccs.skunkworks.jpa.models.CommandBean;
import java.util.List;

/**
 *
 * @author DCSalenga
 */
public class CommandQuries {
    private final CommandBeanJpaController COMMAND_CONTROLLER = new CommandBeanJpaController(
            new SkunkWork().getEMFactory());

    public boolean save(CommandBean bean) {
        if (bean.getCommandid()== null) {
            return COMMAND_CONTROLLER.create(bean);
        } else {
            return COMMAND_CONTROLLER.edit(bean);
        }
    }

    public List<CommandBean> getAllRequestBean(boolean all) throws Exception {
        return all ? COMMAND_CONTROLLER.findAllCommands()
                : COMMAND_CONTROLLER.findAllCommands();
    }
}

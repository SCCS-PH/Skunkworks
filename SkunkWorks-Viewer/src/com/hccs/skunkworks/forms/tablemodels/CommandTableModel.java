package com.hccs.skunkworks.forms.tablemodels;

import com.hccs.skunkworks.jpa.models.CommandBean;
import java.util.Date;
import java.util.List;

public class CommandTableModel extends ActivatorAbstractTableModel<CommandBean> {

    public void addBeansToModel(List<CommandBean> regs) {

        regs.forEach((reg) -> {
            data.add(reg);
        });
    }

    public void addBeanlsToModelOrder(List<CommandBean> regs) {
        for (int x = (regs.size() - 1); x >= 0; x--) {
            data.add(regs.get(x));
        }
    }

    @Override
    public Object getDataAt(int rowIndex, int columnIndex) {
        if (data != null && data.size() > 0 && (rowIndex >= 0 && rowIndex <= data.size() - 1)) {
            CommandBean reg = data.get(rowIndex);
            Date date;

            if (reg != null) {
                switch (columnIndex) {
                    case 0:
                        return reg.getName();
                    case 1:
                        return reg.getExtension();
                    case 2:
                        return reg.getDescription();
                    case 3:
                        return reg.getActive();
                }
            }
        }
        return null;
    }

    private String getBold(String value) {
        return "<html><b>" + value + "</b></html>";
    }

    @Override
    public String[] getColumnNames() {
        return new String[]{
            getBold("Name"),
            getBold("Extension"),
            getBold("Description"),
            getBold("Active")
        };
    }

    @Override
    public Class[] getColumnTypes() {
        return new Class[]{
            String.class,
            String.class,
            String.class,
            String.class
        };
    }
}

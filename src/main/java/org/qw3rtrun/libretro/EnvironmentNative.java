package org.qw3rtrun.libretro;

import java.util.Collection;
import java.util.List;

public class EnvironmentNative implements Environment {

    @Override
    public native Variable getVariable(String key);

    @Override
    public void setVariable(Variable variable) {

    }

    @Override
    public void setVariables(Collection<Variable> variables) {

    }

    @Override
    public boolean isVariablesUpdated() {
        return false;
    }

    @Override
    public void setSupportNoGame(boolean isSupportNoGame) {

    }

    @Override
    public LogCallback getLogInterface() {
        return null;
    }

    @Override
    public void setSubsystemInfo(Collection<SubsystemInfo> types) {

    }

    @Override
    public void setControllerInfo(List<PortInfo> info) {

    }

    @Override
    public void call(int cmd, Object data) {

    }
}

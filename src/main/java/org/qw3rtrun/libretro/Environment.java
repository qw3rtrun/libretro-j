package org.qw3rtrun.libretro;


import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;

public interface Environment {

    Variable getVariable(String key);
    void setVariable(Variable variable);
    void setVariables(Collection<Variable> variables);
    boolean isVariablesUpdated();

    void setSupportNoGame(boolean isSupportNoGame);

    LogCallback getLogInterface();

    void setSubsystemInfo(Collection<SubsystemInfo> types);

    void setControllerInfo(List<PortInfo> info);

    void call(int cmd, Object data);

}

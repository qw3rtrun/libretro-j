package org.qw3rtrun.libretro;

import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class EnvironmentNative implements Environment {

    @Override
    public native Variable getVariable(String key);

    @Override
    public native void setVariables(Collection<Variable> variables);

    @Override
    public native boolean isVariablesUpdated();


    @Override
    public native LogCallback getLogInterface() ;

    @Override
    public native void setControllerInfo(List<PortInfo> info);

    @Override
    public Optional<ByteBuffer> getCurrentSoftwareFrameBuffer() {
        return Optional.ofNullable(getCurrentSoftwareFrameBuffer0());
    }

    private native ByteBuffer getCurrentSoftwareFrameBuffer0();

    @Override
    public boolean setPixelFormat(PixelFormat pixelFormat) {
        Objects.requireNonNull(pixelFormat);
        return setPixelFormat0(pixelFormat.getCode());
    }

    private native boolean setPixelFormat0(int code);

    @Override
    public native void setInputDescriptors(List<InputDescriptor> descriptors);

    @Override
    public native void setKeyboardCallback(KeyboardCallback callback);
}

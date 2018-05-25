package org.qw3rtrun.libretro;


import java.nio.ByteBuffer;
import java.util.*;

public interface Environment {

    /* const enum retro_pixel_format * --
     * Sets the internal pixel format used by the implementation.
     * The default pixel format is RETRO_PIXEL_FORMAT_0RGB1555.
     * This pixel format however, is deprecated (see enum retro_pixel_format).
     * If the call returns false, the frontend does not support this pixel
     * format.
     *
     * This function should be called inside retro_load_game() or
     * retro_get_system_av_info().
     */
    boolean setPixelFormat(PixelFormat pixelFormat);

    /* const struct retro_input_descriptor * --
     * Sets an array of retro_input_descriptors.
     * It is up to the frontend to present this in a usable way.
     * The array is terminated by retro_input_descriptor::description
     * being set to NULL.
     * This function can be called at any time, but it is recommended
     * to call it as early as possible.
     */
    void setInputDescriptors(List<InputDescriptor> descriptors);

    /* const struct retro_keyboard_callback * --
     * Sets a callback function used to notify core about keyboard events.
     */
    void setKeyboardCallback(KeyboardCallback callback);

    /* struct retro_variable * --
     * Interface to acquire user-defined information from environment
     * that cannot feasibly be supported in a multi-system way.
     * 'key' should be set to a key which has already been set by
     * SET_VARIABLES.
     * 'data' will be set to a value or NULL.
     */
    Variable getVariable(String key);

    /* const struct retro_variable * --
     * Allows an implementation to signal the environment
     * which variables it might want to check for later using
     * GET_VARIABLE.
     * This allows the frontend to present these variables to
     * a user dynamically.
     * This should be called as early as possible (ideally in
     * retro_set_environment).
     *
     * 'data' points to an array of retro_variable structs
     * terminated by a { NULL, NULL } element.
     * retro_variable::key should be namespaced to not collide
     * with other implementations' keys. E.g. A core called
     * 'foo' should use keys named as 'foo_option'.
     * retro_variable::value should contain a human readable
     * description of the key as well as a '|' delimited list
     * of expected values.
     *
     * The number of possible options should be very limited,
     * i.e. it should be feasible to cycle through options
     * without a keyboard.
     *
     * First entry should be treated as a default.
     *
     * Example entry:
     * { "foo_option", "Speed hack coprocessor X; false|true" }
     *
     * Text before first ';' is description. This ';' must be
     * followed by a space, and followed by a list of possible
     * values split up with '|'.
     *
     * Only strings are operated on. The possible values will
     * generally be displayed and stored as-is by the frontend.
     */

    void setVariables(Collection<Variable> variables);

    default void setVariable(Variable variable) {
        Objects.requireNonNull(variable);
        setVariables(Collections.singleton(variable));
    }

    boolean isVariablesUpdated();

    //void setSupportNoGame(boolean isSupportNoGame);

    /* struct retro_log_callback * --
     * Gets an interface for logging. This is useful for
     * logging in a cross-platform way
     * as certain platforms cannot use use stderr for logging.
     * It also allows the frontend to
     * show logging information in a more suitable way.
     * If this interface is not used, libretro cores should
     * log to stderr as desired.
     */
    LogCallback getLogInterface();

    //void setSubsystemInfo(Collection<SubsystemInfo> types);

    /* const struct retro_controller_info * --
     * This environment call lets a libretro core tell the frontend
     * which controller types are recognized in calls to
     * retro_set_controller_port_device().
     *
     * Some emulators such as Super Nintendo
     * support multiple lightgun types which must be specifically
     * selected from.
     * It is therefore sometimes necessary for a frontend to be able
     * to tell the core about a special kind of input device which is
     * not covered by the libretro input API.
     *
     * In order for a frontend to understand the workings of an input device,
     * it must be a specialized type
     * of the generic device types already defined in the libretro API.
     *
     * Which devices are supported can vary per input port.
     * The core must pass an array of const struct retro_controller_info which
     * is terminated with a blanked out struct. Each element of the struct
     * corresponds to an ascending port index to
     * retro_set_controller_port_device().
     * Even if special device types are set in the libretro core,
     * libretro should only poll input based on the base input device types.
     */
    void setControllerInfo(List<PortInfo> info);

    Optional<ByteBuffer> getCurrentSoftwareFrameBuffer();
}

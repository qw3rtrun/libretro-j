import org.qw3rtrun.libretro.api.RetroInitializer;
import org.qw3rtrun.libretro.stub.RetroInitializerStub;

module org.qw3rtrun.libretro.stub {
    requires org.qw3rtrun.libretro.api;

    exports org.qw3rtrun.libretro.stub;

    provides RetroInitializer with RetroInitializerStub;
}
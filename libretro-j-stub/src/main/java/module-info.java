import org.qw3rtrun.libretro.api.GameImplementation;
import org.qw3rtrun.libretro.stub.StubGame;

module org.qw3rtrun.libretro.stub {
    requires org.qw3rtrun.libretro.api;

    exports org.qw3rtrun.libretro.stub;

    provides GameImplementation with StubGame;
}
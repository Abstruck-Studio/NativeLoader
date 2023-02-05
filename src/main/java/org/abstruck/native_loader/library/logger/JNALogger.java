package org.abstruck.native_loader.library.logger;

import com.sun.jna.Callback;
import com.sun.jna.Structure;
import org.abstruck.native_loader.NativeLoader;

/**
 * @author Goulixiaoji
 */
@Structure.FieldOrder({"info", "warn", "error", "debug", "trace"})
public class JNALogger extends Structure {
    public Info info;
    public Warn warn;
    public Error error;
    public Debug debug;
    public Trace trace;

    public JNALogger() {
        this.info = new InfoClass();
        this.warn = new WarnClass();
        this.error = new ErrorClass();
        this.debug = new DebugClass();
        this.trace = new TraceClass();
    }

    public interface Info extends Callback {
        void info(String str);
    }

    public interface Warn extends Callback {
        void warn(String str);
    }

    public interface Error extends Callback {
        void error(String str);
    }

    public interface Debug extends Callback {
        void debug(String str);
    }

    public interface Trace extends Callback {
        void trace(String str);
    }

    public static class InfoClass implements Info {
        @Override
        public void info(String str) {
            NativeLoader.LOGGER.info("[Native] " + str);
        }
    }

    public static class WarnClass implements Warn {
        @Override
        public void warn(String str) {
            NativeLoader.LOGGER.warn("[Native] " + str);
        }
    }

    public static class ErrorClass implements Error {
        @Override
        public void error(String str) {
            NativeLoader.LOGGER.error("[Native] " + str);
        }
    }

    public static class DebugClass implements Debug {
        @Override
        public void debug(String str) {
            NativeLoader.LOGGER.debug("[Native] " + str);
        }
    }

    public static class TraceClass implements Trace {
        @Override
        public void trace(String str) {
            NativeLoader.LOGGER.trace("[Native] " + str);
        }
    }
}

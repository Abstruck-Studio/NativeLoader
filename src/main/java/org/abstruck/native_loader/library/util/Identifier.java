package org.abstruck.native_loader.library.util;

import com.sun.jna.Structure;

/**
 * @author Goulixiaoji
 */
@Structure.FieldOrder({"nameSpace", "path"})
public class Identifier extends Structure {
    public Identifier(String nameSpace, String path) {
        this.nameSpace = nameSpace;
        this.path = path;
    }
    public String nameSpace;
    public String path;
}

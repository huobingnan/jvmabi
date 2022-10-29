package ano.nunu.jvmabi.constant;

import ano.nunu.jvmabi.JvmClassFileConstantEnum;
import ano.nunu.jvmabi.reader.IByteCodeReader;

import java.io.Serializable;

public final class ConstantMethodHandle implements Serializable, IJvmConstant {

    private short referenceKind;
    private short referenceIndex;

    public ConstantMethodHandle() {}

    public ConstantMethodHandle(short referenceKind, short referenceIndex) {
        this.referenceKind = referenceKind;
        this.referenceIndex = referenceIndex;
    }

    public ConstantMethodHandle(IByteCodeReader reader) { read(reader); }

    @Override
    public byte getTag() { return JvmClassFileConstantEnum.METHOD_HANDLE_INFO; }

    @Override
    public void read(IByteCodeReader reader) {
        referenceKind = reader.readU2();
        referenceIndex = reader.readU2();
    }

    public short getReferenceKind() { return referenceKind; }

    public short getReferenceIndex() { return referenceIndex; }

    @Override
    public String toString() {
        return "<CONSTANT_Methodhandle_Info, " + referenceKind + " #" + referenceIndex + ">";
    }
}

package ano.nunu.jvmabi.constant;

import ano.nunu.jvmabi.JvmClassFileConstantEnum;
import ano.nunu.jvmabi.reader.IByteCodeReader;

import java.io.Serializable;


public final class ConstantModule implements Serializable, IJvmConstant {

    private short nameIndex; // 指向常量池中一个CONSTANT_Utf8_Info

    public ConstantModule() {}

    public ConstantModule(short nameIndex) { this.nameIndex = nameIndex; }

    public ConstantModule(IByteCodeReader reader) { read(reader); }

    @Override
    public byte getTag() { return JvmClassFileConstantEnum.MODULE_INFO; }

    @Override
    public void read(IByteCodeReader reader) { nameIndex = reader.readU2(); }

    public short getNameIndex() { return nameIndex; }

    @Override
    public String toString() {
        return "<CONSTANT_Module_Info, #" + nameIndex + ">";
    }
}

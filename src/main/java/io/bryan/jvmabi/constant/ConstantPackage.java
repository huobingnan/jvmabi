package io.bryan.jvmabi.constant;

import io.bryan.jvmabi.JvmClassFileConstantEnum;
import io.bryan.jvmabi.reader.IByteCodeReader;

import java.io.Serializable;

public final class ConstantPackage implements Serializable, IJvmConstant {

    private short nameIndex; // 指向常量池中一个CONSTANT_Utf8_Info

    public ConstantPackage() {}

    public ConstantPackage(short nameIndex) { this.nameIndex = nameIndex; }

    public ConstantPackage(IByteCodeReader reader) { read(reader); }

    @Override
    public byte getTag() { return JvmClassFileConstantEnum.PACKAGE_INFO; }

    @Override
    public void read(IByteCodeReader reader) { nameIndex = reader.readU2(); }

    public short getNameIndex() { return nameIndex; }
}
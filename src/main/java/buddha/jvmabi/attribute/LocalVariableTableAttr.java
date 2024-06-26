package buddha.jvmabi.attribute;

import buddha.jvmabi.AttributeType;
import buddha.jvmabi.annotation.U4;
import buddha.jvmabi.reader.IByteCodeReader;
import buddha.jvmabi.ClassFileConstantPool;

import java.io.Serializable;

// 本地变量表
public final class LocalVariableTableAttr implements Serializable, IJvmAttribute {

    private @U4 int length;
    private LocalVariableInfo[] localVariableTable;

    public LocalVariableTableAttr() {}

    public LocalVariableTableAttr(ClassFileConstantPool pool, IByteCodeReader reader) { read(pool, reader); }

    @Override
    public AttributeType type() { return AttributeType.LOCAL_VARIABLE_TABLE; }

    @Override
    public void read(ClassFileConstantPool pool, IByteCodeReader reader) {
        length = reader.readU4();
        localVariableTable = new LocalVariableInfo[reader.readU2()];
        for (int i = 0; i < localVariableTable.length; i++) {
            final LocalVariableInfo localVariableInfo = new LocalVariableInfo();
            localVariableInfo.setStartPc(reader.readU2());
            localVariableInfo.setLength(reader.readU2());
            localVariableInfo.setNameIndex(reader.readU2());
            localVariableInfo.setDescriptorIndex(reader.readU2());
            localVariableInfo.setIndex(reader.readU2());
            localVariableTable[i] = localVariableInfo;
        }
    }

    public LocalVariableInfo get(int index) { return localVariableTable[index]; }

    public int length() { return localVariableTable.length; }

    public int getAttrLength() { return length; }
}

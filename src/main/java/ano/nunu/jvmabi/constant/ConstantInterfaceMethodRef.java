package ano.nunu.jvmabi.constant;

import ano.nunu.jvmabi.JvmClassFileConstantEnum;
import ano.nunu.jvmabi.reader.IByteCodeReader;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public final class ConstantInterfaceMethodRef implements Serializable, IJvmConstant {

    private short classIndex;       // 指向常量池中的一个CONSTANT_Class_Info
    private short nameAndTypeIndex; // 指向常量池中的一个CONSTANT_NameAndType_Info

    public ConstantInterfaceMethodRef(IByteCodeReader reader) { read(reader); }

    @Override
    public byte getTag() { return JvmClassFileConstantEnum.INTERFACE_METHOD_REF_INFO; }

    @Override
    public void read(IByteCodeReader reader) {
        classIndex = reader.readU2();
        nameAndTypeIndex = reader.readU2();
    }

    @Override
    public String toString() {
        return "<CONSTANT_Interfacemethod_Info, #" + classIndex + " #" + nameAndTypeIndex + ">";
    }
}

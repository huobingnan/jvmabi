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
public final class ConstantPackage implements Serializable, IJvmConstant {
    private short nameIndex; // 指向常量池中一个CONSTANT_Utf8_Info

    public ConstantPackage(IByteCodeReader reader) { read(reader); }

    @Override
    public byte getTag() { return JvmClassFileConstantEnum.PACKAGE_INFO; }

    @Override
    public void read(IByteCodeReader reader) { nameIndex = reader.readU2(); }

    @Override
    public String toString() {
        return "<CONSTANT_Package_Info, #" + nameIndex + ">";
    }
}

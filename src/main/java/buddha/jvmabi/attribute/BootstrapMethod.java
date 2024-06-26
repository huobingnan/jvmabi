package buddha.jvmabi.attribute;

import buddha.jvmabi.annotation.U1;
import buddha.jvmabi.annotation.U2;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BootstrapMethod {
    private @U2 int methodRef;
    private @U2 int[] args; // args type which will depict in constant pool.
}

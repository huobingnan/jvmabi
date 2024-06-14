package buddha.javapx.abi.attribute.stkmaptbl;

import buddha.javapx.abi.annotation.U1;
import buddha.javapx.abi.annotation.U2;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ChopFrame implements IStackMapFrame {
    private @U1 int tag;
    private @U2 int offsetDelta;

    @Override
    public int tag() { return tag; }
}
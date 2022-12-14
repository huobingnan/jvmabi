package ano.nunu.jvmabi;

import ano.nunu.jvmabi.attribute.IJvmAttribute;
import ano.nunu.jvmabi.field.FieldItem;


public class JvmClassFileFieldTable {
    private final FieldItem[] fields;
    private int appendCursor;

    public JvmClassFileFieldTable(int count) {
        fields = new FieldItem[count];
        appendCursor = 0;
    }

    public int length() { return fields.length; }

    public void append(FieldItem item) { fields[appendCursor++] = item; }

    public FieldItem get(int idx) { return fields[idx]; }

}

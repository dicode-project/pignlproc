package pignlproc.helpers;

import org.apache.pig.FilterFunc;
import org.apache.pig.data.Tuple;

import java.io.IOException;

/**
 * Filters surface forms that contain 4-byte characters when encoded in UTF-8.
 */
public class Has4ByteUtf8Chars extends FilterFunc {

    @Override
    public Boolean exec(Tuple tuple) throws IOException {
        String s = tuple.get(0).toString();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int l = String.valueOf(c).getBytes("UTF-8").length;
            if (l > 3) {
                return true;
            }
        }
        return false;
    }

}

package exe.controller;

import java.util.regex.*;
import exe.view.*;

public class menuvad {
    public static boolean addman(String na, String ma, String pa, String fn) {
        String rx = "^[A-Za-z]{3,}";
        Pattern p = Pattern.compile(rx);
        Matcher m = p.matcher(na);
        String mail = "^[a-zA-Z0-9_+&-]+(?:\\." + "[a-zA-Z0-9_+&-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(mail);
        Matcher mai = pat.matcher(ma);
        String pass = "^[A-Za-z0-9]{6,}";
        Pattern pas = Pattern.compile(pass);
        Matcher mat = pas.matcher(pa);
        if (!m.matches() || na == null) {
            return false;
        } else if (!mai.matches() || ma == null)
            return false;
        else if (!pa.matches(pass) || pa == null)
            return false;
        else {
            return true;
        }
    }

    public static boolean manid(String mail) {
        java.lang.String m = "^[a-zA-Z0-9_+&-]+(?:\\." + "[a-zA-Z0-9_+&-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
                + "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(m);

        if (mail == null)
            return false;
        if (pat.matcher(mail).matches()) {
            return true;
        }
        return false;
    }
}

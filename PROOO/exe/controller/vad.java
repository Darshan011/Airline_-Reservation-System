package exe.controller;

import java.util.regex.*;

import exe.model.signsetup;

public class vad {
    public static String vadIn(String mail, String pass) {
        java.lang.String m = "^[a-zA-Z0-9_+&-]+(?:\\." + "[a-zA-Z0-9_+&-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
                + "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(m);

        if (mail == null)
            return null;
        if (pat.matcher(mail).matches()) {
            return signsetup.signin(mail, pass);
        }
        return null;
    }

    public static String vadUp(String na, String ma, String pa) {
        String rx = "^[A-Za-z]{3,}";
        Pattern p = Pattern.compile(rx);
        Matcher m = p.matcher(na);
        String mail = "^[a-zA-Z0-9_+&-]+(?:\\." + "[a-zA-Z0-9_+&-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(mail);
        Matcher mai = pat.matcher(ma);
        String pass = "^[A-Za-z0-9@_*]+{6,}";
        Pattern pas = Pattern.compile(pass);
        Matcher mat = pas.matcher(pa);
        if (!m.matches() || na == null) {
            return "--Enter Valid Name--";
        } else if (!mai.matches() || ma == null)
            return "--Enter Valid Mail--";
        else if (!pa.matches(pass) || pa == null)
            return "--Password Shoud be Atleast 8 Characters--";
        else {
            String ret = signsetup.signup(na, ma, pa);
            return ret;
        }
    }
}

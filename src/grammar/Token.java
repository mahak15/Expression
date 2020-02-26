package grammar;

import exception.CalException;

public class Token {

    String type;
    String data;

    public Token(String name, String value) {
        type = name;
        data = value;
    }

    public void buildToken(char c) {
        data += c;
    }

    public String tokToString() {
       // throw new CalException.TokenException ( this.type ,this.data );
        return "<" + type + "," + data + ">";
    }

    public Boolean tokCheckVal(String str) {
        if (data.equals(str)) return true;
        else return false;
    }

    public Boolean tokCheckType(String str) {
        if (type.equals(str)) return true;
        else return false;
    }
    public String getType()
    {
        return type;
    }

    public String getValue()
    {
        return data;
    }

}



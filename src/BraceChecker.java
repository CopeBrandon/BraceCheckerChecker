import java.util.ArrayList;
public class BraceChecker implements BraceCheckable{
    String name = "BraceChecker.isValid()";
    public boolean isValid(String braces) {
        int len = braces.length();
        if(len==0) return true;
        if(len%2!=0 || len==1) return false;

        int i = len-1;
        while(braces.length()>0){
            i--;
            if(braces.length()==2){
                return isOpposite(braces.charAt(0), braces.charAt(1));
            }

            char open = braces.charAt(i);
            char close = braces.charAt(i+1);

            if(isOpposite(open, close) && isOpening(open)){
                braces = braces.substring(0, i) + braces.substring(i+2);
                i=braces.length()-1;
            } else if(isOpening(open)){
                return false;
            }
        }
        return true;
    }

    @Override
    public String getName() {
        return name;
    }

    boolean isOpposite(char o, char c){
        if(c==']'){
            if(o=='[') return true;
        } else if(c=='}'){
            if(o=='{') return true;
        } else if(c==')'){
            if(o=='(') return true;
        }
        return false;
    }
    boolean isClosing(char c){
        return c==']' || c=='}' || c==')' ? true : false;
    }
    boolean isOpening(char o){
        return o=='[' || o=='{' || o=='(' ? true : false;
    }
}
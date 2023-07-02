import java.util.ArrayList;
public class BraceChecker implements BraceCheckable{
    String name = "BraceChecker.isValid()";
    @Override
    public boolean isValid(String braces){
        int len = braces.length();
        if(len==0) return true;
        if(len%2!=0 || len==1) return false;
        int i=0;

        while(braces.length()>0){
            char c1 = braces.charAt(i);
            char c2 = braces.charAt(i+1);

            if(i+3>braces.length()){
                if(isOpposite(c1,c2)){
                    return true;
                }
                return false;
            }

            if(isOpposite(c1, c2)){
                braces = braces.substring(0,i) + braces.substring(i+2);
                i = i <= 0 ? 0 : i-2;
            }
            i++;
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
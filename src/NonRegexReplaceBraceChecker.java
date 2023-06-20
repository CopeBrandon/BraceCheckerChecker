public class NonRegexReplaceBraceChecker implements BraceCheckable{
    public String getName(){
        return "NonRegexReplaceBraceChecker.isValid()";
    }
    public boolean isValid(String braces) {
        int lengthOfBraces = braces.length();
        for(int i = 0; i < lengthOfBraces; i++){
            braces = braces.replace("{}", "").replace("[]", "").replace("()", "");
        }
        return braces.isEmpty();
    }
}

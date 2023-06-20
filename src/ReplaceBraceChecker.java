public class ReplaceBraceChecker implements BraceCheckable{
    @Override
    public String getName() {
        return "ReplaceBraceChecker.isValid()";
    }
    public boolean isValid(String braces) {
        String b = braces;
        for(int i=0;i<braces.length()/2;i++)
        {
            b = b.replaceAll("\\(\\)", "");
            b = b.replaceAll("\\[\\]", "");
            b = b.replaceAll("\\{\\}", "");
            if(b.length() == 0)
                return true;
        }
        return false;
    }
}

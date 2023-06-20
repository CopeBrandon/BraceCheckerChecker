public class RecursiveBraceChecker implements BraceCheckable{
    public String getName(){
        return "RecursiveBraceChecker.isValid()";
    }
    public boolean isValid(String s) {
        String lastIteration = s;
        String currentIteration = s;
        do {
            lastIteration = currentIteration;
            currentIteration = lastIteration.replace("[]" , "").replace("{}", "").replace("()" , "");
        } while(currentIteration.length() < lastIteration.length());
        return currentIteration.equals("");
    }
}

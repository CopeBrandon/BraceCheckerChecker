import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        BraceChecker braceChecker = new BraceChecker();
        StackBraceChecker stackBraceChecker = new StackBraceChecker();
        ReplaceBraceChecker replaceBraceChecker = new ReplaceBraceChecker();
        RecursiveBraceChecker recursiveBraceChecker = new RecursiveBraceChecker();
        NonRegexReplaceBraceChecker nonRegexReplaceBraceChecker = new NonRegexReplaceBraceChecker();

        ArrayList<BraceCheckable> checkerList = new ArrayList<>();
        checkerList.add(braceChecker); checkerList.add(stackBraceChecker); checkerList.add(replaceBraceChecker); checkerList.add(recursiveBraceChecker); checkerList.add(nonRegexReplaceBraceChecker);

        HashMap<String, Boolean> testsAndResults = new HashMap<String, Boolean>();
        testsAndResults.put("()", true);
        testsAndResults.put("[(])", false);
        testsAndResults.put("[", false);
        testsAndResults.put("{[()]}", true);

        for(int i=0;i<checkerList.size(); i++){
            multiTestRunner(testsAndResults, checkerList.get(i));
            testRunner(testsAndResults, checkerList.get(i));
        }

    }
    static void multiTestRunner(HashMap<String, Boolean> testsAndResults, BraceCheckable braceChecker){
        float nanoConversion = (float) Math.pow(10, 9);
        float start = System.nanoTime();
        for(int i=0; i<10000000; i++) { //10,000,000 attempts
            boolean[] results = checker(braceChecker, testsAndResults);
        }
        float end = System.nanoTime();
        float elapsedTime = end - start;
        System.out.println("Start: " + start + " End: " + end + " elapsedTime: " + elapsedTime);
    }
    static void testRunner(HashMap<String, Boolean> testsAndResults, BraceCheckable braceChecker){
        boolean[] results = checker(braceChecker, testsAndResults);
        printResults(braceChecker.getName(), testsAndResults, results);
    }
    static boolean[] checker(BraceCheckable obj,  HashMap<String, Boolean> testMap){
        boolean[] results = new boolean[testMap.size()];
        Object[] tests = testMap.keySet().toArray();
        for(int i=0; i< tests.length; i++) {
            results[i] = obj.isValid(tests[i].toString());
        }
        return results;
    }
    static void printResults(String testName, HashMap<String, Boolean> testMap, boolean[] results){
        Object[] tests = testMap.keySet().toArray();
        Object[] expectedResults = testMap.values().toArray(new Boolean[0]);
        for(int i=0; i<results.length; i++){
            System.out.println(testName + " " + tests[i] + " \nEXPECTED: " + expectedResults[i].toString() + " RESULT: " + results[i]);
        }
    }
}
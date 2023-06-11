import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        BraceChecker braceChecker = new BraceChecker();
        HashMap<String, Boolean> testsAndResults = new HashMap<String, Boolean>();
        testsAndResults.put("()", true);
        testsAndResults.put("[(])", false);
        testsAndResults.put("[", false);
        testsAndResults.put("{[()]}", true);

        testRunner(testsAndResults, braceChecker);
    }
    static void testRunner(HashMap<String, Boolean> testsAndResults, BraceCheckable braceChecker){
        float start = System.nanoTime();
        float nanoConversion = (float) Math.pow(10, 9);
        boolean[] results = checker(braceChecker, testsAndResults);
        printResults(braceChecker.getName(), testsAndResults, results);
        float end = System.nanoTime();
        float elapsedTime = end - start;
        System.out.println("Start: " + start + " End: " + end + "elapsedTime: " + elapsedTime);
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
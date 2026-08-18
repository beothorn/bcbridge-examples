package br.com.isageek.bcbridge.example;

public final class App {

    public App() {
    }

    public static void main(String[] args) {
        App app = new App();
        System.out.println("===============");
        app.defaultMatcherOriginal("Hello from code");
        System.out.println("===============");
        app.namedOriginal("Hello from code");
        System.out.println("===============");
        app.namedIgnoreCaseOriginal("Hello from code");
        System.out.println("===============");
        app.nameStartsWithOriginal("Hello from code");
        System.out.println("===============");
        app.nameStartsWithIgnoreCaseOriginal("Hello from code");
        System.out.println("===============");
        app.nameEndsWithOriginal("Hello from code");
        System.out.println("===============");
        app.nameEndsWithIgnoreCaseOriginal("Hello from code");
        System.out.println("===============");
        app.nameContainsOriginal("Hello from code");
        System.out.println("===============");
        app.nameContainsIgnoreCaseOriginal("Hello from code");
        System.out.println("===============");
        app.nameMatchesOriginalA("regex match A");
        System.out.println("===============");
        app.nameMatchesOriginalB("regex match B");
        System.out.println("===============");
        app.nameMatchesOriginalC("regex non-match C");
        System.out.println("===============");
        app.redirectArgumentsOriginal("redirect arguments");
        System.out.println("===============");
        app.redirectNoArgumentsOriginal("redirect no arguments");
        System.out.println("===============");
        app.redirectThisOnlyOriginal("redirect this only");
        System.out.println("===============");
        app.redirectThisAndArgumentsOriginal("redirect this and arguments");
        System.out.println("===============");
        app.enterArgumentsOriginal("enter arguments");
        System.out.println("===============");
        app.enterNoArgumentsOriginal("enter no arguments");
        System.out.println("===============");
        app.enterThisOnlyOriginal("enter this only");
        System.out.println("===============");
        app.enterThisAndArgumentsOriginal("enter this and arguments");
        System.out.println("===============");
        app.exitArgumentsOriginal("exit arguments");
        System.out.println("===============");
        app.exitNoArgumentsOriginal("exit no arguments");
        System.out.println("===============");
        app.exitThisOnlyOriginal("exit this only");
        System.out.println("===============");
        app.exitThisAndArgumentsOriginal("exit this and arguments");
        System.out.println("===============");
        System.out.println(app.redirectArrayOriginal("redirect array", 1));
        System.out.println("===============");
        app.enterArrayOriginal("enter array", 2);
        System.out.println("===============");
        app.exitArrayOriginal("exit array", 3);
        System.out.println("===============");
    }

    public void defaultMatcherOriginal(String value) {
        printOriginal("default nameContains", value);
    }

    public void namedOriginal(String value) {
        printOriginal("named", value);
    }

    public void namedIgnoreCaseOriginal(String value) {
        printOriginal("namedIgnoreCase", value);
    }

    public void nameStartsWithOriginal(String value) {
        printOriginal("nameStartsWith", value);
    }

    public void nameStartsWithIgnoreCaseOriginal(String value) {
        printOriginal("nameStartsWithIgnoreCase", value);
    }

    public void nameEndsWithOriginal(String value) {
        printOriginal("nameEndsWith", value);
    }

    public void nameEndsWithIgnoreCaseOriginal(String value) {
        printOriginal("nameEndsWithIgnoreCase", value);
    }

    public void nameContainsOriginal(String value) {
        printOriginal("nameContains", value);
    }

    public void nameContainsIgnoreCaseOriginal(String value) {
        printOriginal("nameContainsIgnoreCase", value);
    }

    public void nameMatchesOriginalA(String value) {
        printOriginal("nameMatches", value);
    }

    public void nameMatchesOriginalB(String value) {
        printOriginal("nameMatches", value);
    }

    public void nameMatchesOriginalC(String value) {
        printOriginal("nameMatches", value);
    }

    public String redirectArgumentsOriginal(String value) {
        return originalResult(value);
    }

    public String redirectNoArgumentsOriginal(String value) {
        return originalResult(value);
    }

    public String redirectThisOnlyOriginal(String value) {
        return originalResult(value);
    }

    public String redirectThisAndArgumentsOriginal(String value) {
        return originalResult(value);
    }

    public void enterArgumentsOriginal(String value) {
        printOriginal("enter arguments", value);
    }

    public void enterNoArgumentsOriginal(String value) {
        printOriginal("enter no arguments", value);
    }

    public void enterThisOnlyOriginal(String value) {
        printOriginal("enter this only", value);
    }

    public void enterThisAndArgumentsOriginal(String value) {
        printOriginal("enter this and arguments", value);
    }

    public void exitArgumentsOriginal(String value) {
        printOriginal("exit arguments", value);
    }

    public void exitNoArgumentsOriginal(String value) {
        printOriginal("exit no arguments", value);
    }

    public void exitThisOnlyOriginal(String value) {
        printOriginal("exit this only", value);
    }

    public void exitThisAndArgumentsOriginal(String value) {
        printOriginal("exit this and arguments", value);
    }

    public String redirectArrayOriginal(String value, int number) {
        return value + number;
    }

    public void enterArrayOriginal(String value, int number) {
        printOriginal("enter array", value + ", " + number);
    }

    public void exitArrayOriginal(String value, int number) {
        printOriginal("exit array", value + ", " + number);
    }

    public static void defaultMatcherRedirected(String value) {
        printRedirected("default nameContains", value);
    }

    public static void namedRedirected(String value) {
        printRedirected("named", value);
    }

    public static void namedIgnoreCaseRedirected(String value) {
        printRedirected("namedIgnoreCase", value);
    }

    public static void nameStartsWithRedirected(String value) {
        printRedirected("nameStartsWith", value);
    }

    public static void nameStartsWithIgnoreCaseRedirected(String value) {
        printRedirected("nameStartsWithIgnoreCase", value);
    }

    public static void nameEndsWithRedirected(String value) {
        printRedirected("nameEndsWith", value);
    }

    public static void nameEndsWithIgnoreCaseRedirected(String value) {
        printRedirected("nameEndsWithIgnoreCase", value);
    }

    public static void nameContainsRedirected(String value) {
        printRedirected("nameContains", value);
    }

    public static void nameContainsIgnoreCaseRedirected(String value) {
        printRedirected("nameContainsIgnoreCase", value);
    }

    public static void nameMatchesRedirected(String value) {
        printRedirected("nameMatches", value);
    }

    public static String redirectArgumentsDestination(String value) {
        return destinationResult("redirect arguments", value);
    }

    public static String redirectNoArgumentsDestination() {
        return destinationResult("redirect no arguments", "not captured");
    }

    public static String redirectThisOnlyDestination(Object receiver) {
        return destinationResult("redirect this only", receiver.getClass().getSimpleName());
    }

    public static String redirectThisAndArgumentsDestination(Object receiver, String value) {
        return destinationResult("redirect this and arguments", receiver.getClass().getSimpleName() + ", " + value);
    }

    public static void enterArgumentsDestination(String value) {
        printHook("enter arguments", value);
    }

    public static void enterNoArgumentsDestination() {
        printHook("enter no arguments", "not captured");
    }

    public static void enterThisOnlyDestination(Object receiver) {
        printHook("enter this only", receiver.getClass().getSimpleName());
    }

    public static void enterThisAndArgumentsDestination(Object receiver, String value) {
        printHook("enter this and arguments", receiver.getClass().getSimpleName() + ", " + value);
    }

    public static void exitArgumentsDestination(String value) {
        printHook("exit arguments", value);
    }

    public static void exitNoArgumentsDestination() {
        printHook("exit no arguments", "not captured");
    }

    public static void exitThisOnlyDestination(Object receiver) {
        printHook("exit this only", receiver.getClass().getSimpleName());
    }

    public static void exitThisAndArgumentsDestination(Object receiver, String value) {
        printHook("exit this and arguments", receiver.getClass().getSimpleName() + ", " + value);
    }

    public static String redirectArrayDestination(Object[] arguments) {
        return destinationResult("redirect array", formatArguments(arguments));
    }

    public static void enterArrayDestination(Object[] arguments) {
        printHook("enter array", formatArguments(arguments));
    }

    public static void exitArrayDestination(Object[] arguments) {
        printHook("exit array", formatArguments(arguments));
    }

    private static String formatArguments(Object[] arguments) {
        return arguments[0] + ", " + arguments[1] + " (" + arguments[1].getClass().getSimpleName() + ")";
    }

    private static void printOriginal(String matcher, String value) {
        System.out.println("original using " + matcher + ": " + value);
    }

    private static void printRedirected(String matcher, String value) {
        System.out.println("redirected using " + matcher + ": " + value);
    }

    private static String originalResult(String value) {
        System.out.println("original: " + value);
        return value;
    }

    private static String destinationResult(String example, String received) {
        System.out.println("destination " + example + " received: " + received);
        return received;
    }

    private static void printHook(String example, String received) {
        System.out.println("hook " + example + " received: " + received);
    }
}

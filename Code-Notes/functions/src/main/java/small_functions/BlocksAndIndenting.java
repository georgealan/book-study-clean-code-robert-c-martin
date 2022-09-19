package small_functions;

public class BlocksAndIndenting {
    /*
    Functions should be short, the more short that they can be, more shortly better!
    A good practice is that the blocks with if, else, while statements and so on should be one line long.
    Is good to use a function call, because its add documentary value, its easier to read if has a nicely
    descriptive name. Se one example below:
     */

    public static String renderPageWithSetupsAndTeardowns(PageData pageData, boolean isSuite) {
        if (isTestPage(pageData)) {
            includeSetupAndTeardownPages(pageData, isSuite);
        }
        return pageData.getHtml();
    }
    /*
    Functions should do only one thing, like the example above, if a function is doing a lots of things
    is confusing, and hard to grasp the meaning of that function. There are one rule:

    FUNCTIONS SHOULD DO ONE THING. THEY SHOULD DO IT WELL. THEY SHOULD DO IT ONLY.
     */












    // Leave aside the code below, I create only for illustrate the example above.
    public static boolean isTestPage(PageData pageData) {
        if (containText(pageData)) {
            return true;
        }
        return false;
    }
    public static void includeSetupAndTeardownPages(PageData pageData,  boolean isSuite) {}
    public static String getHtml(String text) { return text; }
    public static boolean containText(PageData text) { return false; }
}
class PageData {
    String getHtml() { return "<html>"; }
}

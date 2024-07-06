package lt.techin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TestSearch extends TestSetup {

    //!!!!All tests are practice example only.

    @Test
    void searchSingleValidName() {
        //Searching for "banana". Expected result is item Banana displayed.
        String searchItem = "banana";

        greenKart.setSearchField(searchItem);

        //prints valid search result list
        System.out.println(greenKart.validSearchResult(searchItem));

        //new list to collect names after page search
        List<String> listAfterSearch = greenKart.listOfTitles();
        //prints list of page result for visual comparison in console
        System.out.println(listAfterSearch); //print list of page results

        Assertions.assertEquals(greenKart.validSearchResult(searchItem), listAfterSearch);
    }



    @Test
    void searchThreeValidChars() {
        //Searching for "ato". Expected result "Tomato", "Potato"
        String searchItem = "ato";

        greenKart.setSearchField(searchItem);

        //prints valid search result list
        System.out.println(greenKart.validSearchResult(searchItem));

        //new list to collect names after page search
        List<String> listAfterSearch = greenKart.listOfTitles();
        //prints list of page result for visual comparison in console
        System.out.println(listAfterSearch); //print list of page results

        Assertions.assertEquals(greenKart.validSearchResult(searchItem), listAfterSearch);

    }

    @Test
    void searchThreeInvalidChars() {
        //searching for "are". Expected result is empty list
        String searchItem = "are";

        greenKart.setSearchField(searchItem);

        //prints valid search result list
        System.out.println(greenKart.validSearchResult(searchItem));

        //new list to collect names after page search
        List<String> listAfterSearch = greenKart.listOfTitles();
        //prints list of page result for visual comparison in console
        System.out.println(listAfterSearch); //print list of page results

        Assertions.assertEquals(greenKart.validSearchResult(searchItem), listAfterSearch);

    }


    @Test
    void searchSymbol() {
        //Testing searching symbols "*". Expected empty list
        String searchItem = "*";

        greenKart.setSearchField(searchItem);

        //prints valid search result list
        System.out.println(greenKart.validSearchResult(searchItem));

        //new list to collect names after page search
        List<String> listAfterSearch = greenKart.listOfTitles();
        //prints list of page result for visual comparison in console
        System.out.println(listAfterSearch); //print list of page results

        Assertions.assertEquals(greenKart.validSearchResult(searchItem), listAfterSearch);
    }


    // test is commented because digits are searched in price and discount price fields
//    @Test
//    void searchDigits() {
//        //Searching for digits. Expected result is empty list.
//        String searchItem = "2";
//
//        greenKart.setSearchField(searchItem);
//
//        //prints valid search result list
//        System.out.println(greenKart.validSearchResult(searchItem));
//
//        //new list to collect names after page search
//        List<String> listAfterSearch = greenKart.listOfTitles();
//        //prints list of page result for visual comparison in console
//        System.out.println(listAfterSearch); //print list of page results
//
//        Assertions.assertEquals(greenKart.validSearchResult(searchItem), listAfterSearch);
//
//    }

}

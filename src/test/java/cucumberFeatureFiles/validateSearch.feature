Feature: Search Engine Test
#----------- Test integrated with CI/CD Pipeline using Jenkins

#Git and Jenkins Integrated for CI/CD Pipeline test
@SearchTest
 Scenario Outline: Perform search operation using any keyword
 
    Given I navigate to <search_engine_name> search page
    When I enter "<search_string>" in the "<search_engine_name>" textbox
  	 And I click on the search button in the "<search_engine_name>" page
   	Then verify the "<search_engine_name>" search results return "<search_string>"

    Examples: 
      #------------------------------------------#
      | search_engine_name  |    search_string   |
      #------------------------------------------#
      | 			  google 	 	  |   QA Automation    |
      | 		  	yahoo			  |     Selenium       |
      |			    google      |     08817          |
      | 			   bing			  |   iPhone 15 Pro    |

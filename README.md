This is an automation of the Account creation process.

## Technologies used
Java
Selenium
chromedriver
Apache Maven
junit
Testng
Intellij IDEA community edition
## File structure
We created axis package in the src/test/java folder. This axis package houses two other packages; webpages and configuration. The webpage package contains the pageobjects for the different pages automated; Login class, Account class, Account details class, Account contact class, etc

### Login class
This logs in the user in. There are several WebElements used in this class; Username, password, remember me and login_button WebElements.

### Methods in Login class
setUsername inputs a particular name into the username field using the username web element,

setPassword inputs the password into the password field with the password web element,

setLogin_button clicks the login button webelement to login the user.

### Account class
This creates a new account in the account tab after clicking on the account tab in the navigation bar. The Webelements used here are;  new_account, accounts, account_name_inputs and save_button.

### Methods in Account class
clickAccount gets the href attribute of the accounts webelement and goes to the address because clicking the webelement gave lots of errors.

clickNew clicks on the new account button in the Account tab using the new_account webelement.

setAccount_name_inputs inputs the Account name in to the account name input field with the account_name_inputs webelement.

Then clickSave_button clicks the save_button web element to save the account being created.

### Account_details class
This fills the account details page with relevant in formation.

### Methods in Account_details class
clickEdit clicks the edit_button webelement to start filling the input fields.

scroll_down scrolls the page down so that the next methods will work because if the webelements can be located, there will be an error. 

setAccount_phone, setAccount_website, setAccount_fax fills the phone, website and fax input fields respectively.

The clickSave_edit clicks the save_button webelement to save the information.

### Account_contacts class
This handles the events in the contacts tab.

### Methods in Account_contacts class
clickContacts_nav clicks the contacts navigation bar under the account tab. scroll_up scrolls the page up to access the webelements that will be used next.

add_newContacts clicks the new contact button.

setDropdown clicks on the title input field to bring up the dropdown.

pickDropdown picks an item from the dropdown list,

setLastname inputs lastname into the input field.

clickSave_edit clicks the save button to save the contact.



## Step-by-step guide
Add the steps involved:

- Clone the project from the repository on gitlab with this link
- Install the dependencies in the pom.xml file.
- Make sure the chromedriver.exe file is in the resources folder.
- The chromedriver will only work if your chrome browser version is 92.0.4***.***
- run the LoginAndAccountTest.java file to start the automation.


## Deliverable
- Test plan
- Test case
- Bug report
- Test summary report
## Documents
- Test report
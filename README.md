# boba-shop-crm  
Tech stack or tools: clearDB, MySQL Workbench, Java IntelliJ, React.js, JPA & Hibernate  
Name of the project: boba-shop-crm  
Names of the team members: Yizhen Gu, Jingyu Luo  
Description of the project: This crm system allows us to do all CRUD operations on the tables (users, orders and drinks). From the user interface, we can go to all orders details within a given user (one-to-many), or all drinks placed within a given order (many-to-many).  
Link to the UML diagram: [Final Project UML diagram](https://lucid.app/documents/view/fc7abf3c-871f-427c-b4f0-7529df086b44)  
Description of user data model: the user table has some normal fields like: firstname, lastname, date_of_birth, etc.  
Description of two domain object data models: One is the order table, which has fields like: drinks that have been ordered, the total amount, who placed this order, etc.  
Another one is the drink table, which stores some basic information about the drink, like its name, price, etc.  
Description of the domain object to domain object relationship:  
order to drink is a many-to-many relationship, meaning for each order it can have many different drinks, and different drinks can appear on different orders.  
Description of the portable enumerations: the types of the drink, like cola, water or boba tea, etc.  

Description of the user interface requirements:  
User List: displays a list of all users  
User editor: displays a particular user for editing or allows creating a new user, and the bottom link can navigate to a list of all orders for that user  
Order List - displays a list of all the orders  
Order Editor - displays a particular order for editing or allows creating a new order, and navigate to drinks for that order  
Drink List - displays a list of all drinks or the drinks that placed by a specific order  
Drink Editor - displays a particular drink for editing or allows creating a new drink, and navigate to orders that have placed this drink  

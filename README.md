# boba-shop-crm  
tech stack or tools: clearDB, MySQL Workbench, Java IntelliJ  
*Name of the project*: boba-shop-crm  
Names of the team members: Yizhen Gu, Jingyu Luo  
Description of the project: This crm system allows us to do CRUD operations for our three tables (users, orders and drinks),  
the UI allows us to go to all orders details within a given user, or all drinks placed within a given order.  
Link to the UML diagram: https://lucid.app/documents/view/fc7abf3c-871f-427c-b4f0-7529df086b44  
Description of user data model: the user table has some normal fields like: firstname, lastname, date_of_birth, etc.  
Description of two domain object data models: One is the order table, which has fields like drinks that have been ordered, the total amount, who placed this order, etc.  
The other one is the drink table, which stores some basic information of rach drink, like its name, price, and etc.  
Description of the domain object to domain object relationship:  
order to drink is a many-to-many relationship, meaning for each order it can have different kinds of drinks, and different drinks can appear on different orders.  
Description of the portable enumerations: the types of the drink, like cola, water or boba tea, etc.  
Description of the user interface requirements: #TODO#  



EDUCATIONAL-JSF

Web application to managing a simple inventory. (Eclipse IDE Version: 2019-09, jre 8, deploy and run on TomEE application server,
upgrade of Tomcat for EJB support)

This project is a good example because it implement DAO-DTO pattern and use some JavaEE tools, like Maven for include library by dependencies, Primefaces,
Java Bean, JSF Bean (no Spring framework).

Index.xhtml page, so as all the other web page, have a simple css based template; here user can select some service like searching,
adding or delete an item (product in the application) memorized on server storage space, in txt file format.

Search service allow to find an object between some categories by a java method running on server and respond with number 
of items that are in archive. Search.xhtml page pass product category and name of product by a JSF bean to a service.class; in this class
there are injected elements and methods of the EJB dao class and dto class to this purposes: search method, only on first call, read an 
external .txt file named with category of product (or create it if not present), and paste every string of its row, one by one, in 
a java collection arraylist. Here the research happen.

Add service allow to chose category of product, insert name and quantity to add in the inventary; Operating with JSF bean, recall 
a method in service class to write name of product in a row of same storage file and in the previous java collection object.

Delete service permit to remove a specific quantity of product in relative category. If quantity is more than effective quantity of 
product added, browser show this advertise, and do nothing in the inventory, otherwise show quantity, name and type of product removed. 

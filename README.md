Blog
====
A simple blog application write in Spring-boot Framework, Course Master E-Services J2EE project.

###Resources

[Spring-boot-samples](https://github.com/spring-projects/spring-boot/tree/1.1.x/spring-boot-samples)

[Bootstrap](http://getbootstrap.com/)

###Project Structure

```java
-src
	-main
		-java
			-blog
				-config				{ Configuration for each componant in blog application }
				-mvc				{ Web mvc controllers }
					HomeController.java	{ Home page controller, including listing blogs }
					BlogController.java	{ Blog controller, including blogs CRUD operation }
				-rest				{ REST Service controllers }
						
				-domain 			{ Entity, objects }

				-service			{ Level Service }
					repository 		{ Repository for all entities }
				-jms 				{ JMS Service }
			Application.class 			{ Global configuration, project open class }
		-resources
			-static					{ Static resources }
				-css
				-font
				-images
				-js
				-database
			-templates				{ Thymeleaf templates resoureces }
				layout.html 			{ The global layout file }
				-common
					menu.html
					header.html
					resouces.html // traitement dynamique de resources statique
					....
				-view
					post.html
					home.html
					login.html
					register.html
					setting.html

###Expected Functions

1. Create a blog and list it at the home page (basic)
2. Create comments on a blog (basic) comments on comments (advanced)
3. Give tags to a blog, key words (advanced)
4. Connection with Facebook, Twitter, like (basic), login with account (basic), post tweet or news (advanced)
5. Login and register (basic)



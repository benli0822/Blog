Blog
====
Blog

Sample en ligne tous les exemples
https://github.com/spring-projects/spring-boot/tree/1.1.x/spring-boot-samples

src
	main
		java
			blog
				config
					Database.class // chaque partie une configuration
				mvc

				rest

				domain // toutes les entitys

				service
					repository
				jms
			Application.class

		resources
			static
				css
				font
				images
				js
				database
			templates
				layout
					layout.html
					...
				common
					menu.html
					header.html
					resouces.html // traitement dynamique de resources statique
					....
				view
					post.html
					home.html
					login.html
					register.html
					setting.html
					...




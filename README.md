# FORUM
## Introduction

This Forum-Api project is an individual project conducted within the scope of training conducted by Software Development Academy (SDA), KTU and Novare Potential. In this project created the backend for a developer news site where users can **create articles, comment them**.
## Objectives

Using the basic structure of a Spring application, building, testing and consuming rest APIs , ORM (object relational mapping)  and fundamental software design principles.

## Technologies and tools 

* Spring (boot)
* PostgreSQL
* Postman (for API testing)
* Docker


## Project Scope

A new Spring project is started using the Spring launcher. **Gradle and java 11** were used.

* Spring Web
* Spring JPA
* PostgreSQL Driver

### Article

The article is the main element of the project. An article object has the following fields:

the **title** of the article (String).

body text **body** of the article (String).

**authorName** The name of the author who created the article (String).

Created a REST API for articles with the following specification:
HTTP Method | HTTP Path | Action
------------ |----------- | ----------
GET   |articles   | return all articles.
GET   |articles/{id}  | return a specific article based on the provided id.
POST   |articles    | create a new article.
PUT   |articles   | update the given article.
DELETE  |articles  |  delete the given article.


### Comment

Visitors can comment the different articles. **Each article can have zero or more comments. Comment and Article classes have a ManyToOne relationship.** The comment object has the following fields:

**id**

**body** the comment text body (String)

**authorName** the name of the author of the comment
HTTP Method | HTTP Path | Action
------------ |----------- | ----------
GET|comments| return all comments.
GET |comments?articleId={articleId} |return all comments with the given articleId.
POST   |comments   | create a new comment.
PUT     |comments   |update the given comment.
DELETE  |comments   |delete the given comment.



### Topics

Articles are categorized by topics. **Each topic can have many articles and each article can belong to many topics. Topic and Article classes have a ManyToMany relationship.** A topic object will have the following fields:

**id**

**name** topic name (String)

HTTP Method | HTTP Path | Action
------------ |----------- | ----------
GET|    topics  | return all topics.
GET   | topics?articleId={articleId}  | return all topics related with the given articleId.
POST  | topics   | create a new topic.
PUT   | topics    | update the given topic.
DELETE  | topics    | delete the given topic.
GET     |articles?topicId={topicId} | return all articles with the given topicId.*


## UML Diagram



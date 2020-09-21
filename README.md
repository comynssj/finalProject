# EasyInventory

## Introduction
EasyInventory allows a user to add a category to the inventory database and then begin adding items along with small descriptions and quantities. This application is intended for users who aren’t computer savvy and is aimed to be simple and user friendly.

## Storyboard
Storyboard :
	
Landing Page/After hitting the plus button below your bottom category


The view of the category with the ability to edit the name. It displays the how many different items have been entered along with how many total there are.

	
After the user tries to add a new item under Masks

	
After opening a dropdown and selecting an item from the list

## Requirements

*As a user, I want to be able to add new categories to my inventory for different items so that I can organize the items that I sell.*

**Given:** The user can contact the inventory data
**When:** The user adds a new category
**Then:** The category is added to the category list and is now available to add items to.

*As a user, I want to be able to add new items to each category so that I can see all related items..*

**Given:** The user can contact the inventory data
**When:** adds a new item to a category
**Then:** The items name, quantity and notes are added to the category alphabetically.

*As a user, I want to be able to edit and delete the items from the list under a category so that I can change the name or get rid of a category should my needs change.*

**Given:** The user can contact the inventory data
**When:** Selects an item from the list under a category 
**When:** The user is presented with the item name, the quantity and the notes for the given item
**Then:** They can edit the items information or delete the item from the category.

## Class Diagram 


-com.easyinventory.ui

	The UI will allow the user to edit the categories and items within the database. The views available to them are the landing/category adding page, the category view and item view.

-com.easyinventory.dto
	
	The DTO will model the objects into categories and items. Categories have a name, an id and a list of items. While items have a category Id, an item id, a name, a quantity and notes.

-com.easyinventory.dao
	
	The DAO will be the transfer between our service and the database, it will grab our data from the database using queries and use the DTO to build it into our objects.

-CategoryDatabase
	
	Database for holding our categories with their respective name/id.

-ItemDatabase
	
	Database for holding our items, related through our category id. This will hold all the information for an item including the categoryid, itemid, name, quantity and notes.


## JSON Schema

{
  "categories": {
    "masks": {
      "0": {
        "categoryId": 0,
        "itemId": 0,
        "name": "",
        "quantity": 0,
        "notes": ""
      }
    },
    "plants": {
      "1": {
        "categoryId": 0,
        "itemId": 0,
        "name": "",
        "quantity": 0,
        "notes": ""
      }
    }
  }
}

## Scrum Roles

UI Specialist: Spencer Comyns
Business Logic Persistence Specialist: Anthony Nagal
Product Owner/Scrum Master/DevOps/GitHub Administrator: Spencer Comyns

## Team Standup

Will be conducted every Wednesday at 4pm on Microsoft Teams











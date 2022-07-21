# mobile
Demo application

## Functionalities:

1. Get all mobiles (ordered by mobile name ascending)
2. Update certain mobile (by id)

The list of mobiles should be unique - to solve that I used Set as a preferable Collection, because the set is collection of unique elements.
Since the order of the items within a set is very important to us I have used LinkedHashSet as an implementation of the Set collection. 

Unit test cases for each scenario. You can take a look inside java/com/mobile/service/service/MobileServiceTest.java to see test cases.
Also, you can see applied new Java features (var, streams ...)
 
Set of mobiles is orderered by using stream functions like 'sorted'. In normal work conditions I would sort that list using JPA on Repository layer. 


## RUN

Import Right click on java/com/mobile/service/Application.java and click on Run'Application.main()'. Java 17 used for this solution. 

# REST API


###### GET /api/mobiles (http://localhost:8080/api/mobiles/)

###### PATCH /api/mobiles/{id} (http://localhost:8080/api/mobiles/{id}) - if you provide id that does not exist in our system you will get 404 (NOT_FOUND) response status with message: 

## Note - take a look at java/com/mobile/service/utils/MockUtils.java to check out what are IDs that we are supporting. 

```
{
    "message": "Mobile with {providedId} does not exist."
}
```

if you provide name that already exist (Mobiles should be unique) you will get 409 (CONFLICT) response status with message:

```
{
    "message": "Mobile with name {providedName} already exists! Choose other name."
}
```

###### Last but not least note - I never commit on main branch, this is an exception! :D 

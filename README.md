# Server Test (Scala)


This test assignment is designed around an ad serving scenario.
When an ad is served, an impression tracking event is fired to the server.
You are supposed to create endpoints for saving the impression, retrieving it , counting it and calculating charges.

### Endpoints needed for the solution (given in their order of importance)

|  URL  (sample)                          | Description                                                  |
| --------------------------------------- | ------------------------------------------------------------ |
| /impression                             | For saving the impression                                    |
| /impression/1                           | Returning Saved Impression                                   |
| /count/bidder/appnexus/date/2019-09-13  | Returning number of impressions for that bidder on that date |
| /charges                                | Returns the charges for all impressions  present in DB       |


You should **NOT** add any extra libraries to ```build.sbt``` to complete this task.
This code is simplified from what could be on production systems.
Once you are finished, please add your notes towards the bottom of this ```README.md``` file.
This could include thoughts, concerns, limitations, risks, issues of what has been submitted, specifically
around what happens if this code is moved to production.

### Project structure
```
├── README.md
├── app
│   ├── common
│   │   └── Module.scala
│   └── track
│       ├── ImpressionRepository.scala
│       ├── ChargeCalculator.scala
│       ├── api
│       │   └── ImpressionApi.scala
│       └── domain
│           └── Impression.scala
│           └── ImpressionCharge.scala
├── build.sbt
├── conf
│   ├── application.conf
│   ├── evolutions
│   │   └── default
│   │       └── 1.sql
│   │       └── 2.sql
│   ├── logback.xml
│   └── routes
├── project
│   ├── build.properties
│   ├── plugins.sbt
└── test

```

### Running project

* Use `sbt run` to run the project
* Use `sbt test` to run tests

### Calculating charges (charges endpoint)

What is the fun in storing impression if we can't charge? :-). So in this hypothetical situation we are going to charge like this. 

| Time Frame     | Charges | Comments             |
| -------------- | ------- | ---------------------|
| 7-9am          | 0.11    | Morning charge       |
| 6-9pm          | 0.12    | Evening charge       |
| Rest of time   | 0.10    | Default charge       |
| Weekend Charge | 0.04    | In addition to above |

this calculation will be needed to return appropriate values when charges endpoint is called. 

### Testing the endpoints

To test that it is working

**Impression Endpoint**

``` 
 curl -X POST \
  http://localhost:9000/impression \
  -H 'Content-Type: application/json' \
  -d '{
      "placement-id": "ABC123",
      "bidder": "appnexus"
  }'
``` 

should return Json of the form

``` 
    {
        "impression-id": 1
    }
```

**To get the impression**

```
curl -X GET http://localhost:9000/impression/1 
```

should return Json of the form

```
{
       "id": 1,
       "placement-id": "ABC123",
       "bidder": "appnexus",
       "timestamp": "2019-09-13T20:30:00.98"
   }
```

If impression not found then should return
Http 4xx with  Json of the form
```
{
    "status": "failed",
    "message": "Couldn't find impression 1"
} 
```

**To get the count**

```
curl -X GET http://localhost:9000/count/bidder/appnexus/date/2019-09-12T07:30:01
```

should return
```
{ "impression-count": 2}
```
depending on number of impressions saved. For example in this case 2 impressions were saved. 

If impressions were not found then need to return 
Http 4xx with  Json of the form
```
{
    "status": "failed",
    "message": "Couldn't find impressions for that bidder randomBidder for day 2019-09-13"
}
```

**To get charges**

``` 
curl -X GET http://localhost:9000/charges 
```
should  return Json of the form
```
[
    {
        "id": 1,
        "timestamp": "2019-09-12T07:30:00",
        "rate": 0.11
    },
    {
        "id": 2,
        "timestamp": "2019-09-12T13:30:00",
        "rate": 0.1
    },
    {
        "id": 3,
        "timestamp": "2019-09-12T18:00:00",
        "rate": 0.12
    },
    {
        "id": 4,
        "timestamp": "2019-09-14T07:30:00",
        "rate": 0.15
    },
    {
        "id": 5,
        "timestamp": "2019-09-14T13:30:00",
        "rate": 0.14
    },
    {
        "id": 6,
        "timestamp": "2019-09-14T18:00:00",
        "rate": 0.16
    },
    {
        "id": 7,
        "timestamp": "2019-09-15T07:30:00",
        "rate": 0.15
    }
]
```
when the objects mentioned in 2.sql file is present in db (Remember to add your sql insert statements there)

### Testing

We have added  specs2 and scala-test packages for you. Please add your tests in ```test``` directory.